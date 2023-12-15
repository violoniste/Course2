package com.example.course2.service;

import com.example.course2.exceptions.BadRequestException;
import com.example.course2.model.Question;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Set;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {

    private static final Question QUESTION = new Question("Сколько будет 2 + 2?", "Будет 4");

    ExaminerService out;
    QuestionService questionServiceMock;

    @BeforeEach
    void setUp() {
        questionServiceMock = Mockito.mock(JavaQuestionService.class);
        out = new ExaminerServiceImpl(questionServiceMock);
    }

    @Test
    void shouldReturnQuestion() {
        when(questionServiceMock.getRandomQuestion()).thenReturn(QUESTION);
        when(questionServiceMock.getAll()).thenReturn(Set.of(QUESTION));
        out.getQuestions(1);
    }

    @Test
    void shouldThrowException() {
        Assertions.assertThrows(BadRequestException.class, () -> out.getQuestions(1));
    }
}