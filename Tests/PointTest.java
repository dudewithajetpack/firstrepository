import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PointTest {

    @Test
    void distanceZero() {
        Point point = new Point( 0d,0d);
        Point otherPoint = new Point(0d,0d);
        assertEquals(0,point.distance(otherPoint),"Equal points should have zero distance");
    }
    @Test
    void distance1X() {
        Point point = new Point( 0d,0d);
        Point otherPoint = new Point(1d,0d);
        assertEquals(1,point.distance(otherPoint),"(1,0) should have a distance of 1 from the origin");
    }
    @Test
    void distance1Y() {
        Point point = new Point( 0d,0d);
        Point otherPoint = new Point(0d,1d);
        assertEquals(1,point.distance(otherPoint),"(0,1) should have a distance of 1 from the origin");
    }
    @Test
    void distance1XY() {
        Point point = new Point( 0d,0d);
        Point otherPoint = new Point(1d,1d);
        assertEquals(Math.sqrt(2),point.distance(otherPoint),"(1,1) should have a distance of ~1.41 from the origin");
    }
    @Test
    void distanceNegative() {
        Point point = new Point( 0d,0d);
        Point otherPoint = new Point(-1d,-1d);
        assertEquals(Math.sqrt(2),point.distance(otherPoint),"(-1,-1) should have a distance of ~1.41 from the origin");
    }
    @Test
    void distanceMixed() {
        Point point = new Point( 1d,0d);
        Point otherPoint = new Point(0d,-1d);
        assertEquals(Math.sqrt(2),point.distance(otherPoint),"(1,0) should have a distance of ~1.41 from (0,-1)");
    }

    @Test
    void aboveEqualPoints() {
        Point point = new Point( 0d,0d);
        Point otherPoint = new Point(0d,0d);
        assertFalse(point.above(otherPoint), "Equal points should return false");
    }
    @Test
    void aboveEqualX() {
        Point point = new Point( 0d,1d);
        Point otherPoint = new Point(0d,0d);
        assertFalse(point.above(otherPoint), "Points with equal x values should return false");
    }
    @Test
    void aboveEqualY() {
        Point point = new Point( 1d,0d);
        Point otherPoint = new Point(0d,0d);
        assertFalse(point.above(otherPoint), "Points with equal y values should return false");
    }
    @Test
    void aboveAbove() {
        Point point = new Point( 1d,1d);
        Point otherPoint = new Point(0d,0d);
        assertTrue(point.above(otherPoint), "An above point returned false");
    }
    @Test
    void aboveBellow() {
        Point point = new Point( -1d,-1d);
        Point otherPoint = new Point(0d,0d);
        assertFalse(point.above(otherPoint), "A non-above point returned true");
    }

    @Test
    void getX() {
        Point point = new Point(1d,2d);
        assertEquals(1d, point.getX(),"getX returned a different value then set");
    }

    @Test
    void getY() {
        Point point = new Point(1d,2d);
        assertEquals(2d, point.getY(),"getY returned a different value then set");
    }
}