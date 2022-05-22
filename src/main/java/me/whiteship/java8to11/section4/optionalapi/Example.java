package me.whiteship.java8to11.section4.optionalapi;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Example {

	public static void main(String[] args) {
		List<OnlineClass> springClasses = new ArrayList<>();
		springClasses.add(new OnlineClass(1, "spring boot", true));
		springClasses.add(new OnlineClass(2, "spring data jpa", true));
		springClasses.add(new OnlineClass(3, "spring mvc", false));
		springClasses.add(new OnlineClass(4, "spring core", false));
		springClasses.add(new OnlineClass(5, "rest api development", false));

		//null일수도 있으므로 Optional 타입 반환이 적절
		Optional<OnlineClass> optionalSpring = springClasses.stream()
			.filter(onlineClass -> onlineClass.getTitle().startsWith("spring"))
			.findFirst();

		System.out.println(optionalSpring.isPresent());
		System.out.println(optionalSpring.isEmpty());

		Optional<OnlineClass> optionalJpa = springClasses.stream()
			.filter(onlineClass -> onlineClass.getTitle().startsWith("jpa"))
			.findFirst();

		System.out.println(optionalJpa.isPresent());
		System.out.println(optionalJpa.isEmpty());

		System.out.println("-------------------------");

		//1.get
		OnlineClass onlineClassSpring = optionalSpring.get();
		System.out.println("1.get: " + onlineClassSpring.getTitle());
		//2.ifPresent
		//아래 같이 null check하면서 쓸 수 있음
		optionalSpring.ifPresent(onlineClass -> System.out.println("2.ifPresent: " + onlineClass.getTitle()));
		//3.orElse
		//있으면 orElse를 적용 안함. 하지만 동작은 함
		//파라미터로 인스턴스를 받음
		onlineClassSpring = optionalSpring.orElse(createNewClass());
		System.out.println("3.orElse: " + onlineClassSpring.getTitle());
		//4.orElseGet
		//있으면 orElseGet을 동작 안함
		//파라미터가 suply 함수형 인터페이스
		// onlineClassSpring = optionalSpring.orElseGet(() -> createNewClass());
		onlineClassSpring = optionalSpring.orElseGet(Example::createNewClass);
		System.out.println("4.orElseGet: " + onlineClassSpring.getTitle());
		//5.orElseThrow
		onlineClassSpring = optionalSpring.orElseThrow();
		System.out.println("5.orElseThrow: " + onlineClassSpring.getTitle());
		//6.flatMap(Optional의 flatMap과 stream().flatMap은 다르니 주의)
		Optional<Optional<Progress>> optionalOptionalProgress = optionalSpring.map(OnlineClass::getProgress);
		Optional<Progress> optionalProgress = optionalOptionalProgress.orElse(Optional.empty());
		//같은 코드
		optionalProgress = optionalSpring.flatMap(OnlineClass::getProgress);

		System.out.println("-------------------------");

		//1.get
		// OnlineClass onlineClassJpa = optionalJpa.get(); //NoSuchElementException 런타임 에러 발생
		//2.ifPresent
		optionalJpa.ifPresent(onlineClass -> System.out.println("2.ifPresnet: " + onlineClass.getTitle()));
		//3.orElse
		//null이면 orElse를 적용함
		OnlineClass onlineClassJpa = optionalJpa.orElse(createNewClass());
		System.out.println("3.orElse" + onlineClassJpa.getTitle());
		//4.orElseGet
		//null이면 orElseGet을 적용함
		onlineClassJpa = optionalJpa.orElseGet(Example::createNewClass);
		System.out.println("4.orElseGet: " + onlineClassJpa.getTitle());
		//5.orElseThrow
		//null이면 예외를 throw
		onlineClassJpa = optionalJpa.orElseThrow();
		onlineClassJpa = optionalJpa.orElseThrow(() -> new IllegalStateException());
		onlineClassJpa = optionalJpa.orElseThrow(IllegalStateException::new);
		System.out.println("5.orElseThrow: " + onlineClassJpa.getTitle());
	}

	private static OnlineClass createNewClass() {
		System.out.println("creating new online class");
		return new OnlineClass(6, "New Class", false);
	}
}
