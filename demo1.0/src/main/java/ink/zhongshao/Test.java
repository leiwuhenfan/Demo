package ink.zhongshao;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 正则验证
 * 
 * @author zs
 * @date 2020年8月26日
 */
public class Test {

	// 大小写字母 数字 下划线 括号 长度 30
	private String regex = "^[a-zA-Z\\d_()\\u4e00-\\u9fa5]{1,30}$";
	private Pattern pattern = Pattern.compile(regex);

	void math() {
		Matcher m = pattern.matcher("喊aZAz901()_");
		boolean result = m.matches();

		// System.out.println("-----" + result);
	}

	void math2() {
		String regex = "^[a-zA-Z\\d_()\\u4e00-\\u9fa5]{1,30}$";

		// 需要对regex进行null判断
		Pattern pattern = Pattern.compile(regex); // 验证不为null
		Matcher m = pattern.matcher("喊aZAz901()_");
		boolean result = m.matches();

		// System.out.println("-----" + result);
	}

	public static void main(String[] args) {

		Test test = new Test();
		
		/**
		 * 
		 * 【强制】在使用正则表达式时，利用好其预编译功能，可以有效加快正则匹配速度。
		 *      说明：不要在方法体内定义：Pattern pattern = Pattern.compile(“规则”);
		 * 
		 */
		Long start1 = System.currentTimeMillis();
		for (int i = 0; i < 12000000; i++) {
			test.math();//使用compile预编译提升性能
		}
		Long end1 = System.currentTimeMillis();
		System.out.println("  pattern类变量的耗时: =   " + (end1 - start1));

		
		
		Long start2 = System.currentTimeMillis();
		for (int i = 0; i < 12000000; i++) {
			test.math2();
		}
		Long end2 = System.currentTimeMillis();
		System.out.println("  pattern局部变量的耗时: =   " + (end2 - start2));

	}

}
