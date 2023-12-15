package com.example.course2.service;

import com.example.course2.model.Question;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService {

    private final HashSet<Question> questions = new HashSet<>();
    private final Random random = new Random();

    @Override
    public Question add(String question, String answer) {
        Question obj = new Question(question, answer);
        add(obj);
        return obj;
    }

    @Override
    public Question add(Question question) {
        questions.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        questions.remove(question);
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return questions;
    }

    @Override
    public Question getRandomQuestion() {
        List<Question> list = questions.stream().toList();
        int i = random.nextInt(list.size() - 1);
        return list.get(i);
    }
}
