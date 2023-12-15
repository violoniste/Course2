package com.example.course2.service;

import com.example.course2.model.Question;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collection;

@ExtendWith(MockitoExtension.class)
class JavaQuestionServiceTest {

    private static final Question QUESTION1 = new Question("Сколько будет 2 + 2?", "Будет 4");
    private static final Question QUESTION2 = new Question("Сколько будет 4 + 2?", "Будет 6");
    private static final Question QUESTION3 = new Question("Земля круглая", "Да вроде бы");

    JavaQuestionService out;

    @BeforeEach
    void setUp() {
        out = new JavaQuestionService();
    }

    @Test
    void add1() {
        Assertions.assertEquals(out.getAll().size(), 0);
        out.add("Сколько будет 2 + 2?", "Будет 4");
        Assertions.assertEquals(out.getAll().size(), 1);
    }

    @Test
    void add2() {
        Assertions.assertEquals(out.getAll().size(), 0);
        out.add(QUESTION1);
        out.add(QUESTION2);
        Assertions.assertEquals(out.getAll().size(), 2);
    }

    @Test
    void remove() {
        out.add(QUESTION1);
        out.add(QUESTION2);
        Assertions.assertEquals(out.getAll().size(), 2);
        out.remove(QUESTION1);
        Assertions.assertEquals(out.getAll().size(), 1);
    }

    @Test
    void getAll() {
        Assertions.assertEquals(out.getAll().size(), 0);
        out.add(QUESTION1);
        out.add(QUESTION2);
        out.add(QUESTION3);
        Collection<Question> all = out.getAll();
        Assertions.assertEquals(all.size(), 3);
        Assertions.assertTrue(all.contains(QUESTION1));
        Assertions.assertTrue(all.contains(QUESTION2));
        Assertions.assertTrue(all.contains(QUESTION3));
    }

    @Test
    void getRandomQuestion() {
        out.add(QUESTION1);
        out.add(QUESTION2);
        out.add(QUESTION3);
        Question question = out.getRandomQuestion();
        Assertions.assertTrue(question.equals(QUESTION1) || question.equals(QUESTION2) || question.equals(QUESTION3));
    }
}