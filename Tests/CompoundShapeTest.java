import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CompoundShapeTest {

    @Test
    void addPositiveShape() {
        Shape circle = new Circle(new Point(1,1), 1d);
        CompoundShape compoundShape = new CompoundShape();
        compoundShape.addPositiveShape(circle);
        assertEquals(1, compoundShape.getNumbOfPositiveShapes(), "Either the addPositiveShape function failed or the getNumbOfPositiveShapes function failed");
    }

    @Test
    void addNegativeShape() {
        Shape circle = new Circle(new Point(1,1), 1d);
        CompoundShape compoundShape = new CompoundShape();
        compoundShape.addNegativeShape(circle);
        assertEquals(1, compoundShape.getNumbOfNegativeShapes(), "Either the addNegativeShape function failed or the getNumbOfNegativeShapes function failed");

    }


    @Test
    void addNullShape() {
        CompoundShape compoundShape = new CompoundShape();
        compoundShape.addPositiveShape(null);
        compoundShape.addNegativeShape(null);
        assertEquals(0, compoundShape.getNumbOfPositiveShapes(), "Adding a null shape should not add a shape");
        assertEquals(0, compoundShape.getNumbOfNegativeShapes(), "Adding a null shape should not add a shape");

    }

    @Test
    void insideSingleShape() {
        Shape circle = new Circle(new Point(1,1), 1d);
        CompoundShape compoundShape = new CompoundShape();
        compoundShape.addPositiveShape(circle);
        assertTrue(compoundShape.inside(new Point(1,1)), "Point was not found inside positive shape");
    }
    @Test
    void insideSingleShapeWithExtras() {
        Shape circle1 = new Circle(new Point(1,1), 1d);
        Shape circle2 = new Circle(new Point(5,1), 1d);
        Shape circle3 = new Circle(new Point(1,5), 1d);
        Shape circle4 = new Circle(new Point(5,5), 1d);
        CompoundShape compoundShape = new CompoundShape();
        compoundShape.addPositiveShape(circle1);
        compoundShape.addPositiveShape(circle2);
        compoundShape.addPositiveShape(circle3);
        compoundShape.addPositiveShape(circle4);
        assertTrue(compoundShape.inside(new Point(1,5)), "Point was not found inside 3rd positive shape");
    }
    @Test
    void insideNegativeShape() {
        Shape circle = new Circle(new Point(1,1), 1d);
        CompoundShape compoundShape = new CompoundShape();
        compoundShape.addNegativeShape(circle);
        assertFalse(compoundShape.inside(new Point(1,1)), "Negative shape acted as a positive shape");
    }
    @Test
    void insidePositiveAndNegative() {
        Shape circle = new Circle(new Point(1,1), 1d);
        Shape rect = new Rectangle(new Point(0,0), new Point(2,2));
        CompoundShape compoundShape = new CompoundShape();
        compoundShape.addPositiveShape(circle);
        compoundShape.addNegativeShape(rect);
        assertFalse(compoundShape.inside(new Point(1,1)), "Negative shape did not cancel the positive shape");
    }
    @Test
    void PositiveButNotNegative() {
        Shape circle = new Circle(new Point(1,1), 1d);
        Shape rect = new Rectangle(new Point(0,0), new Point(1,1));
        CompoundShape compoundShape = new CompoundShape();
        compoundShape.addPositiveShape(circle);
        compoundShape.addNegativeShape(rect);
        assertTrue(compoundShape.inside(new Point(1.5,1)), "Negative shape canceled outside point the positive shape");
    }
}