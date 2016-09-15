package com.lesson.hometask;

import java.util.Arrays;
import java.util.List;

public class Collections {

    public static void main(String[] args) {
        String[] langs = {"Java", "PHP", "Python", "C#"};

        List<String> languages = Arrays.asList("Java", "PHP", "Python", "C#");

        for (String l : languages)
        {
            System.out.println("I want learn " + l);
        }
    }
}
