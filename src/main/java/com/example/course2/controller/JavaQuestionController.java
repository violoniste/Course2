package com.example.course2.controller;

import com.example.course2.model.Question;
import com.example.course2.service.QuestionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping(path = "/exam")
@SuppressWarnings("unused")
public class JavaQuestionController {
    private final QuestionService service;

    public JavaQuestionController(QuestionService service) {
        this.service = service;
    }

    @GetMapping("/java/add")
    public Question addQuestion(@RequestParam("question") String question, @RequestParam("answer") String answer) {
        return service.add(question, answer);
    }

    @GetMapping("/java/remove")
    public Question removeQuestion(@RequestParam("question") String question, @RequestParam("answer") String answer) {
        return service.remove(new Question(question, answer));
    }

    @GetMapping("/java")
    public Collection<Question> getQuestions() {
        return service.getAll();
    }

    //    @GetMapping("/get/{amount}")
//    public List<Question> getAmount(@PathVariable("amount") int amount) {
//        return service.getQuestions();
//    }
}
