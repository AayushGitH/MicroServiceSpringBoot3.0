package com.question.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.question.entities.Question;
import com.question.services.QuestionService;

@RestController
@RequestMapping("/question")
public class QuestionController {

	@Autowired
	private QuestionService questionService;
	
	@PostMapping
	private ResponseEntity<Question> saveQuestion(@RequestBody Question question) {
		return ResponseEntity.status(HttpStatus.CREATED).body(this.questionService.saveQuestion(question));
	}
	
	@GetMapping("/{questionId}")
	private ResponseEntity<Question> getQuestion(@PathVariable Long questionId) {
		return ResponseEntity.status(HttpStatus.OK).body(this.questionService.getQuestion(questionId));
	}
	
	@GetMapping
	private ResponseEntity<List<Question>> getQuestion() {
		return ResponseEntity.status(HttpStatus.OK).body(this.questionService.getQuestions());
	}
	
	@GetMapping("/quiz/{quizId}")
	private ResponseEntity<List<Question>> getQuestionByQuizId(@PathVariable Long quizId) {
		return ResponseEntity.status(HttpStatus.OK).body(this.questionService.getQuestionByQuizId(quizId));
	}
}
