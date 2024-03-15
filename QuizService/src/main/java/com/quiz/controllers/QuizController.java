package com.quiz.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.entities.Quiz;
import com.quiz.services.QuizService;

@RestController
@RequestMapping("/quiz")
public class QuizController {

	@Autowired
	private QuizService quizService;
	
	@PostMapping
	public ResponseEntity<Quiz> createQuiz(@RequestBody Quiz quiz) {
		return ResponseEntity.status(HttpStatus.CREATED).body(this.quizService.addQuiz(quiz));
	}
	
	@GetMapping
	public ResponseEntity<List<Quiz>> createQuiz() {
		return ResponseEntity.status(HttpStatus.OK).body(this.quizService.getAllQuiz());
	}
	
	@GetMapping("/{quizId}")
	public ResponseEntity<Quiz> getSingleQuiz(@PathVariable Long quizId) {
		return ResponseEntity.status(HttpStatus.OK).body(this.quizService.getQuiz(quizId));
	}
}
