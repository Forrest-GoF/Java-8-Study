package me.whiteship.java8to11.section2.java8api;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CollectionMethod {

	public static void main(String[] args) {
		List<String> names = new ArrayList<>();
		names.add("juwon");
		names.add("a");
		names.add("b");
		names.add("c");

		//Stream 사용법
		List<String> names2 = names.stream().map(String::toUpperCase)
								.filter(s -> s.startsWith("J"))
								.collect(Collectors.toList());

		//removeIf 사용법
		names.removeIf(s -> s.startsWith("j"));
		names.forEach(System.out::println);
	}
}
