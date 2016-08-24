package com.lesson.hometask;


import org.testng.Assert;
import org.testng.annotations.Test;

public class SquareAreaTests {

@Test
    public void testArea() {

    Square s = new Square(6);
        Assert.assertEquals(s.area(), 36.0, "This is Square area");
    }
}
