package me.whiteship.java8to11.section4.optional;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Introduction {

	public static void main(String[] args) {
		List<OnlineClass> springClasses = new ArrayList<>();
		springClasses.add(new OnlineClass(1, "spring boot", true));
		springClasses.add(new OnlineClass(2, "spring data jpa", true));
		springClasses.add(new OnlineClass(3, "spring mvc", false));
		springClasses.add(new OnlineClass(4, "spring core", false));
		springClasses.add(new OnlineClass(5, "rest api development", false));

		OnlineClass spring_boot = new OnlineClass(1, "spring boot", true);
		// Duration studyDucration = spring_boot.getProgress().getStudyDuration(); // NullPointerExcepton
		// System.out.println(studyDucration);

		//자바8 이전 null 해결 방법
		//null check를 까먹을 수 있어서 위험한 코드
		//null 자체가 반환되는 것이 안 좋은 코드
		//getProgress()에서 예외 처리하는 것은 예외 처리 자체가 리소스를 많이 써서 로직 처리할 때 에러를 쓰는 건 좋지 않음
		Progress progress = spring_boot.getProgress();
		if(progress != null){
			System.out.println(progress.getStudyDuration());
		}

	}
}
