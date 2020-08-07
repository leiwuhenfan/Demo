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
		
	}

}
