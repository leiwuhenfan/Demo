package ink.zhongshao;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Test {

	public static void main(String[] args) {

		List<FutureTask<String>> tasks = new ArrayList<>();

		for (int i = 0; i < 10; i++) {
			MyJob myj = new MyJob("MyJob" + i);
			FutureTask<String> task = new FutureTask<>(myj);
			tasks.add(task);

			Thread t = new Thread(task);
			t.start();
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
