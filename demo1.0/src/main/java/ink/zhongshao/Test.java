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
		
		
		//集合取交集
		
		
		
	}

	   public void LambTest() {  //lamb 表达式处理list 集合
	      /*一般有filter 操作时，不用并行流parallelStream ,如果用的话可能会导致线程安全问题
	　　     判断对象要重写hash*/
	 
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
	 
	      //同双冒号写法
	      intersection.parallelStream().forEach(x->{
	         System.out.println("x ="+x);
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
