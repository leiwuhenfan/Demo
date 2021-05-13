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

		 System.out.println("-----" + result);
	}

	void math2() {
		String regex = "^[a-zA-Z\\d_()\\u4e00-\\u9fa5]{1,30}$";

		// 需要对regex进行null判断
		Pattern pattern = Pattern.compile(regex); // 验证不为null
		Matcher m = pattern.matcher("喊aZAz901()_");
		boolean result = m.matches();

		 System.out.println("-----" + result);
	}

	/**
	 * 不限制输入8,20位  进行强密码限制，大小写字母+数字
	* @Description 方法描述:  <pre>
	* @return  返回值类型: <pre>  
	* @author 作者: WQ <pre>
	* @date 时间: 2021年4月30日 下午2:58:20 <pre> 
	* @throws 异常: <pre>
	 */
	void math3() {
		/*
		 * String regex = "^(?![0-9]+$)(?![a-zA-Z]+$){8,20}$"; //[0-9A-Za-z] //
		 * 需要对regex进行null判断 Pattern pattern = Pattern.compile(regex); // 验证不为null
		 * Matcher m = pattern.matcher("q2wQdsff!@#$ssf"); boolean result = m.matches();
		 * System.out.println("-----" + result);
		 */
		
		String pswd = "!@5w$控—+a｛LHG~`%^&*(";
		
		System.out.println(strongPswd(pswd));
		
		
	}
	
	/**
	 *  0  48
		9  57
		a  97
		z  122
		A  65
		Z  90
		!  33
		@  64
		#  35
		$  36
		%  37
		^  94
		&  38
		*  42
		(  40
	* @Description 方法描述: @param pswd
	* @Description 方法描述: @return <pre>
	* @return  返回值类型: <pre>  
	* @author 作者: WQ <pre>
	* @date 时间: 2021年4月30日 下午3:36:26 <pre> 
	* @throws 异常: <pre>
	 */
	public boolean strongPswd(String pswd) {

		if (pswd == null) {
			return false;
		}
		int len = pswd.length();
		if (len > 20 || len < 8) {
			return false;
		}
		pswd.toCharArray();
		boolean digit = false;
		boolean lowercase = false;
		boolean upperCase = false;

		for (int i = 0; i < len; i++) {
			int ic = (int) pswd.charAt(i);
			System.out.println(pswd.charAt(i) + "  " + ic);
			if (!digit) {
				if (ic > 47 && ic < 58)
					digit = true;
			}
			if (!lowercase) {
				if (ic > 96 && ic < 123)
					lowercase = true;
			}
			if (!upperCase) {
				if (ic > 64 && ic < 91)
					upperCase = true;
			}
			if (digit && lowercase && upperCase) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {

		Test test = new Test();
		test.math3();
		
		
		
		
		
		
		
		
		
		
		
		/**
		 * 
		 * 【强制】在使用正则表达式时，利用好其预编译功能，可以有效加快正则匹配速度。
		 *      说明：不要在方法体内定义：Pattern pattern = Pattern.compile(“规则”);
		 * 
		 */
		Long start1 = System.currentTimeMillis();
		for (int i = 0; i < 12; i++) {
			test.math();//使用compile预编译提升性能
		}
		Long end1 = System.currentTimeMillis();
		System.out.println("  pattern类变量的耗时: =   " + (end1 - start1));

		
		
		Long start2 = System.currentTimeMillis();
		for (int i = 0; i < 12; i++) {
			test.math2();
		}
		Long end2 = System.currentTimeMillis();
		System.out.println("  pattern局部变量的耗时: =   " + (end2 - start2));

	}

}
