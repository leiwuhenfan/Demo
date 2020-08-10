package ink.zhongshao;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

public class Test {

	
	private static Random random = ThreadLocalRandom.current();
	
	
	public static void main(String[] args) {
		System.out.println("0000000000000==");

		// 替换

		String kl = "\\";

		// 斜杠替换，4个\替换(模糊查询使用like ? escape '/' %name%)
		// 前台传入\
		// 后台替换kl.replaceAll("\\\\", "、/\\\\");
		kl = kl.replaceAll("%", "/%");
		kl = kl.replaceAll("_", "/_");
		kl = kl.replaceAll("/", "//");
		kl = kl.replaceAll("\\\\", "/\\\\");

		System.out.println(kl);

		// set添加返回值
		Set<String> acloSets = new HashSet<>();

		System.out.println("acloSets.add(\"1\")=" + acloSets.add("1"));
		System.out.println("acloSets.add(\"1\")" + acloSets.add("1"));
		System.out.println("acloSets.add(\"2\")" + acloSets.add("2"));

		System.out.println("nextInt(10)="+random.nextInt(10));
		
		
		
		
		
		String[]  jk= acloSets.toArray(new String[0]);
		System.out.println(jk);
		
		
		
	}
	
	void testList() {
		
		/*
		【强制】使用集合转数组的方法，必须使用集合的 toArray(T[] array)，传入的是类型完全一致、长度为 0 的空数组。
		反例：直接使用 toArray 无参方法存在问题，此方法返回值只能是 Object[]类，若强转其它类型数组将出现
		ClassCastException 错误。
		正例：
		List<String> list = new ArrayList<>(2);
		list.add("guan");
		list.add("bao");
		String[] array = list.toArray(new String[0]);
		 说明：使用 toArray 带参方法，数组空间大小的 length： 
		1） 等于 0，动态创建与 size 相同的数组，性能最好。
		2） 大于 0 但小于 size，重新创建大小等于 size 的数组，增加 GC 负担。
		3） 等于 size，在高并发情况下，数组创建完成之后，size 正在变大的情况下，负面影响与 2 相同。
		4） 大于 size，空间浪费，且在 size 处插入 null 值，存在 NPE 隐患。
		*/
		// set添加返回值
		Set<String> acloSets = new HashSet<>();

		System.out.println("acloSets.add(\"1\")=" + acloSets.add("1"));
		System.out.println("acloSets.add(\"1\")" + acloSets.add("1"));
		System.out.println("acloSets.add(\"2\")" + acloSets.add("2"));
		String[]  jk= acloSets.toArray(new String[0]);
		System.out.println(jk);
		
		
		
		
		
		
	}
	

}
