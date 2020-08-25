/**
 * 
 */
package ink.zhongshao.quartz;

import static org.quartz.CalendarIntervalScheduleBuilder.calendarIntervalSchedule;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

import java.util.HashSet;
import java.util.Set;

import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.impl.calendar.DailyCalendar;
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

		/**
		 * 排程器 :
		 * Scheduler 调度程序-任务执行计划表，只有安排进执行计划的任务Job（通过scheduler.scheduleJob方法安排进执行计划），当它预先定义的执行时间到了的时候（任务触发trigger），该任务才会执行。
		 */
		Scheduler sched = schedFact.getScheduler();

		//启动定时任务
		sched.start();

		// define the job and tie it to our HelloJob class
		JobDetail job = newJob(HelloJob.class)
				.withIdentity("myJob", "group1")
				.build();
		
		//只在某个时间段执行15-18
		DailyCalendar dailyCalendar = new DailyCalendar("13:00","18:00");
		dailyCalendar.setInvertTimeRange(false); // false表示排除这时间段
		
		//dailyCalendar.setInvertTimeRange(true); // 时间反转，为true表示只有这次时间段才会被执行，为false表示排除这时间段

		//Calendar 排除日历时间
        sched.addCalendar("dailyCalendar", dailyCalendar, false, false);      
		
		Trigger trigger = newTrigger().withIdentity("myTrigger", "group1")
				.startNow()// .startAt(futureDate(10, MINUTES)) 
				.withSchedule(
						calendarIntervalSchedule()
						.withInterval(1, IntervalUnit.SECOND)
						.withMisfireHandlingInstructionDoNothing() //所有misfire不管  执行下一个周期的任务
						)
				.modifiedByCalendar("dailyCalendar") 
				
				
				.build();

		// Tell quartz to schedule the job using our trigger
		//告诉石英使用我们的触发器安排工作
		sched.scheduleJob(job, trigger);
		
		try {
			Thread.sleep(3000); //休息10秒用于修改任务
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//验证是否存在
		JobKey jobKey = new JobKey("myJob", "group1");
		System.out.println("是否存在: new JobKey(\"myJob\", \"group1\"); ==== "+sched.checkExists(jobKey));
		
		//修改触发器
		dailyCalendar = new DailyCalendar("13:00","18:00");
		dailyCalendar.setInvertTimeRange(true); // false表示排除这时间段
		//Calendar 排除日历时间  (如果存在日历，但replace = false 抛出异常 )
       // sched.addCalendar("dailyCalendar", dailyCalendar, false, false); //???此处抛出异常
        
        sched.addCalendar("dailyCalendar", dailyCalendar, true, false); //
		
		Set<Trigger> triggersForJob = new HashSet<>();
		trigger = newTrigger().withIdentity("myTrigger", "group1")
				.startNow()// .startAt(futureDate(10, MINUTES)) 
				.withSchedule(
						calendarIntervalSchedule()
						.withInterval(1, IntervalUnit.MONTH)
						.withMisfireHandlingInstructionDoNothing() //所有misfire不管  执行下一个周期的任务
						)
				.modifiedByCalendar("dailyCalendar")
				.build();
		triggersForJob.add(trigger);
		
        job = newJob(HelloJob.class)
				.withIdentity("myJob", "group1")
				.build();
        
        
        /*                 任务        触发器                                 是否替换(抛出异常情况: if the job/trigger keys are not unique and the replace flag is not set to true.
        													如果作业/触发键不是唯一的并且替换标志未设置为true) */
		sched.scheduleJob(job, triggersForJob, true);
		
		System.out.println("----------重置触发器/任务完成.......");
		
		try {
			Thread.sleep(30000); //休息10秒用于修改任务
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
