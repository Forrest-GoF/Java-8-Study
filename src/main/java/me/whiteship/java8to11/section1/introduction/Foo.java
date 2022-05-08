package me.whiteship.java8to11.lambda.introduction;

public class Foo {

	//자바 8이전
	//익명 내부 클래스(anonymous inner class)
	/*
	public static void main(String[] args) {
		RunSomething runSomething = new RunSomething() {
			@Override
			public void doIt() {
				System.out.println("Hello");
				System.out.println("Lambda");
			}
		};
	}
	 */

	//자바 8부터
	//함수형 인터페이스를 구현하는 람다 표현 제공
	//함수로 표현 되는 부분도 결국 객체의 정의의 일부라고 볼 수 있음
	/*
	public static void main(String[] args) {
		RunSomething runSomething = () -> {
			System.out.println("Hello");
			System.out.println("Lambda");
		};
		runSomething.doIt();
	}
	 */

	//만약 동일한 값을 넣었는데 동일한 return을 보장해주지 못하는 경우에는 함수형 프로그래밍으로 하면 안 됨
	//예를 들어 함수밖에 있는 값을 참조하거나 변경할 때
	public static void main(String[] args) {

		RunSomething runSomething = new RunSomething() {
			int baseNumber = 10; // 특정 상태값을 갖기 때문에 pure한 함수라고 볼 수 없음

			@Override
			public int doIt2(int number) {
				baseNumber++; // 함수형 프로그램으로 표현할 수 없음
				return number + baseNumber;
			}
		};
	}
}
