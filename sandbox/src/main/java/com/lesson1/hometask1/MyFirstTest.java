package com.lesson1.hometask1;

public class MyFirstTest {

    public static void main(String[] args) {
        hello("frends");
        hello("child");
        hello("wife");
        hello("mother");
        hello("father");

        Square s = new Square(5);
        System.out.println("Площадь квадрата со стороной " + s.l + " = " + s.area());

        Rectangle r = new Rectangle(4,6);
        System.out.println("Площадь прямоугольника со сторонами " + r.a + " и " + r.b + " = " + r.area());
    }
    public static void hello(String anybody){
        System.out.println("Hello, my " + anybody + "!");
    }

}