package me.whiteship.java8to11.section2.Interfacemethod.defaultmethod;

public interface Greeting {

	String getName();

	void printName();

	/**
	 * @implSpec
	 * getName()에서 NULL이 반환되면 에러가 발생한다.
	 */

	default void printNameUpperCase() {				//default를 쓰면 인터페이스를 implement한 클래스마다 구현해줄 필요 없음!
		System.out.println(getName().toUpperCase());//인터페이스에 함수를 추가하는데 유용
	}												//내가 정의한 인터페이스에서만 사용 가능(라이브러리에서 사용 불가)
													//Object 기본 함수들은 default에서 재정의 불가능
													//Object 기본 함수들도 인터페이스에서 선언하는 건 가능
													//구현 클래스에서 재정의할 수 있음
													//만약 getName()에서 NULL을 return하면 에러 발생
													//주석으로 주의할 점을 표시해주면 좋음

}
