package ink.zhongshao.sync;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @author zs
 * @date 2020年8月13日
 */
public class LockMe {

	public static void main(String[] args) {
		
		/*
		 * ArrayBlockingQueue :
		 *  数组阻塞队列,一个由数组支持的有界阻塞队列。此队列按 FIFO（先进先出）原则对元素进行排序。队列的头部 是在队列中存在时间最长的元素。队列的尾部 是在队列中存在时间最短的元素。新元素插入到队列的尾部，队列获取操作则是从队列头部开始获得元素。
		 *  这是一个典型的“有界缓存区”，固定大小的数组在其中保持生产者插入的元素和使用者提取的元素。一旦创建了这样的缓存区，就不能再增加其容量。试图向已满队列中放入元素会导致操作受阻塞；试图从空队列中提取元素将导致类似阻塞。
                                   此类支持对等待的生产者线程和使用者线程进行排序的可选公平策略。默认情况下，不保证是这种排序。然而，通过将公平性 (fairness) 设置为 true 而构造的队列允许按照 FIFO 顺序访问线程。公平性通常会降低吞吐量，但也减少了可变性和避免了“不平衡性”
		 * DelayQueue :
		 * 	延迟队列，Delayed 元素的一个无界阻塞队列，只有在延迟期满时才能从中提取元素。该队列的头部 是延迟期满后保存时间最长的 Delayed 元素。如果延迟都还没有期满，则队列没有头部，并且 poll 将返回 null。当一个元素的 getDelay(TimeUnit.NANOSECONDS) 方法返回一个小于等于 0 的值时，将发生到期。即使无法使用 take 或 poll 移除未到期的元素，也不会将这些元素作为正常元素对待。例如，size 方法同时返回到期和未到期元素的计数。此队列不允许使用 null 元素
		 * LinkedBlockingQueue ：
		 * 	链阻塞队列，LinkedBlockingQueue 内部以一个链式结构(链接节点)对其元素进行存储。如果需要的话，这一链式结构可以选择一个上限。如果没有定义上限，将使用 Integer.MAX_VALUE 作为上限。
			LinkedBlockingQueue 内部以 FIFO(先进先出)的顺序对元素进行存储。队列中的头元素在所有元素之中是放入时间最久的那个，而尾元素则是最短的那个。
		 * PriorityBlockingQueue ：
		 * 	具有优先级的阻塞队列，一个无界阻塞队列，它使用与类 PriorityQueue 相同的顺序规则，并且提供了阻塞获取操作。虽然此队列逻辑上是无界的，但是资源被耗尽时试图执行 add 操作也将失败（导致OutOfMemoryError）。此类不允许使用 null 元素。依赖自然顺序的优先级队列也不允许插入不可比较的对象（这样做会导致抛出 ClassCastException）。
		 * SynchronousQueue ：
		 * 	 同步队列，SynchronousQueue 是一个特殊的队列，它的内部同时只能够容纳单个元素。如果该队列已有一元素的话，试图向队列中插入一个新元素的线程将会阻塞，直到另一个线程将该元素从队列中抽走。同样，如果该队列为空，试图向队列中抽取一个元素的线程将会阻塞，直到另一个线程向队列中插入了一条新的元素。
		 */
		BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<>(5, true);

		ThreadFactory threadFactory = Executors.defaultThreadFactory();

		RejectedExecutionHandler handler = new ThreadPoolExecutor.AbortPolicy();

		
		/**
		 * 1.先看下机器的CPU核数，然后在设定具体参数：

			System.out.println(Runtime.getRuntime().availableProcessors());
			
			即CPU核数 = Runtime.getRuntime().availableProcessors()
			
			2.分析下线程池处理的程序是CPU密集型，还是IO密集型
			
			CPU密集型：核心线程数 = CPU核数 + 1
			
			IO密集型：核心线程数 = CPU核数 * 2
			
			注：IO密集型（某大厂实践经验）
			
			       核心线程数 = CPU核数 / （1-阻塞系数）     例如阻塞系数 0.8，CPU核数为4
			
			       则核心线程数为20
			
			面试时答上面的就可以，如果面试官继续追问，则说下备注里面我们的实践经验是xxxx
			
			具体程序是CPU密集型，还是IO密集型请参考这篇文章：
			
			https://blog.csdn.net/youanyyou/article/details/78990156
		 */
		
		
		ThreadPoolExecutor threadPool = new ThreadPoolExecutor(4, 12, 2, TimeUnit.SECONDS, workQueue, threadFactory, handler);

		MyThreadJob myThreadJob = new MyThreadJob();
		
		List<Future<String>> jobRes = new ArrayList<>();
		
		Future<String> r1 = threadPool.submit( myThreadJob );
		Future<String> r2 = threadPool.submit( myThreadJob );
		Future<String> r3 = threadPool.submit( myThreadJob );
		
		jobRes.add(r1);
		jobRes.add(r2);
		jobRes.add(r3);
		
		jobRes.stream().forEach((res) -> {
			try {
				res.get();//阻塞
				try {
					res.get(2, TimeUnit.SECONDS);//阻塞设置的时间未响应，直接返回
				} catch (TimeoutException e) {
					e.printStackTrace();
				}
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
		});
		
		
		System.out.println(9999999);
		
		//lock (100 200 300  顺序不定)
		//pool-1-thread-1:100
		//pool-1-thread-3:200
		//pool-1-thread-2:300
		
		//无lock(值不定)
		//pool-1-thread-1:295
		//pool-1-thread-2:297
		//pool-1-thread-3:298
		
		
		//MyThreadJob2 myThreadJob2 = new MyThreadJob2();
		//threadPool.submit(new FutureTask<>( myThreadJob2  )  );
		//threadPool.submit(new FutureTask<>( myThreadJob2  )  );
		//threadPool.submit(new FutureTask<>( myThreadJob2 )  );

		//AtomicInteger	(最终结果一定=300)
		
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		threadPool.shutdown();

	}

}
