package com.example.coursework2.repository;

import com.example.coursework2.domain.Question;
import com.example.coursework2.exceptions.NotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class JavaQuestionRepositoryTest {
    private final JavaQuestionRepository out = new JavaQuestionRepository();

    @BeforeEach
    void setUp() {
        out.add(new Question("question 1", "answer 1"));
    }

    @Test
    void addCorrect() {
        Question extend = new Question("question", "answer");
        Question result = out.add(new Question("question", "answer"));

        assertEquals(extend, result);
    }

    @Test
    void removeCorrect() {
        Question extend = new Question("question 1", "answer 1");
        Question result = out.remove(new Question("question 1", "answer 1"));

        assertEquals(extend, result);
    }

    @Test
    void removeNotFound() {
        assertThrows(NotFoundException.class, () -> out.remove(new Question("question", "answer")));
    }


    @Test
    void getAllCorrect() {
        Collection<Question> extend = new HashSet<>(Set.of(new Question("question 1", "answer 1")));

        assertIterableEquals(extend, out.getAll());
    }
}