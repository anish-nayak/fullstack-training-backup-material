package com.spring.utils;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.spring.entity.AnswerEntity;
import com.spring.entity.QuestionEntity;
import com.spring.json.Answer;
import com.spring.json.Question;

public class QuestionUtils {

	public static Question convertQuestionEntityToQuestionJson(QuestionEntity questionEntity) {
		Set<AnswerEntity> answerEntitySet = questionEntity.getAnswers();
		Set<Answer> answerJsonSet = new HashSet<Answer>();
		Iterator<AnswerEntity> itr = answerEntitySet.iterator();
		while(itr.hasNext()) {
			AnswerEntity answerEntity = itr.next();
			answerJsonSet.add(new Answer(answerEntity.getAnsId(), answerEntity.getAnswer()));
		}
		return new Question(questionEntity.getQusId(), questionEntity.getQusDesc(), answerJsonSet);
	}

	public static QuestionEntity convertQuestionToQuestionEntity(Question question) {
		Set<Answer> answerJsonSet = question.getAnswers();
		Iterator<Answer> itr = answerJsonSet.iterator();
		Set<AnswerEntity> answerEntitySet = new HashSet<AnswerEntity>();
		while(itr.hasNext()) {
			Answer answer = itr.next();
			answerEntitySet.add(convertAnswerToAnswerEntity(answer));
		}
		QuestionEntity questionEntity = new QuestionEntity(question.getQusDesc(), answerEntitySet);
		answerEntitySet = questionEntity.getAnswers();
		Iterator<AnswerEntity> itr_2 = answerEntitySet.iterator();
		while(itr_2.hasNext()) {
			AnswerEntity answerEntity = itr_2.next();
			answerEntity.setQuestion(questionEntity);
		}
		return questionEntity;
	}
	
	public static AnswerEntity convertAnswerToAnswerEntity(Answer answerJson) {
		return new AnswerEntity(answerJson.getAnswer());
		
	}
}
