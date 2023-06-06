package com.example.coursework2.service;

import com.example.coursework2.domain.Question;
import com.example.coursework2.exceptions.NotExistException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    private final QuestionService javaQuestionService;
    private final QuestionService mathQuestionService;

    private final Random random = new Random();

    public ExaminerServiceImpl(@Qualifier("javaQuestionService") QuestionService javaQuestionService,
                               @Qualifier("mathQuestionService") QuestionService mathQuestionService) {
        this.mathQuestionService = javaQuestionService;
        this.javaQuestionService = mathQuestionService;
    }

    @Override
    public Collection<Question> getQuestion(int amount) {
        if (amount > javaQuestionService.getAll().size() + mathQuestionService.getAll().size()) {
            throw new NotExistException();
        }

        final Set<Question> questionSet = new HashSet<>();

        while (questionSet.size() != amount) {
            final boolean boolRandom = random.nextBoolean();

            if (boolRandom) {
                questionSet.add(javaQuestionService.getRandomQuestion());
            } else {
                questionSet.add(mathQuestionService.getRandomQuestion());
            }
        }
        return Collections.unmodifiableSet(questionSet);
    }
}
