package ink.zhongshao;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
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
		
		
		Test t = new Test();
		
		t.TestArraytoList();
		t.testListtoArray();
		
	}
	
	
	void TestArraytoList() {
		/*
		【强制】使用工具类 Arrays.asList()把数组转换成集合时，不能使用其修改集合相关的方法，它的 add/remove/clear 方法会抛出 UnsupportedOperationException 异常。
		说明：asList 的返回对象是一个 Arrays 内部类，并没有实现集合的修改方法。Arrays.asList 体现的是适配器模式，只是转换接口，后台的数据仍是数组。
		 String[] str = new String[] { "chen", "yang", "hao" };
		 List list = Arrays.asList(str);
		第一种情况：list.add("yangguanbao"); 运行时异常。
		第二种情况：str[0] = "change"; 也会随之修改，反之亦然。
		*/
		
		String []dd = {"11","22","33"};
		
		List<String> lk = Arrays.asList(dd);
		
		dd[0]="11-gh";
		
		System.out.println(String.join(",", lk));
		
	}
	
	void testListtoArray() {
		
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
		System.out.println(String.join(",", jk));
		
		
	}
	

}
