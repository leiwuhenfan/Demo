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
 * @date 2020��8��13��
 */
public class LockMe {

	public static void main(String[] args) {
		
		/*
		 * ArrayBlockingQueue :
		 *  ������������,һ��������֧�ֵ��н��������С��˶��а� FIFO���Ƚ��ȳ���ԭ���Ԫ�ؽ������򡣶��е�ͷ�� ���ڶ����д���ʱ�����Ԫ�ء����е�β�� ���ڶ����д���ʱ����̵�Ԫ�ء���Ԫ�ز��뵽���е�β�������л�ȡ�������ǴӶ���ͷ����ʼ���Ԫ�ء�
		 *  ����һ�����͵ġ��н绺���������̶���С�����������б��������߲����Ԫ�غ�ʹ������ȡ��Ԫ�ء�һ�������������Ļ��������Ͳ�������������������ͼ�����������з���Ԫ�ػᵼ�²�������������ͼ�ӿն�������ȡԪ�ؽ���������������
                                   ����֧�ֶԵȴ����������̺߳�ʹ�����߳̽�������Ŀ�ѡ��ƽ���ԡ�Ĭ������£�����֤����������Ȼ����ͨ������ƽ�� (fairness) ����Ϊ true ������Ķ��������� FIFO ˳������̡߳���ƽ��ͨ���ή������������Ҳ�����˿ɱ��Ժͱ����ˡ���ƽ���ԡ�
		 * DelayQueue :
		 * 	�ӳٶ��У�Delayed Ԫ�ص�һ���޽��������У�ֻ�����ӳ�����ʱ���ܴ�����ȡԪ�ء��ö��е�ͷ�� ���ӳ������󱣴�ʱ����� Delayed Ԫ�ء�����ӳٶ���û�������������û��ͷ�������� poll ������ null����һ��Ԫ�ص� getDelay(TimeUnit.NANOSECONDS) ��������һ��С�ڵ��� 0 ��ֵʱ�����������ڡ���ʹ�޷�ʹ�� take �� poll �Ƴ�δ���ڵ�Ԫ�أ�Ҳ���Ὣ��ЩԪ����Ϊ����Ԫ�ضԴ������磬size ����ͬʱ���ص��ں�δ����Ԫ�صļ������˶��в�����ʹ�� null Ԫ��
		 * LinkedBlockingQueue ��
		 * 	���������У�LinkedBlockingQueue �ڲ���һ����ʽ�ṹ(���ӽڵ�)����Ԫ�ؽ��д洢�������Ҫ�Ļ�����һ��ʽ�ṹ����ѡ��һ�����ޡ����û�ж������ޣ���ʹ�� Integer.MAX_VALUE ��Ϊ���ޡ�
			LinkedBlockingQueue �ڲ��� FIFO(�Ƚ��ȳ�)��˳���Ԫ�ؽ��д洢�������е�ͷԪ��������Ԫ��֮���Ƿ���ʱ����õ��Ǹ�����βԪ��������̵��Ǹ���
		 * PriorityBlockingQueue ��
		 * 	�������ȼ����������У�һ���޽��������У���ʹ������ PriorityQueue ��ͬ��˳����򣬲����ṩ��������ȡ��������Ȼ�˶����߼������޽�ģ�������Դ���ľ�ʱ��ͼִ�� add ����Ҳ��ʧ�ܣ�����OutOfMemoryError�������಻����ʹ�� null Ԫ�ء�������Ȼ˳������ȼ�����Ҳ��������벻�ɱȽϵĶ����������ᵼ���׳� ClassCastException����
		 * SynchronousQueue ��
		 * 	 ͬ�����У�SynchronousQueue ��һ������Ķ��У������ڲ�ͬʱֻ�ܹ����ɵ���Ԫ�ء�����ö�������һԪ�صĻ�����ͼ������в���һ����Ԫ�ص��߳̽���������ֱ����һ���߳̽���Ԫ�شӶ����г��ߡ�ͬ��������ö���Ϊ�գ���ͼ������г�ȡһ��Ԫ�ص��߳̽���������ֱ����һ���߳�������в�����һ���µ�Ԫ�ء�
		 */
		BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<>(5, true);

		ThreadFactory threadFactory = Executors.defaultThreadFactory();

		RejectedExecutionHandler handler = new ThreadPoolExecutor.AbortPolicy();

		
		/**
		 * 1.�ȿ��»�����CPU������Ȼ�����趨���������

			System.out.println(Runtime.getRuntime().availableProcessors());
			
			��CPU���� = Runtime.getRuntime().availableProcessors()
			
			2.�������̳߳ش���ĳ�����CPU�ܼ��ͣ�����IO�ܼ���
			
			CPU�ܼ��ͣ������߳��� = CPU���� + 1
			
			IO�ܼ��ͣ������߳��� = CPU���� * 2
			
			ע��IO�ܼ��ͣ�ĳ��ʵ�����飩
			
			       �����߳��� = CPU���� / ��1-����ϵ����     ��������ϵ�� 0.8��CPU����Ϊ4
			
			       ������߳���Ϊ20
			
			����ʱ������ľͿ��ԣ�������Թټ���׷�ʣ���˵�±�ע�������ǵ�ʵ��������xxxx
			
			���������CPU�ܼ��ͣ�����IO�ܼ�����ο���ƪ���£�
			
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
				res.get();//����
				try {
					res.get(2, TimeUnit.SECONDS);//�������õ�ʱ��δ��Ӧ��ֱ�ӷ���
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
		
		//lock (100 200 300  ˳�򲻶�)
		//pool-1-thread-1:100
		//pool-1-thread-3:200
		//pool-1-thread-2:300
		
		//��lock(ֵ����)
		//pool-1-thread-1:295
		//pool-1-thread-2:297
		//pool-1-thread-3:298
		
		
		//MyThreadJob2 myThreadJob2 = new MyThreadJob2();
		//threadPool.submit(new FutureTask<>( myThreadJob2  )  );
		//threadPool.submit(new FutureTask<>( myThreadJob2  )  );
		//threadPool.submit(new FutureTask<>( myThreadJob2 )  );

		//AtomicInteger	(���ս��һ��=300)
		
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		threadPool.shutdown();

	}

}
