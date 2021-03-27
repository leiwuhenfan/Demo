/**
 * 
 */
package ink.zhongshao;

/**
 * @author zs
 * @date 2021年3月7日
 */
public class Dept {

	private Long id;

	private String name;

	public Long getId() {
		return id;
	}

	public Dept setId(Long id) {
		this.id = id;
		return this;
	}

	public String getName() {
		return name;
	}

	public Dept setName(String name) {
		this.name = name;
		return this;
	}

	public static Dept instance() {

		return new Dept();
	}

	@Override
	public String toString() {
		return "Dept [id=" + id + ", name=" + name + "]";
	}

	public static void main(String[] args) {

		Dept d = Dept.instance().setId(1L).setName("d1name");
		System.out.println(d.toString());

		Dept d2 = new Dept();
		d2.setId(2L);
		d2.setName("d2name");
		System.out.println(d2.toString());
		
		
	}
}
