package com.lesson1.hometask;

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

        Point p1 = new Point(1,1);
        Point p2 = new Point(4,3);
        System.out.println("Расстояние между точками: " + p2.distance(p1,p2));

    }
    public static void hello(String anybody){
        System.out.println("Hello, my " + anybody + "!");
    }
}