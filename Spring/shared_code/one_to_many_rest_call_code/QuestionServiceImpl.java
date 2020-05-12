package com.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.entity.QuestionEntity;
import com.spring.json.Question;
import com.spring.rest.repository.QuestionRepository;
import com.spring.utils.QuestionUtils;

@Service
public class QuestionServiceImpl implements QuestionService {

	@Autowired
	QuestionRepository questionRepository;
	
	@Override
	public Question createNew(Question questionJson) {
		QuestionEntity questionEntity = QuestionUtils.convertQuestionToQuestionEntity(questionJson);
		questionEntity = questionRepository.save(questionEntity);
		Question questionJsonReturn = QuestionUtils.convertQuestionEntityToQuestionJson(questionEntity);
		return questionJsonReturn;
	}

}
