package com.lesson.hometask;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RectangleAreaTests {

    @Test

    public void rectangleArea() {

        Rectangle r = new Rectangle(4,6);

        Assert.assertEquals(r.area(), 24.0, "This is Rectangle area");

    }
}
