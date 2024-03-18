package com.question.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.question.entities.Question;
import com.question.repositories.QuestionRepository;
import com.question.services.QuestionService;

@Service
public class QuestionServiceImpl implements QuestionService {
	
	@Autowired
	private QuestionRepository questionRepository;

	@Override
	public Question saveQuestion(Question question) {
		return this.questionRepository.save(question);
	}

	@Override
	public List<Question> getQuestions() {
		return this.questionRepository.findAll();
	}

	@Override
	public Question getQuestion(Long questionId) {
		return this.questionRepository.findById(questionId).orElseThrow(()->new RuntimeException("The question with the given id is not found.."));
	}

	@Override
	public List<Question> getQuestionByQuizId(Long quizId) {
		return this.questionRepository.findByQuizId(quizId);
	}

}
