/**
 * 
 */
package ink.zhongshao;

/**
 * @author zs
 * @date 2020年8月28日
 */
public class ClassLoadTest {
	public final static String k;//不赋值，在静态块中赋值
	static {
		k = "w";
		System.out.println("k=" + k);
	}

	
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		System.out.println(ClassLoadTest.k);
	}

}
