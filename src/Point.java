public class Point {
    double x, y;

    public Point (double x, double y){
        this.x = x;
        this.y = y;
    }

    public double distance (Point other){
        //Returns the distance from this point and another point
        double xDif = x - other.getX();
        double yDif = y - other.getY();
        return Math.sqrt((Math.pow(xDif,2) + Math.pow(yDif,2)));
    }

    public boolean above (Point other){
        //Returns true if both the x and y value are greater than the other point's x and y values
        return (x > other.getX()) && (y > other.getY());
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}
