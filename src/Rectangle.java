public class Rectangle extends Shape {
    Point lowerLeft;
    Point topRight;

    public Rectangle (Point lowerLeft, Point topRight){
        this.lowerLeft = lowerLeft;
        this.topRight = topRight;
    }

    public Rectangle (double x1, double y1, double x2, double y2){
        this.lowerLeft = new Point (x1, y1);
        this.topRight = new Point (x2, y2);
    }

    public double getLowerX (){
        return lowerLeft.getX();
    }

    public double getLowerY (){
        return lowerLeft.getY();
    }

    public double getHigherX (){
        return topRight.getX();
    }

    public double getHigherY (){
        return topRight.getY();
    }

    public boolean inside(Point p){
        Rectangle rect = this;
        if (p.getX() >= rect.getLowerX() && p.getY() >= rect.getLowerY() && p.getX() <= rect.getHigherX() && p.getY() <= rect.getHigherY()){
            return true;
        }
        return false;
    }
}