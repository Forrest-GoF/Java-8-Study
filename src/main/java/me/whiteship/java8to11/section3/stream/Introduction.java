package me.whiteship.java8to11.section3.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Introduction {

	public static void main(String[] args) {
		List<String> names = new ArrayList<>();
		names.add("juwon");
		names.add("a");
		names.add("b");
		names.add("c");

		//stream은 데이터를 담고 있는 컬렉션이 아니다. 데이터 소스를 변경하지 않는다.
		Stream<String> stringStream = names.stream().map((s -> {
			System.out.println(s); //중계형 operator는 종료형 operator가 오기 전까지 실행되지 않음!
			return s.toUpperCase();//종료형 operator가 왔을 때 실행됨!
		})); //map은 중계형이라 stream 반환

		System.out.println("================");

		List<String> collect = stringStream.collect(Collectors.toList());
		collect.forEach(System.out::println);

		names.forEach(System.out::println);

		List<String> collect2 = names.parallelStream().map(String::toUpperCase)
			.collect(Collectors.toList());
		//멀티스레드 처리 지원
		//무조건 빠른 게 아님. 오히려 느릴 수도(스레드 생성, context switching, 처리 병합)
		//데이터가 너무 방대한 경우에 유리함
	}
}
