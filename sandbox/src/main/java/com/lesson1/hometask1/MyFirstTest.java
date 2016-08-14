package com.lesson1.hometask1;

public class MyFirstTest {

    public static void main(String[] args) {
        hello("frends");
        hello("child");
        hello("wife");
        hello("mother");
        hello("father");

        double len = 5;
        System.out.println("Площадь квадрата со стороной " + len + " = " + area(len));

        double a = 4;
        double b = 6;
        System.out.println("Площадь прямоугольника со сторонами " + a + " и " + b + " = " + area(a,b));
    }
    public static void hello(String anybody){
        System.out.println("Hello, my " + anybody + "!");
    }

    public static double area (double l){
        return l*l;
    }
    public static double area (double a, double b){
        return a * b;
    }
}