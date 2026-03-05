import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class CompoundShape extends Shape{
    private class LinkedList{
        //Probably a poor implementation of a linked list
        Shape heldShape = null;
        LinkedList nextLink = null;

        LinkedList(Shape shape){
            heldShape = shape;
        }
        void add(Shape shape){
            if (nextLink != null){
                nextLink.add(shape);
            }
            else {
                nextLink = new LinkedList(shape);
            }
        }
    }

    LinkedList positiveShapes;
    LinkedList negativeShapes;

    public CompoundShape(){

    }

    public void addPositiveShape(Shape shape){
        if (positiveShapes == null){
            positiveShapes = new LinkedList(shape);
        }
        else {
            positiveShapes.add(shape);
        }
    }
    public void addNegativeShape(Shape shape){
        if (negativeShapes == null){
            negativeShapes = new LinkedList(shape);
        }
        else {
            negativeShapes.add(shape);
        }

    }

    @Override
    public boolean inside(Point point) {
        boolean inside = false;
        LinkedList currentLink = positiveShapes;
        while (currentLink != null && !inside){
            //Check if inside a positive shape, the while loop will exit if there is no more shapes, or the point is in a shape.
            inside = currentLink.heldShape.inside(point);
            currentLink = currentLink.nextLink;
        }
        if (inside){
            //Inside a positive shape so check if inside a negative one
            currentLink = negativeShapes;
            while (currentLink != null && inside){
                //Check if inside a negative shape, the while loop will exit if there is no more shapes, or the point is in a shape.
                inside = !currentLink.heldShape.inside(point); //If inside a negative shape then not in the compound shape
                currentLink = currentLink.nextLink;
            }
        }
        return inside;
    }
}
