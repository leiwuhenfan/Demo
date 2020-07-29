package ink.zhongshao;

public class Test {

	public static void main(String[] args) {
		System.out.println("0000000000000==");

		// 替换
		
		
		String kl = "\\";
		
		//斜杠替换，4个\替换(模糊查询使用like ? escape '/'        %name%)
		//前台传入\
		//后台替换kl.replaceAll("\\\\", "、/\\\\");
		kl = kl.replaceAll("%", "/%");
		kl = kl.replaceAll("_", "/_");
		kl = kl.replaceAll("/", "//");
		kl = kl.replaceAll("\\\\", "/\\\\");
		
		
		System.out.println(kl);

	}

}
