package com.quiz.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.entities.Quiz;
import com.quiz.repositories.QuizRepository;
import com.quiz.services.QuestionClient;
import com.quiz.services.QuizService;

@Service
public class QuizServiceImpl implements QuizService{

	@Autowired
	private QuizRepository quizRepository;
	
	@Autowired
	private QuestionClient questionClient;
	
	@Override
	public Quiz addQuiz(Quiz quiz) {
		return this.quizRepository.save(quiz);
	}

	@Override
	public List<Quiz> getAllQuiz() {
		
		List<Quiz> quizzes = this.quizRepository.findAll();
		quizzes.stream().map(quiz -> {
			quiz.setQuestions(this.questionClient.getQuestionsOfQuiz(quiz.getId()));
			return quiz;
		}).collect(Collectors.toList());
		
		return this.quizRepository.findAll();
	}

	@Override
	public Quiz getQuiz(Long id) {
		
		Quiz quiz = this.quizRepository.findById(id).orElseThrow(()->new RuntimeException("The quiz is not found with the respective id"));
		quiz.setQuestions(this.questionClient.getQuestionsOfQuiz(quiz.getId()));
		return quiz;
	}

}
