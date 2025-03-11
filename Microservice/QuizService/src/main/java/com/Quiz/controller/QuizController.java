package com.Quiz.controller;


import com.Quiz.entites.Quiz;
import com.Quiz.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
public class QuizController {  // Fixed typo in class name

    @Autowired
    private QuizService quizService;

    @PostMapping
    public Quiz create(@RequestBody Quiz quiz) {
        System.out.println(quiz.getTitle());

        return quizService.add(quiz);
    }



    @GetMapping
    public List<Quiz> getAll() {
        return quizService.get();
    }

    @GetMapping("/{id}")
    public Quiz get(@PathVariable Long id) {
        return quizService.get(id);
    }
}
