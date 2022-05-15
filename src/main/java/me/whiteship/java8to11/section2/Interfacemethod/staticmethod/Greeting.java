package me.whiteship.java8to11.section2.Interfacemethod.staticmethod;

public interface Greeting {

	String getName();

	void printName();

	static void printAnything() {
		System.out.println("Greeting");
	}
}
