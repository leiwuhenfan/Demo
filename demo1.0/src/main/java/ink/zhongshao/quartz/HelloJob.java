package ink.zhongshao.quartz;

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

		System.out.println("当前执时间=" + new Date());

		System.out.println("下次执行时间=" + context.getNextFireTime());
	}

}
