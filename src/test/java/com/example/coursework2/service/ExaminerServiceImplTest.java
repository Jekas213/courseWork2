package com.example.coursework2.service;

import com.example.coursework2.domain.Question;
import com.example.coursework2.exceptions.NotExistException;
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
    private JavaQuestionService javaQuestionServiceMock;
    @InjectMocks
    private ExaminerServiceImpl out;

    @Test
    void getQuestionCorrect() {
        when(javaQuestionServiceMock.getRandomQuestion()).thenReturn(RANDOM_QUESTION);
        when(javaQuestionServiceMock.getAll()).thenReturn(Collections.unmodifiableSet(RANDOM_SET));

        Set<Question> expected = new HashSet<>(Set.of(RANDOM_QUESTION));

        assertIterableEquals(Collections.unmodifiableSet(expected), out.getQuestion(1));
    }

    @Test
    void getQuestionInCorrect() {
        when(javaQuestionServiceMock.getAll()).thenReturn(Collections.unmodifiableSet(RANDOM_SET));

        assertThrows(NotExistException.class, () -> out.getQuestion(2));
    }

}