package me.whiteship.java8to11.section2.java8api.iterablemethod;

import java.util.ArrayList;
import java.util.List;
import java.util.Spliterator;
import java.util.stream.Collectors;

public class App {

	public static void main(String[] args) {
		List<String> names = new ArrayList<>();
		names.add("juwon");
		names.add("a");
		names.add("b");
		names.add("c");

		//방법1(기본 문법)
		for (String name : names){
			System.out.println(name);
		}
		//방법2(람다 표현식)
		names.forEach(s -> System.out.println(s));//printLn(s) 정의->클래스->인스턴스(임의 객체)
		//방법3(메서드 레퍼런스)
		names.forEach(System.out::println);//printLn(s) 정의 참조(메서드 레퍼런스)->클래스->인스턴스(임의 객체)
		//방법4(메서드 레퍼런스)
		Spliterator<String> spliterator = names.spliterator();
		while (spliterator.tryAdvance(System.out::println));

		//나눠서 출력하는 방법(Spliterator)
		Spliterator<String> spliterator2 = names.spliterator();		//반으로 나눠서 뒷부분의 iterator가 남음
		Spliterator<String> spliterator3 = spliterator2.trySplit(); //반으로 나눠서 앞부분의 iterator 생성
		while(spliterator2.tryAdvance(System.out::println));
		System.out.println("======================");
		while (spliterator3.tryAdvance(System.out::println));
	}
}
