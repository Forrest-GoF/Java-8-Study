package me.whiteship.java8to11.section5.dateandtimeapi;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class Example {

	public static void main(String[] args) {
		
		//자바8 이후 date, time 타입들
		//1.기계용
		//1-1.Instant(시간)
		Instant instant = Instant.now(); // 기준시 UTC, GMT
		System.out.println(instant);
		System.out.println(instant.atZone(ZoneId.of("UTC")));

		ZoneId zoneId = ZoneId.systemDefault();
		System.out.println(zoneId);
		ZonedDateTime zonedDateTime = instant.atZone(zoneId);
		System.out.println(zonedDateTime);

		//1-2.Duration(기간)
		Instant instant1 = instant.plus(10, ChronoUnit.SECONDS);
		Duration duration = Duration.between(instant, instant1);
		System.out.println(duration.getSeconds());

		System.out.println("---------------------");

		//2.사람용
		//2-1.LocalDateTime(시간)
		LocalDateTime now = LocalDateTime.now(); //(주의)동작중인 서버 기준
		System.out.println(now);
		LocalDateTime birthDay =
			LocalDateTime.of(1995, Month.JUNE, 5, 5, 30, 0);
		ZonedDateTime nowInKorea = ZonedDateTime.now(ZoneId.of("Asia/Seoul"));
		System.out.println(nowInKorea);

		//2-2.Period(기간)
		LocalDate today = LocalDate.now();
		LocalDate thisYearBirthday = LocalDate.of(2022, Month.JUNE, 5);
		//today의 값을 바꾸는 것이 아니라 새로운 인스턴스를 반환
		LocalDate plus10AtToday = today.plus(10, ChronoUnit.DAYS);

		Period period = today.until(thisYearBirthday);
		System.out.println(period.getDays());
		Period period1 = Period.between(today, thisYearBirthday);
		System.out.println(period1.getDays());

		//2-3.DateTimeFormatter
		//포멧팅
		LocalDateTime localDateTime = LocalDateTime.now();
		System.out.println(DateTimeFormatter.ISO_DATE_TIME);

		DateTimeFormatter MMddyyyy = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		System.out.println(localDateTime.format(MMddyyyy));

		//파싱
		LocalDate parse = LocalDate.parse("06/05/1995", MMddyyyy);
		System.out.println(parse);

		//3.레거시 API 지원
		//Date<->Instant
		Date date = new Date();
		Instant instant2 = date.toInstant();
		Date date1 = Date.from(instant2);

		//GregorianCalendar<->ZoneDateTime
		GregorianCalendar gregorianCalendar = new GregorianCalendar();
		ZonedDateTime zonedDateTime1 = gregorianCalendar.toInstant().atZone(ZoneId.systemDefault());
		LocalDateTime localDateTime1 = zonedDateTime1.toLocalDateTime();
		GregorianCalendar gregorianCalendar1 = GregorianCalendar.from(zonedDateTime1);

		//TimeZone<->ZoneId
		ZoneId zoneId1 = TimeZone.getTimeZone("PST").toZoneId();
		TimeZone timeZone = TimeZone.getTimeZone(zoneId);
	}
}
