package ink.zhongshao.quartz;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * 执行的任务
 * 
 * @author zs
 *
 */
public class HelloJob implements Job {

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {

		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String startDate = df.format(new Date());
		System.out.println("当前执时间=" + startDate);
		String nextDate = df.format(context.getNextFireTime());
		System.out.println("下次执行时间=" + nextDate);
	}

}
