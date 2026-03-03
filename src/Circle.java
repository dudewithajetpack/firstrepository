public class Circle {

    private Point position;
    private Double radius;

    public Circle(Point position, Double radius){
        this.position = position;
        this.radius = radius;
    }

    public boolean inside (Point other){
        return radius >= position.distance(other);
    }
}
