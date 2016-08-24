package com.lesson.hometask;


import org.testng.Assert;
import org.testng.annotations.Test;

public class PointDistanceTests {

    @Test

    public void pointDistance(){

        Point p1 = new Point(1,1);
        Point p2 = new Point(5,5);

        Assert.assertEquals(p2.distance(p1), 5.656854249492381, "This is distance between points");
    }

    @Test
    public void wrongPointDistance(){
        Point p1 = new Point(1,1);
        Point p2 = new Point(5,5);

        Assert.assertEquals(p2.distance(p1), 5.656, "This is wrong distance between points");

    }

    @Test
    public void PointDistance2(){
        Point p1 = new Point(1,1);
        Point p2 = new Point(3,5);

        Assert.assertEquals(p2.distance(p1), 4.47213595499958, "This is distance between points");

    }
}
