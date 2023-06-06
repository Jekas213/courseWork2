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
public class JavaQuestionRepository implements QuestionRepository {
    private final Set<Question> questions;

    public JavaQuestionRepository() {
        this.questions = new HashSet<>();
    }

    @PostConstruct
    private void init() {
        questions.add(new Question("java question 1", "java answer 1"));
        questions.add(new Question("java question 2", "java answer 2"));
        questions.add(new Question("java question 3", "java answer 3"));
        questions.add(new Question("java question 4", "java answer 4"));
        questions.add(new Question("java question 5", "java answer 5"));
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
