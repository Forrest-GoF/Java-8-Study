package me.whiteship.java8to11.section4.optional;

import java.time.Duration;
import java.util.Optional;

public class Progress {

	private Duration studyDuration;

	private boolean finished;

	public Duration getStudyDuration() {
		return studyDuration;
	}

	public void setStudyDuration(Duration studyDuration) {
		this.studyDuration = studyDuration;
	}
}
