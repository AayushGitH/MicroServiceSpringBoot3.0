package com.question.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/question-test")
public class TestController {

	@GetMapping
	public String test() {
		return "I am the test method in Question service";
	}
}
