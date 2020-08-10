/**
 * 
 */
package ink.zhongshao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

/**
 * @author zs
 * @date 2020年8月26日
 */
public class ListArrayMap {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<Integer> hk = new ArrayList<>();
		hk.add(1);
		hk.add(2);
		hk.add(3);
		hk.add(4);
		hk.add(5);

		//大于2的记录
		List<Integer> newhk = hk.stream().filter((i) -> i > 2).collect(Collectors.toList());

		newhk.stream().forEach(System.out::println);
		
		ListArrayMap t = new ListArrayMap();
		t.getlistfor();
		t.TestArraytoList();
		t.testListtoArray();
		
		
		t.concurrentMap();
		

	}
	
	
	void concurrentMap() {
		
		Map<String ,Object> maps= new ConcurrentHashMap<>();
		
		maps.put("1", 1);
		maps.put("2", 2);
		
		//key  value都不能null   (     if (key == null || value == null) throw new NullPointerException();    )
		//maps.put("3", null);//不能null
		//maps.put(null, 12);
		
		
		System.out.println("maps.containsKey(\"3\") = "+maps.containsKey("3"));
		
		Object obj = maps.get("3");
		
		System.out.println(obj);
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
	


	// list<对象> --- >list<String>
		public void getlistfor() {

			List<Wangfan> wfs = new ArrayList<>();

			wfs.add(new Wangfan(1L,"wf1"));
			wfs.add(new Wangfan(2L,"wf2"));
			wfs.add(new Wangfan(3L,"wf3"));
			wfs.add(new Wangfan(4L,"wf4"));
			 //final List<String> collect = personList.stream().map(p -> p.getCountry()).distinct().collect(Collectors.toList());
			
			List<Long> ss = wfs.stream().filter((a) -> a.getAge()>3).map(p -> p.getAge()).collect(Collectors.toList());
			
			System.out.println(ss.size());

		}

		public void LambTest() { // lamb 表达式处理list 集合
			/*
			 * 一般有filter 操作时，不用并行流parallelStream ,如果用的话可能会导致线程安全问题 判断对象要重写hash
			 */

			List<String> list1 = new ArrayList<>();
			list1.add("1111");
			list1.add("2222");
			list1.add("3333");

			List<String> list2 = new ArrayList<>();
			list2.add("3333");
			list2.add("4444");
			list2.add("5555");

			// 交集
			List<String> intersection = list1.stream().filter(item -> list2.contains(item)).collect(Collectors.toList());
			System.out.println("---得到交集 intersection---");
			intersection.parallelStream().forEach(System.out::println);

			// 同双冒号写法
			intersection.parallelStream().forEach(x -> {
				System.out.println("x =" + x);
			});

			// 差集 (list1 - list2)
			List<String> reduce1 = list1.stream().filter(item -> !list2.contains(item)).collect(Collectors.toList());
			System.out.println("---得到差集 reduce1 (list1 - list2)---");
			reduce1.parallelStream().forEach(System.out::println);

			// 差集 (list2 - list1)
			List<String> reduce2 = list2.stream().filter(item -> !list1.contains(item)).collect(Collectors.toList());
			System.out.println("---得到差集 reduce2 (list2 - list1)---");
			reduce2.parallelStream().forEach(System.out::println);

			// 并集
			List<String> listAll = list1.parallelStream().collect(Collectors.toList());
			List<String> listAll2 = list2.parallelStream().collect(Collectors.toList());
			listAll.addAll(listAll2);
			System.out.println("---得到并集 listAll---");
			listAll.parallelStream().forEach(System.out::println);

			// 去重并集
			List<String> listAllDistinct = listAll.stream().distinct().collect(Collectors.toList());
			System.out.println("---得到去重并集 listAllDistinct---");
			listAllDistinct.parallelStream().forEach(System.out::println);

			System.out.println("---原来的List1---");
			list1.parallelStream().forEach(System.out::println);
			System.out.println("---原来的List2---");
			list2.parallelStream().forEach(System.out::println);

		}
}

class Wangfan {
	private Long age;
	private String name;

	public Wangfan(Long age, String name) {
		super();
		this.age = age;
		this.name = name;
	}

	public Long getAge() {
		return age;
	}

	public void setAge(Long age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}