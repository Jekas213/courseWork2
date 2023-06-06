package com.example.coursework2.service;

import com.example.coursework2.domain.Question;
import com.example.coursework2.exceptions.NotExistException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import static com.example.coursework2.constants.ServiceConstants.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {

    @Mock
    private MathQuestionService mathMock;
    @Mock
    private JavaQuestionService javaNock;
    @InjectMocks
    private ExaminerServiceImpl out;

    @BeforeEach
    void setUp() {
        out = new ExaminerServiceImpl(javaNock, mathMock);

        when(mathMock.getAll()).thenReturn(Collections.unmodifiableSet(RANDOM_SET_MATH));
        when(javaNock.getAll()).thenReturn(Collections.unmodifiableSet(RANDOM_SET));
    }

    @Test
    void getQuestion() {
        when(mathMock.getRandomQuestion()).thenReturn(RANDOM_QUESTION_MATH);
        when(javaNock.getRandomQuestion()).thenReturn(RANDOM_QUESTION);

        Set<Question> extend = new HashSet<>();
        extend.add(RANDOM_QUESTION_MATH);
        extend.add(RANDOM_QUESTION);

        assertIterableEquals(extend, out.getQuestion(2));

    }

    @Test
    void getQuestionIncorrect() {
        assertThrows(NotExistException.class, () -> out.getQuestion(4));
    }
}