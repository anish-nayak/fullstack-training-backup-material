package com.spring.json;

import java.util.Set;

public class Question {

	private Long qusId;
	private String qusDesc;
	private Set<Answer> answers;
	public Question(Long qusId, String qusDesc, Set<Answer> answers) {
		super();
		this.qusId = qusId;
		this.qusDesc = qusDesc;
		this.answers = answers;
	}
	public Question(String qusDesc, Set<Answer> answers) {
		super();
		this.qusDesc = qusDesc;
		this.answers = answers;
	}
	public Question() {}
	public Long getQusId() {
		return qusId;
	}
	public void setQusId(Long qusId) {
		this.qusId = qusId;
	}
	public String getQusDesc() {
		return qusDesc;
	}
	public void setQusDesc(String qusDesc) {
		this.qusDesc = qusDesc;
	}
	public Set<Answer> getAnswers() {
		return answers;
	}
	public void setAnswers(Set<Answer> answers) {
		this.answers = answers;
	}
	@Override
	public String toString() {
		return "Question [qusId=" + qusId + ", qusDesc=" + qusDesc + ", answers=" + answers + "]";
	}
	
	
	
}
