package me.whiteship.java8to11.section1.methodreference;

import java.util.Arrays;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class MethodReference {
	public static void main(String[] args) {
		UnaryOperator<String> hi = (s) -> "hi " + s; // 메서드 레퍼런스를 쓰면 이미 구현되어 있는 클래스를 중복해서 구현할 필요 없음
		UnaryOperator<String> hi2 = Greeting::hi; // ::가 있으면 메서드 레퍼런스(이 경우 스태틱 메서드 사용)

		Greeting greeting = new Greeting();
		UnaryOperator<String> hello = greeting::hello;  // (이 경우 인스턴스 메서드 사용)
														// greeting::hello를 참조만 할 뿐 아직 호출한 것은 아님

		Supplier<Greeting> newGreeting = Greeting::new; // 아직 인스턴스가 만들어지지 않았음 Supplier임
														// Greeting() 생성자를 참조
		newGreeting.get(); // 인스턴스 생성됨

		Function<String, Greeting> juwonGreeting
			= Greeting::new;							// Greeting(String name) 생성자를 참조
		Greeting juwon = juwonGreeting.apply("juwon");// Greeting(String name) 생성자를 호출
		System.out.println(juwon.getName());

		String[] names = {"juwon", "a", "b"};
		// Arrays.sort(names, ((o1, o2) -> o1.length() - o2.length()));
		Arrays.sort(names, String::compareToIgnoreCase); // 인스턴스함수->String을 인스턴스 취급(익명 객체)
		System.out.println(Arrays.toString(names));
	}
}
