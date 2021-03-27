package ink.zhongshao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

/**
 * 设置的运行参数
 * -Xmx2M -Xmx2M -XX:MetaspaceSize=10M -XX:MaxMetaspaceSize=10M -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=D:\study\01test\OOM\
 * 
 * @author zs
 * @date 2020年12月15日
 */
public class Test {

	private static Random random = ThreadLocalRandom.current();

	public static void main(String[] args) {
		
		StringBuilder jksss = new StringBuilder("123456");
		
		
		jksss.replace(0, 2, "VV");
		
		
		System.out.println(jksss);
		
		
		
		
		
		
		
		
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

		System.out.println("nextInt(10)=" + random.nextInt(10));

		String[] jk = acloSets.toArray(new String[0]);
		System.out.println(jk);
		
		List<String> testOOM = new ArrayList<>();
		for(;;) {
			testOOM.add(UUID.randomUUID().toString());
		}
		

	}

}
