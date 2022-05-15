package me.whiteship.java8to11.section2.Interfacemethod.defaultmethod;

public class App {

	public static void main(String[] args) {
		GreetingImplement greetingImplement = new GreetingImplement("juwon");
		greetingImplement.printName();
		greetingImplement.printNameUpperCase();
	}
}
