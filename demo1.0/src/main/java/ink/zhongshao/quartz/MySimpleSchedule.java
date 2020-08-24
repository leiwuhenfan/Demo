/**
 * 
 */
package ink.zhongshao.quartz;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

import static org.quartz.SimpleScheduleBuilder.simpleSchedule;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;

/**
 * 
 * 间隔时间 简单任务  的测试()
 * 
 * @author zs
 * @date 2020年8月24日
 */
public class MySimpleSchedule {

	public static void main(String[] args) throws SchedulerException {
		SchedulerFactory schedFact = new org.quartz.impl.StdSchedulerFactory();

		Scheduler sched = schedFact.getScheduler();

		sched.start();

		// define the job and tie it to our HelloJob class
		JobDetail job = newJob(HelloJob.class).withIdentity("myJob", "group1").build();

		// Trigger the job to run now, and then every 40 seconds
		Trigger trigger = newTrigger().withIdentity("myTrigger", "group1")
				
				.startNow()// .startAt(futureDate(10, MINUTES)) 
				
				.withSchedule(
						
						simpleSchedule().
//						withIntervalInSeconds(5) //每隔5秒执行一次任务
//						withIntervalInMinutes(1) //每隔1分钟执行一次任务
						withIntervalInHours(1) //每隔1小时执行一次任务
						
						.repeatForever()).build();

		// Tell quartz to schedule the job using our trigger
		sched.scheduleJob(job, trigger);
	}
}
