package me.whiteship.java8to11.lambda.introduction;

// @FunctionalInterface으로 함수형 인터페이스 명시 가능
// 함수개 2개 이상이 되면 에러 발생
@FunctionalInterface
public interface RunSomething {

	//인터페이스에 추상 메서드가 하나만 있으면 함수형 인터페이스 O
	//인터페이스에 추상 메서드가 두 개 있으면 함수형 인터페이스 X
	// void doIt();
	int doIt2(int number);


	//인터페이스임에도 불구하고 함수안을 정의할 수 있어짐
	/*
	static void printName(){
		System.out.println("Juwon0605");
	}
	 */

	//deafult를 포함하여 인터페이스의 함수를 정의할 수 있는 방법이 다양해 짐
	/*
	default void printAge(){
		System.out.println("28");
	}
	 */
}
