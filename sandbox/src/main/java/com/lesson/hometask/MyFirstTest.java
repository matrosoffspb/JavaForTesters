package com.lesson.hometask;

public class MyFirstTest {

    public static void main(String[] args) {
        hello("frends");
        hello("child");
        hello("wife");
        hello("mother");
        hello("father");

        Square s = new Square(6);
        System.out.println("Площадь квадрата со стороной " + s.l + " = " + s.area());

        Rectangle r = new Rectangle(4,6);
        System.out.println("Площадь прямоугольника со сторонами " + r.a + " и " + r.b + " = " + r.area());

        Point p1 = new Point(1,1);
<<<<<<< HEAD:sandbox/src/main/java/com/lesson/hometask/MyFirstTest.java
        Point p2 = new Point(5,5);
=======
        Point p2 = new Point(4,3);
>>>>>>> refs/remotes/origin/master:sandbox/src/main/java/com/lesson1/hometask/MyFirstTest.java
        System.out.println("Расстояние между точками: " + p2.distance(p1));

    }
    public static void hello(String anybody){
        System.out.println("Hello, my " + anybody + "!");
    }
}