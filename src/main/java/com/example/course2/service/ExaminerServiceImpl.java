package com.example.course2.service;

import com.example.course2.exceptions.BadRequestException;
import com.example.course2.model.Question;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    private final QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        int size = questionService.getAll().size();
        if (amount > size)
            throw new BadRequestException();

        HashSet<Question> set = new HashSet<>();
        while (set.size() < amount) {
            Question question = questionService.getRandomQuestion();
            if (set.contains(question))
                continue;

            set.add(question);
        }

        return set;
    }
}
