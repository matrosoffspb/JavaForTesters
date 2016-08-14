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

        Point p1 = new Point();
        Point p2 = new Point();
        p1.x = 1;
        p1.y = 1;
        p2.x = 4;
        p2.y = 3;
        System.out.println("Расстояние между точками: " + distance(p1, p2));

    }
    public static void hello(String anybody){
        System.out.println("Hello, my " + anybody + "!");
    }
    public static double distance(Point p1, Point p2){
        return Math.sqrt( Math.pow(p2.x-p1.x, 2) + Math.pow(p2.y-p1.y, 2) );
    }

}