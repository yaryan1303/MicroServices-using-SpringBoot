package com.Question.QuestionController;

import com.Question.Service.QuestionService;
import com.Question.entities.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
public class controller {

    @Autowired
    private QuestionService questionService;

    @PostMapping
    public Question create(@RequestBody Question question)
    {
        return questionService.create(question);

    }

    @GetMapping
    public List<Question>getAll()
    {
        return questionService.get();
    }

    @GetMapping("/{id}")
    public Question getQuestion(@PathVariable Long id)
    {
        return questionService.get(id);
    }

    @GetMapping("/quiz/{id}")
    public List<Question> getAllQuestions(@PathVariable Long id)
    {
        return questionService.getQuestionByQuizId(id);
    }


}
