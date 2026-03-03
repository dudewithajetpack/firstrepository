import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CircleTest {

    @Test
    void outside() {
        Circle circle = new Circle(new Point(1,1), 1d);
        assertFalse(circle.inside(new Point(0,0)), "The outside was considered inside");

    }
    @Test
    void insideEdge() {
        Circle circle = new Circle(new Point(1,1), 1d);
        assertTrue(circle.inside(new Point(1,2)), "The edge was not considered inside");
    }
    @Test
    void insideCenter() {
        Circle circle = new Circle(new Point(1,1), 1d);
        assertTrue(circle.inside(new Point(1,1)), "The center was not considered inside");
    }

}