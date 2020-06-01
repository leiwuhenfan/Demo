package ink.zhongshao;

import java.util.Date;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class Joda_time {

	public static final String STANDARD_FORMAT = "yyyy-MM-dd HH:mm:ss";

	public static void main(String[] args) {

		// 日期时间
		DateTime datetime = new DateTime();
		System.out.println("当前年份:" + datetime.getYear());
		System.out.println("当前月份:" + datetime.getMonthOfYear());
		System.out.println("当前日期:" + datetime.getDayOfMonth());
		System.out.println("当前小时:" + datetime.getHourOfDay());
		System.out.println("当前分钟:" + datetime.getMinuteOfHour());
		System.out.println("当前秒钟:" + datetime.getSecondOfMinute());

		// 把字符串转成日期
		DateTimeFormatter formatter = DateTimeFormat.forPattern(STANDARD_FORMAT);
		DateTime dateTimeByformatter = formatter.parseDateTime("2020-01-02 10:10:12");
		System.out.println(dateTimeByformatter.toDate());

		// 日期转成字符串
		DateTime dateTime2 = new DateTime(new Date());
		System.out.println(dateTime2.toString(STANDARD_FORMAT));

		// 日期比较

		System.out.println("isAfter:" + dateTimeByformatter.isAfter(dateTime2));
		System.out.println("isBefore:" + dateTimeByformatter.isBefore(dateTime2));

	}

}
