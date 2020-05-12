package com.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.json.Question;
import com.spring.service.QuestionService;

@RestController
@RequestMapping("/myapp")
@CrossOrigin(origins="*")
public class QusAnsController {

	@Autowired
	private QuestionService questionService;
	
	@PostMapping(value="/question", produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Question createNewQuestion(@RequestBody Question questionJson) {
		return questionService.createNew(questionJson);
	}	
}
