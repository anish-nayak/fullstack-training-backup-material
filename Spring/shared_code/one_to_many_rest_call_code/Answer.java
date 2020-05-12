package com.spring.json;

public class Answer {

	private Long ansId;
	private String answer;
	public Answer(Long ansId, String answer) {
		super();
		this.ansId = ansId;
		this.answer = answer;
	}
	public Answer(String answer) {
		super();
		this.answer = answer;
	}
	public Answer() {}
	public Long getAnsId() {
		return ansId;
	}
	public void setAnsId(Long ansId) {
		this.ansId = ansId;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	@Override
	public String toString() {
		return "Answer [ansId=" + ansId + ", answer=" + answer + "]";
	}
	
}
