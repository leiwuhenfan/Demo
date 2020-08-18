/**
 * 
 */
package ink.zhongshao.sync;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author zs
 * @date 2020年8月17日
 */
public class MyThreadJob2 implements Callable<String> {
	private AtomicInteger atmicInteger = new AtomicInteger(0);

	@Override
	public String call() throws Exception {
		System.out.println("执行==" + Thread.currentThread().getName());

		Random r = new Random();
		for (int i = 0; i < 100; i++) {
			TimeUnit.MICROSECONDS.sleep(r.nextInt(100));
			atmicInteger.getAndIncrement();
		}
		System.out.println(Thread.currentThread().getName() + ":" + atmicInteger.get());

		return null;
	}

}
