/**
 * 
 */
package ink.zhongshao.quartz;

import static org.quartz.CalendarIntervalScheduleBuilder.calendarIntervalSchedule;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.DateBuilder.IntervalUnit;

/**
 * 
 * 每隔 XX时间执行任务    (.withInterval(2, IntervalUnit.YEAR))
 * 
 * @author zs
 * @date 2020年8月24日
 */
public class MyCalendarIntervalSchedule {
	
	private MyCalendarIntervalSchedule() {}

	/**
	 * @param args
	 * @throws SchedulerException 
	 */
	public static void main(String[] args) throws SchedulerException {
		
		SchedulerFactory schedFact = new org.quartz.impl.StdSchedulerFactory();

		Scheduler sched = schedFact.getScheduler();

		sched.start();

		// define the job and tie it to our HelloJob class
		JobDetail job = newJob(HelloJob.class).withIdentity("myJob", "group1").build();

		Trigger trigger = newTrigger().withIdentity("myTrigger", "group1")
				
				.startNow()// .startAt(futureDate(10, MINUTES)) 
				
				.withSchedule(
						calendarIntervalSchedule()
						
						.withInterval(86, IntervalUnit.DAY)

						).build();

		// Tell quartz to schedule the job using our trigger
		sched.scheduleJob(job, trigger);

	}

}
