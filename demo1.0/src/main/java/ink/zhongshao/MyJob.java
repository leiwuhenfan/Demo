package ink.zhongshao;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class MyJob implements Callable<String> {

	private String jobName;

	public MyJob(String jobName) {
		super();
		this.jobName = jobName;
	}

	@Override
	public String call() throws Exception {

		System.out.println("Ö´ÐÐÈÎÎñ:" + jobName);

		if (jobName.equals("MyJob3")) {
			TimeUnit.SECONDS.sleep(50000);
		} else {
			TimeUnit.SECONDS.sleep(200000);
		}

		return jobName;
	}

}
