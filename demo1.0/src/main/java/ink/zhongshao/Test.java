package ink.zhongshao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Test {

	public static void main(String[] args) {

		List<String> lists  =Collections.EMPTY_LIST,
				lists2=Collections.emptyList();//——返回只读空集合
		
		System.out.println("ddd"+String.join(",", lists));
		
		//以下操作会报错
		lists.add("sss");
		
		
		List<FutureTask<String>> tasks = new ArrayList<>();

		for (int i = 1; i <= 10; i++) {
			MyJob myj = new MyJob("MyJob" + i);
			FutureTask<String> task = new FutureTask<>(myj);
			tasks.add(task);

			Thread t = new Thread(task);
			t.start();
			System.out.println("创建的线程:" + i);
		}

		try {
			Thread.sleep(500000000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		
		
		tasks.stream().forEach((t) -> {
			try {

				String result = t.get();

				if (result != null) {
					System.out.println(result);
				}
			} catch (InterruptedException e) {

				e.printStackTrace();
			} catch (ExecutionException e) {

				e.printStackTrace();
			}
		});

	}

}
