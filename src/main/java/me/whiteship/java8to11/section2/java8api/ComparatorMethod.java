package me.whiteship.java8to11.section2.java8api;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ComparatorMethod {

	public static void main(String[] args) {
		List<String> names = new ArrayList<>();
		names.add("juwon");
		names.add("a");
		names.add("b");
		names.add("c");

		//List 오름차순 정렬
		names.sort(String::compareToIgnoreCase); //인스턴스 메서드 참조->클래스->인스턴스
		names.forEach(System.out::println);

		//List 내림차순 정렬
		Comparator<String> compareToIgnoreCase = String::compareToIgnoreCase;
		names.sort(compareToIgnoreCase.reversed());
		names.forEach(System.out::println);

		//다중 정렬
		// names.sort(compareToIgnoreCase.reversed().thenComparing());
	}
}
