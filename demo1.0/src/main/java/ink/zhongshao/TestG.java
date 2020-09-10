package ink.zhongshao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import cn.hutool.core.lang.TypeReference;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;

//T泛型的作用域为类全局
public class TestG<T> {

	private String name;

	private T data;

	public TestG() {
		super();

	}

	public TestG(String name) {
		super();
		this.name = name;

	}

	public static <T> TestG<T> instance() {

		return new TestG<>();

	}

	// 此方法是泛型 <E>：确定输入输入参数是那个泛型
	public static <E> TestG<E> getE(String res) {

		return new TestG<>(res);

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "TestG [name=" + name + ", data=" + data + "]";
	}

	public static void main(String[] args) {

		TestG<Integer> k = new TestG<>();
		System.out.println(k);

		TestG<String> k2 = new TestG<>("hdsfjkdshkjdsh");
		System.out.println(k2);

		TestG<String> dd = TestG.<String>getE("ll444l");
		System.out.println("==" + dd);

		TestG<String> fdds = new TestG<>();
//		new TypeReference<TestG<String>>(){};


		String jsonStr = "{\"b\":\"value2\",\"c\":\"value3\",\"a\":\"value1\"}";
		// 方法一：使用工具类转换
		JSONObject jsonObject = JSONUtil.parseObj(jsonStr);
		// 方法二：new的方式转换
		JSONObject jsonObject2 = new JSONObject(jsonStr);
		
		
		// false表示不跳过空值
		JSONObject json = JSONUtil.parseObj(new UserA(), false);
		System.out.println(json.toStringPretty());
		
		//可以看到，输出的字段顺序和Bean的字段顺序不一致，如果想保持一致，可以
		// 第二个参数表示保持有序
		 json = JSONUtil.parseObj(new UserA(), false, true);
		 System.out.println(json.toStringPretty());
		 
		// 默认的，Hutool将日期输出为时间戳，如果需要自定义日期格式，可以调用：
		 json.setDateFormat("yyyy-MM-dd HH:mm:ss");
		 System.out.println(json.toStringPretty());
		 
		 
		 //转泛型的对象与jsonObject
		 TestG<UserA> userAa = new TestG<>();
		 
		 userAa.setName("ddddd");
		 
		 UserA  user = new UserA(); 
		 user.setA("a");
		 user.setDate(new Date());
		 user.setName("name");
		 List<Integer> lis = new ArrayList<>();
		 lis.add(1);
		 user.setSqs(lis);
		 
		 userAa.setData(user);
		 
		 String str = JSONUtil.parse(userAa).toString();
		 
		 System.out.println(str);
		 
		 JSONObject sd= new JSONObject(str);
		 sd.setDateFormat("yyyy-MM-dd HH:mm:ss");
		 TestG<UserA> kl = sd.toBean(new TypeReference<TestG<UserA>>(){});
		 
		 System.out.println(kl);
		 
	}

}

class UserA {
	private String name;
	private String a;
	private Date date;
	private List<Integer> sqs;

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getA() {
		return a;
	}

	public void setA(String a) {
		this.a = a;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public List<Integer> getSqs() {
		return sqs;
	}

	public void setSqs(List<Integer> sqs) {
		this.sqs = sqs;
	}

	@Override
	public String toString() {
		return "UserA [name=" + name + ", a=" + a + ", date=" + date + ", sqs=" + sqs + "]";
	}

}
