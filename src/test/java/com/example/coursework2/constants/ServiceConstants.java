package com.example.coursework2.constants;

import com.example.coursework2.domain.Question;

import java.util.HashSet;
import java.util.Set;

public class ServiceConstants {
    public static final Question RANDOM_QUESTION = new Question("question", "answer");
    public static final Set<Question> RANDOM_SET = new HashSet<>(Set.of(new Question("question", "answer")));
}
