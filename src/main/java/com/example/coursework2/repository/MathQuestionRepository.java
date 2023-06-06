package com.example.coursework2.repository;

import com.example.coursework2.domain.Question;
import com.example.coursework2.exceptions.NotFoundException;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Repository
public class MathQuestionRepository implements QuestionRepository {
    private final Set<Question> questions;

    public MathQuestionRepository() {
        this.questions = new HashSet<>();
    }

    @PostConstruct
    private void init() {
        questions.add(new Question("math question 1", "math answer 1"));
        questions.add(new Question("math question 2", "math answer 2"));
        questions.add(new Question("math question 3", "math answer 3"));
        questions.add(new Question("math question 4", "math answer 4"));
        questions.add(new Question("math question 5", "math answer 5"));
    }

    @Override
    public Question add(Question question) {
        questions.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        if (!questions.contains(question)) {
            throw new NotFoundException();
        }
        questions.remove(question);
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return Collections.unmodifiableSet(questions);
    }
}
