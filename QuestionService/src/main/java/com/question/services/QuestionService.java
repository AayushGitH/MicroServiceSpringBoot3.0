package com.question.services;

import java.util.List;

import com.question.entities.Question;

public interface QuestionService {

	Question saveQuestion(Question question);
	List<Question> getQuestions();
	Question getQuestion(Long questionId);
}
