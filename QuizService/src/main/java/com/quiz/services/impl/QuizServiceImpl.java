package com.quiz.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.entities.Quiz;
import com.quiz.repositories.QuizRepository;
import com.quiz.services.QuizService;

@Service
public class QuizServiceImpl implements QuizService{

	@Autowired
	private QuizRepository quizRepository;
	
	@Override
	public Quiz addQuiz(Quiz quiz) {
		return this.quizRepository.save(quiz);
	}

	@Override
	public List<Quiz> getAllQuiz() {
		return this.quizRepository.findAll();
	}

	@Override
	public Quiz getQuiz(Long id) {
		return this.quizRepository.findById(id).orElseThrow(()->new RuntimeException("The quiz is not found with the respective id"));
	}

}
