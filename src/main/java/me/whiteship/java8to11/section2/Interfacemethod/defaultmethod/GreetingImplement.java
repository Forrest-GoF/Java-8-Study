package me.whiteship.java8to11.section2.Interfacemethod.defaultmethod;

/*
public class GreetingImplement implements Greeting, Greeting2{
					Greeting과 Greeting2의 default 메서드가 중복!
					중복되는 메서드는 직접 @Overriding해야함!
 */

	public class GreetingImplement implements Greeting{

	String name;

	public GreetingImplement(String name) {
		this.name = name;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public void printName() {
		System.out.println(getName());
	}
}
