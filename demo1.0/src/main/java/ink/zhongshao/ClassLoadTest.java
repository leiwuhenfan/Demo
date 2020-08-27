/**
 * 
 */
package ink.zhongshao;

/**
 * @author zs
 * @date 2020年8月28日
 */
public class ClassLoadTest {
	public final static String k;
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
