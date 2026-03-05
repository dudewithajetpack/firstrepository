public class CompoundShape extends Shape{
    private class LinkedShapes {
        //Probably a poor implementation of a linked list
        Shape heldShape;
        LinkedShapes nextLink = null;

        LinkedShapes(Shape shape){
            heldShape = shape;
        }
        void add(Shape shape){
            if (nextLink != null){
                nextLink.add(shape);
            }
            else {
                nextLink = new LinkedShapes(shape);
            }
        }
    }

    private LinkedShapes positiveShapes;
    private LinkedShapes negativeShapes;

    public CompoundShape(){

    }

    public void addPositiveShape(Shape shape){
        if (shape == null) return;

        if (positiveShapes == null){
            positiveShapes = new LinkedShapes(shape);
        }
        else {
            positiveShapes.add(shape);
        }
    }
    public void addNegativeShape(Shape shape){
        if (shape == null) return;

        if (negativeShapes == null){
            negativeShapes = new LinkedShapes(shape);
        }
        else {
            negativeShapes.add(shape);
        }

    }

    @Override
    public boolean inside(Point point) {
        boolean inside = false;
        LinkedShapes currentLink = positiveShapes;
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

    public int getNumbOfPositiveShapes(){
        int count = 0;
        LinkedShapes currentLink = positiveShapes;
        while (currentLink != null){
            count++;
            currentLink = currentLink.nextLink;
        }
        return count;
    }

    public int getNumbOfNegativeShapes(){
        int count = 0;
        LinkedShapes currentLink = negativeShapes;
        while (currentLink != null){
            count++;
            currentLink = currentLink.nextLink;
        }
        return count;
    }

}
