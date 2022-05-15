package me.whiteship.java8to11.section2.Interfacemethod.defaultmethod;

public interface Greeting2 {

	default void printNameUpperCase() {
		System.out.println("Greeting2");
	}
}
