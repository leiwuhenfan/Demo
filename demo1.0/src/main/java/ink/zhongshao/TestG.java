package ink.zhongshao;

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

	}

}
