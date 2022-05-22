package me.whiteship.java8to11.section4.optional;

import java.util.Optional;

public class OnlineClass {

	private Integer id;

	private String title;

	private boolean closed;

	public Progress progress; //Optional을 변수로 쓰는 것도 부적절(있을 수도 없을 수도 있는 변수라는 의미라면 도메인 재설계 필요)

	public OnlineClass(Integer id, String title, boolean closed){
		this.id = id;
		this.title = title;
		this.closed = closed;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public boolean isClosed() {
		return closed;
	}

	public void setClosed(boolean closed) {
		this.closed = closed;
	}

	//자바8 이전
	public Progress getProgress() {
		return progress;
	}

	public void setProgress(Progress progress) { //파라미터로 null이 오면 안되기 때문에 Optional을 쓰지 않기를 권장
		this.progress = progress;
	}
}
