package com.Quiz.service;

import com.Quiz.entites.Quiz;

import java.util.List;

public interface QuizService {

    Quiz add(Quiz quiz);


    List<Quiz>get();
    Quiz get(Long id);
}
