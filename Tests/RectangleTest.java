import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RectangleTest {
    @Test
    void testInsideRect() {
        Point point = new Point(1,1);
        Rectangle rect = new Rectangle(0, 0, 2, 2);
        assertTrue(rect.insideRect(point),"Is inside the Rectangle so should return true");
    }
    @Test
    void testOutsideRect() {
        Point point = new Point(3,3);
        Rectangle rect = new Rectangle(0, 0, 2, 2);
        assertFalse(rect.insideRect(point),"Is outside the Rectangle so should return false");
    }
    @Test
    void testOnBoundary() {
        Point point = new Point(2,2);
        Rectangle rect = new Rectangle(0, 0, 2, 2);
        assertTrue(rect.insideRect(point),"Is on the border of the Rectangle so should return true");
    }
    @Test
    void xInyOut() {
        Point point = new Point(1,3);
        Rectangle rect = new Rectangle(0, 0, 2, 2);
        assertFalse(rect.insideRect(point),"y-value is outside the Rectangle so should return");
    }
    @Test
    void yInxOut() {
        Point point = new Point(3,1);
        Rectangle rect = new Rectangle(0, 0, 2, 2);
        assertFalse(rect.insideRect(point),"x-value is outside the Rectangle so should return false");
    }
    @Test
    void onLineNotEndpoint() {
        Point point = new Point(1,2);
        Rectangle rect = new Rectangle(0, 0, 2, 2);
        assertTrue(rect.insideRect(point),"Is inside the Rectangle so should return true");
    }
}
