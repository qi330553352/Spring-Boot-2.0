package com.example.qixin;

import com.example.qixin.java8.*;
import com.google.common.base.Function;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BaseWebfluxServerApplication.class)
public class BaseWebfluxServerApplicationTests {

	@Test //在接口中允许有默认方法的实现
	public void test1() {
		Java8 j8 = new Java8() {
			@Override
			public double calculate(int a) {

				return sqrt(a*100);
			}
		};
		System.out.println("----------------");
		System.out.println(j8.calculate(4));
		System.out.println(j8.sqrt(8));
	}

	@Test //字符串排序 默认按升序
	public void test2(){
		List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");
		names.forEach(System.out::println);
//		System.out.println("--1、升序-------------");
//		Collections.sort(names);
//		names.forEach(System.out::println);

//		System.out.println("--2、降序-------------");
//		Collections.sort(names, (o1, o2) -> o2.compareTo(o1));
//		names.forEach(System.out::println);
	}

	@Test //函数式接口
	public void test3(){
		Converter<String,Integer> converter = (form)->Integer.valueOf(form);
		Integer converted = converter.convert("123");
		System.out.println();
		System.out.println(converted);
	}

	@Test //对象引用
	public void test4(){
		Something something = new Something();
		Converter<String, String> converter  = something::startsWith;
		String converted = converter.convert("Java");
		System.out.println();
		System.out.println(converted);
	}

	@Test //通过构造函数引用
	public void test5(){
		PersonFactory<Person> pf = Person::new;
		Person p = pf.create("qi","xin");
		System.out.println();
		System.out.println(p);
	}

	@Test //可以访问外部的final局部变量
	public void test6(){
		final int num = 1;
		Converter<Integer, String> stringConverter =(from) -> String.valueOf(from + num);
		String str = stringConverter.convert(2);
		System.out.println();
		System.out.println(str);
	}

	@Test //与匿名对象不同的是，num不一定需要是final的
	public void test7(){
		int num = 1;
		Converter<Integer, String> stringConverter =(from) -> String.valueOf(from + num);
		String str = stringConverter.convert(2);
		System.out.println();
		System.out.println(str);
	}

	@Test //num在编译的时候被隐式地当做final变量来处理。下面的代码就不合法：
	public void test8(){
		int num = 1;
		Converter<Integer, String> stringConverter =(from) -> String.valueOf(from + num);
		String str = stringConverter.convert(2);
		//num+=1;
		System.out.println();
		System.out.println(str);
	}

}

