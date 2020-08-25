package ink.zhongshao.quartz;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * 执行的任务
 * 
 * @author zs
 *
 */
//禁用并发执行:不运行并发执行[任务是排队(阻塞)等待执行..., 可以看到现在程序就不会再自己创建线程了，每次都会从线程池里面拿。需注意的是，如果线程池里的所有线程都被拿去执行调度任务了，且又到了时间要执行一次任务，那么这个任务又会被阻塞。]
//@DisallowConcurrentExecution

//不设置：间隔时间到就会执行任务,不管当前任务执行是否完毕，都会重新开启任务执行:如果执行频繁导致数据存储太多而出现oom
public class HelloJob implements Job {

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {

		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String startDate = df.format(new Date());
		String nextDate = df.format(context.getNextFireTime());
		System.out.println(Thread.currentThread().getName()+": 当前执时间=" + startDate);
		/*
		 * try { Thread.sleep(5000); } catch (InterruptedException e) {
		 * e.printStackTrace(); }
		 */
		System.out.println(Thread.currentThread().getName()+": 下次执行时间:" + nextDate);
		
	}

}
