package com.example.demo.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class lanmdaTest {
	
	static String str1 = "";
	public static void main (String[] args) {
		// lanmda表达式写初始化方法
		GreetingService lanmdaService = message -> System.out.println("Hello " + message);
		// 上面的代码等价于
		GreetingService demo = new GreetingService() {
			@Override
			public void sayHello(String msg) {
				System.out.println("Hello" + msg);
			}
		};
		// 传统实现方式
		GreetingService simpleService = new GreetingServiceImpl();
		simpleService.sayHello("simple");
		lanmdaService.sayHello("lanmda");
		// java8 使用for循环
		List<String> strList = new ArrayList();
		strList.add("1");
		strList.add("2");
		strList.add("3");
		strList.add("4");
		// 传统实现
		for (String str :strList) {
			System.out.println("simple遍历：" + str);
		}
		strList.forEach(i -> System.out.println("lanmada遍历：" + i));
		
		Map<String,Object> map = new HashMap();
		map.put("key1", "1");
		map.put("key2", "2");
		for(Map.Entry<String, Object> entry :map.entrySet()) {
			System.out.println("simple遍历map:" + entry.getKey() + "-" +entry.getValue());
		}
		String str = "";
		map.forEach((key,value) -> {
			String str2 = "";
			if (key.equals("key2")) {
				str1 = value + "";
			}
		});
		// 线程写法
		Thread th = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("线程");
			}
		});
		th.start();
		Thread lanmdaTh = new Thread( () -> System.out.println("lanmda线程"));
		lanmdaTh.start();
		
		List<String> list = Arrays.asList(new String[] {"1","2","5","4","3"});
		Collections.sort(list,(a,b) ->a.compareTo(b));
		list.forEach(str1 ->System.out.println(str1));
	}
	

	static class GreetingServiceImpl implements GreetingService {

		public void sayHello(String msg) {
			System.out.println("Hello " + msg);
		}
		
	}
	interface GreetingService {
		void sayHello(String msg);
//		void sayGoodBye(String msg);
	}
}
