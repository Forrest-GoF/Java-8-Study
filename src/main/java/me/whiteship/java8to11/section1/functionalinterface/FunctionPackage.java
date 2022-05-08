package me.whiteship.java8to11.section1.functionalinterface;

import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class FunctionPackage {

	public static void main(String[] args) {
		//더 자바: Java 8
		//https://docs.google.com/document/d/1UxKM56um1mjGeayxmJmvALM5CDIJC17vx1-sDwoEbSs/edit#

		//java.util.fuction 패키지
		//https://docs.oracle.com/javase/8/docs/api/java/util/function/package-summary.html

		//기존의 클래스 사용법
		Plus10 plus10 = new Plus10();
		System.out.println(plus10.apply(1)); // 1 + 10 -> 11

		//자바가 기본으로 제공하는 FunctionPackage 함수와 람다 표현 사용
		//Function<T, R>
		//T 타입을 받아서 R 타입을 리턴하는 함수 인터페이스
		//andThen과 compose으로 함수 조합
		Function<Integer, Integer> plus20 = (i) -> i + 20;
		Function<Integer, Integer> multiply2 = (i) -> i * 2;
		System.out.println(plus20.apply(1)); // 1 + 20 -> 21
		System.out.println(multiply2.apply(1)); // 1 * 2 -> 2

		//compose는 A.compose(B) B를 먼저 계산하고 그 결과를 A의 파라미터로 입력
		// FunctionPackage<Integer, Integer> multiply2AndPlus20 = plus20.compose(multiply2);
		// System.out.println(multiply2AndPlus20.apply(1));
		// 람다 표현
		System.out.println(plus20.compose(multiply2).apply(1)); // 1 -> 1 * 2 -> 2 + 20 = 22

		//andThen는 A.andThen(B) A를 먼저 계산하고 그 결과를 B의 파라미터로 입력
		System.out.println(plus20.andThen(multiply2).apply(1)); // 1 -> 1 + 20 -> 21 * 2 = 42

		//BiFunction<T, U, R>
		//두 개의 값(T, U)를 받아서 R 타입을 리턴하는 함수 인터페이스
		//R apply(T t, U u)

		//Consumer<T>
		//T 타입을 받아서 아무값도 리턴하지 않는 함수 인터페이스
		//andThen으로 함수 조합
		Consumer<Integer> printT = (i) -> System.out.println(i);
		printT.accept(1);

		//Supplier<T>
		//T 타입의 값을 제공하는 함수 인터페이스
		//T get()
		Supplier<Integer> get10 = () -> 10;
		System.out.println(get10.get());

		//Predicate<T>
		//T 타입을 받아서 boolean을 리턴하는 함수 인터페이스
		//boolean test(T t)
		//And, Or, Negate로 함수 조합
		Predicate<String> startsWithJuwon = (s) -> s.startsWith("juwon");
		System.out.println(startsWithJuwon.test("juwon"));

		//UnaryOperator<T>
		//Function<T, R>의 특수한 형태로, 입력값 하나를 받아서 동일한 타입을 리턴하는 함수 인터페이스
		UnaryOperator<Integer> plus30 = (i) -> i + 30;
		UnaryOperator<Integer> multiply3 = (i) -> i * 3;
		System.out.println(plus30.andThen(multiply3).apply(1));

		//BinaryOperator<T>
		//BiFunction<T, U, R>의 특수한 형태로, 동일한 타입의 입렵값 두개를 받아 리턴하는 함수 인터페이스
		BinaryOperator<Integer> sum = (a, b) -> a + b;
	}
}
