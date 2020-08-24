/**
 * 
 */
package ink.zhongshao.quartz;

import static org.quartz.DailyTimeIntervalScheduleBuilder.dailyTimeIntervalSchedule;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

import org.quartz.DateBuilder.IntervalUnit;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;

/**
 * 
 * 每日任务:
 * 
 * @author zs
 * @date 2020年8月24日
 */
public class MyDailyTimeIntervalSchedule {

	 
	public static void main(String[] args) throws SchedulerException {
		SchedulerFactory schedFact = new org.quartz.impl.StdSchedulerFactory();

		Scheduler sched = schedFact.getScheduler();

		sched.start();

		// define the job and tie it to our HelloJob class
		JobDetail job = newJob(HelloJob.class).withIdentity("myJob", "group1").build();

		Trigger trigger = newTrigger().withIdentity("myTrigger", "group1")
				
				.startNow()// .startAt(futureDate(10, MINUTES)) 
				
				.withSchedule(
						dailyTimeIntervalSchedule()
//						.withInterval(2, IntervalUnit.DAY) // Invalid repeat IntervalUnit (must be SECOND, MINUTE or HOUR).
						.withInterval(2, IntervalUnit.MINUTE)
						//.onEveryDay()
						).build();

		// Tell quartz to schedule the job using our trigger
		sched.scheduleJob(job, trigger);

	}

}
