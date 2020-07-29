package ink.zhongshao.quartz;

import static org.quartz.CronScheduleBuilder.cronSchedule;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;

public class TestUse {

	public static void main(String[] args) throws SchedulerException, ParseException {
		SchedulerFactory schedFact = new org.quartz.impl.StdSchedulerFactory();

		  Scheduler sched = schedFact.getScheduler();

		  // define the job and tie it to our HelloJob class
		  JobDetail job = newJob(HelloJob.class)
		      .withIdentity("myJob", "group1")
		      .build();

		  // Trigger the job to run now, and then every 40 seconds
			/*
			 * Trigger trigger = newTrigger() .withIdentity("myTrigger", "group1")
			 * .startNow() .withSchedule(simpleSchedule() .withIntervalInSeconds(40)
			 * .repeatForever()) .build();
			 */
		  DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		  Date startDate =  df.parse("2020-07-25 10:10:10");
		  
		  Trigger trigger = newTrigger()
				    .withIdentity("trigger3", "group1")
				    
				    //开始日期--指定从 2020-0715 22:05:25开始，每隔一天执行一次
				    
//				    .withSchedule(cronSchedule("0 0/2 * * * ?"))// 从开始日期开始，每二分执行一次小时为0秒0分执行一次
				    
//				    .withSchedule(cronSchedule("20 27 0/3 * * ?"))// 从开始日期开始，每三小时执行一次小时为0秒0分执行一次
				    
				    //??时间内  也会将最近一次执行推到下一天
//				    .withSchedule(cronSchedule("20 01 14 1/3 * ?"))// 从开始日期开始，每3天执行一次小时为0秒0分执行一次
				    
//				    .withSchedule(cronSchedule("02 03 14 18 1/2 ?"))// 从开始日期开始，每2个月执行一次小时为0秒0分执行一次
				    
				    .withSchedule(cronSchedule("02 03 14 18 1 ? 2020/3"))// 从开始日期开始，每3年执行一次小时为0秒0分执行一次
				    
				    .forJob("myJob", "group1")
				    .startAt(     startDate    )
				    .build();
		  
		  
		  // Tell quartz to schedule the job using our trigger
		  sched.scheduleJob(job, trigger);
		  
		  sched.startDelayed(5);
		  System.out.println("getStartTime======"+trigger.getStartTime());
		  System.out.println("getNextFireTime======"+trigger.getNextFireTime());
		 

	}

}
