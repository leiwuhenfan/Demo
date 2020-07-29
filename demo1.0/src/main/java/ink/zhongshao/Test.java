package ink.zhongshao;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Test {

	public static void main(String[] args) {
		System.out.println("0000000000000==");

		List<Integer> hk = new ArrayList<>();
		hk.add(1);
		hk.add(2);
		hk.add(3);
		hk.add(4);
		hk.add(5);

		List<Integer> newhk = hk.stream().filter((i) -> i > 2).collect(Collectors.toList());

		newhk.stream().forEach(System.out::println);
		
		
		new Test().getlistfor();
	}

	// list<����> --- >list<String>
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

	public void LambTest() { // lamb ���ʽ����list ����
		/*
		 * һ����filter ����ʱ�����ò�����parallelStream ,����õĻ����ܻᵼ���̰߳�ȫ���� �ж϶���Ҫ��дhash
		 */

		List<String> list1 = new ArrayList<>();
		list1.add("1111");
		list1.add("2222");
		list1.add("3333");

		List<String> list2 = new ArrayList<>();
		list2.add("3333");
		list2.add("4444");
		list2.add("5555");

		// ����
		List<String> intersection = list1.stream().filter(item -> list2.contains(item)).collect(Collectors.toList());
		System.out.println("---�õ����� intersection---");
		intersection.parallelStream().forEach(System.out::println);

		// ͬ˫ð��д��
		intersection.parallelStream().forEach(x -> {
			System.out.println("x =" + x);
		});

		// � (list1 - list2)
		List<String> reduce1 = list1.stream().filter(item -> !list2.contains(item)).collect(Collectors.toList());
		System.out.println("---�õ�� reduce1 (list1 - list2)---");
		reduce1.parallelStream().forEach(System.out::println);

		// � (list2 - list1)
		List<String> reduce2 = list2.stream().filter(item -> !list1.contains(item)).collect(Collectors.toList());
		System.out.println("---�õ�� reduce2 (list2 - list1)---");
		reduce2.parallelStream().forEach(System.out::println);

		// ����
		List<String> listAll = list1.parallelStream().collect(Collectors.toList());
		List<String> listAll2 = list2.parallelStream().collect(Collectors.toList());
		listAll.addAll(listAll2);
		System.out.println("---�õ����� listAll---");
		listAll.parallelStream().forEach(System.out::println);

		// ȥ�ز���
		List<String> listAllDistinct = listAll.stream().distinct().collect(Collectors.toList());
		System.out.println("---�õ�ȥ�ز��� listAllDistinct---");
		listAllDistinct.parallelStream().forEach(System.out::println);

		System.out.println("---ԭ����List1---");
		list1.parallelStream().forEach(System.out::println);
		System.out.println("---ԭ����List2---");
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
