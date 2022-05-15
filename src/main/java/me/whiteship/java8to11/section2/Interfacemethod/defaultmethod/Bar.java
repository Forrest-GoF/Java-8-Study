package me.whiteship.java8to11.section2.Interfacemethod.defaultmethod;

public interface Bar extends Greeting {

	void printNameUpperCase();//Greeting을 상속받은 Bar에서 default함수를 다시 추상 메소드로 정의할 수 있음
}
