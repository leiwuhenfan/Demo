/**
 * 
 */
package ink.zhongshao.sync;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author zs
 * @date 2020年8月17日
 */
public class MyThreadJob implements Callable<String> {
	private Lock lock = new ReentrantLock();

	private int count = 0;

	@Override
	public String call() throws Exception {
		System.out.println("执行===" + Thread.currentThread().getName() );
		lock.lock();
		try {
			Random r = new Random();
			System.out.println("    lock=" + lock.toString()); //lock=java.util.concurrent.locks.ReentrantLock@64086151[Locked by thread pool-1-thread-1]
			for (int i = 0; i < 100; i++) {
				TimeUnit.MICROSECONDS.sleep(r.nextInt(100));
				count++;
//				System.out.println(Thread.currentThread().getName() + ":" + count);
			}
			System.out.println(Thread.currentThread().getName() + ":" + count);
		} finally {
			lock.unlock();
		}
		return null;
	}

}
