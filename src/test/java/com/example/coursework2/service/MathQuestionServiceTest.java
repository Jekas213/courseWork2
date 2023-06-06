package com.example.coursework2.service;

import com.example.coursework2.domain.Question;
import com.example.coursework2.exceptions.NotFoundException;
import com.example.coursework2.repository.MathQuestionRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.example.coursework2.constants.ServiceConstants.RANDOM_QUESTION;
import static com.example.coursework2.constants.ServiceConstants.RANDOM_SET;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class MathQuestionServiceTest {
    @Mock
    private MathQuestionRepository mock;
    @InjectMocks
    private MathQuestionService out;


    @Test
    void addByStringCorrect() {
        when(mock.add(any())).thenReturn(RANDOM_QUESTION);

        assertEquals(RANDOM_QUESTION, out.add("question", "answer"));

    }

    @Test
    void addByQuestionCorrect() {
        when(mock.add(any())).thenReturn(RANDOM_QUESTION);

        assertEquals(RANDOM_QUESTION, out.add(new Question("question", "answer")));
    }

    @Test
    void removeCorrect() {
        when(mock.remove(any())).thenReturn(RANDOM_QUESTION);

        assertEquals(RANDOM_QUESTION, out.remove(new Question("question", "answer")));
    }

    @Test
    void removeInCorrect() {
        when(mock.remove(any())).thenThrow(NotFoundException.class);

        assertThrows(NotFoundException.class, () -> out.remove(new Question("que", "ans")));
    }

    @Test
    void getAllCorrect() {
        when(mock.getAll()).thenReturn(RANDOM_SET);

        assertIterableEquals(RANDOM_SET, out.getAll());
    }

    @Test
    void getRandomQuestionCorrect() {
        when(mock.getAll()).thenReturn(RANDOM_SET);

        assertEquals(RANDOM_QUESTION, out.getRandomQuestion());
    }
}