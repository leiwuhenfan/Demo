/**
 * 
 */
package ink.zhongshao;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * @author zs
 * @date 2020Äê9ÔÂ18ÈÕ
 */
public class TestMaxThread {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

//		ExecutorService serces = Executors.newCachedThreadPool();
//		int n = 1;
//		while (true) {
//			serces.submit(new FutureTask(new MyJob("name=" + n)));
//			n++;
//			System.out.println(n);
//		}
		
		int cpus = Runtime.getRuntime().availableProcessors();
		System.out.println("==="+cpus);
	}

}
