package com.example.coursework2.service;

import com.example.coursework2.domain.Question;
import com.example.coursework2.exceptions.NotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.example.coursework2.constants.ServiceConstants.*;
import static org.junit.jupiter.api.Assertions.*;

class JavaQuestionServiceTest {

    private final JavaQuestionService out = new JavaQuestionService();

    @BeforeEach
    void setUp() {
        out.add("question", "answer");
    }

    @Test
    void addByStringCorrect() {
        assertEquals(RANDOM_QUESTION, out.add("question", "answer"));
    }

    @Test
    void addByQuestionCorrect() {
        assertEquals(RANDOM_QUESTION, out.add(new Question("question", "answer")));
    }

    @Test
    void removeCorrect() {
        assertEquals(RANDOM_QUESTION, out.remove(new Question("question", "answer")));
    }

    @Test
    void removeInCorrect() {
        assertThrows(NotFoundException.class, () -> out.remove(new Question("que", "ans")));
    }

    @Test
    void getAllCorrect() {
        assertIterableEquals(RANDOM_SET, out.getAll());
    }

    @Test
    void getRandomQuestionCorrect() {
        assertEquals(RANDOM_QUESTION, out.getRandomQuestion());
    }

}