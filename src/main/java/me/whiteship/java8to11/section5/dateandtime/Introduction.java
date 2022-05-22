package me.whiteship.java8to11.section5.dateandtime;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Introduction {

	public static void main(String[] args) {
		//자바8 이전 date, time 타입들
		//여러가지 불편함들이 있었음
		//이름이 제대로 작명되어 있지 않고 역할들이 모호함
		//mutable하기 때문에 멀티스레드 환경에서 safe하지 않음
		//실수할 여지가 많게 구현되어있음. 타입 안정성이 없음
		//그래서 Joda-Time을 많이 사용했었는데, 이번에 자바 표준으로 들어옴
		Date date = new Date();
		Calendar calendar = new GregorianCalendar();
		SimpleDateFormat dateFormat = new SimpleDateFormat();
	}
}
