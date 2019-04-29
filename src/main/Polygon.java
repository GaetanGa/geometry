package main;

import java.util.ArrayList;
import java.util.List;

public class Polygon {

    private List<Point> points;

    public Polygon(double x, double y) {
        points = new ArrayList<>();
        points.add(new Point(x, y));
    }

    public void addPoint(Point p){
        points.add(p);
    }

    public void addPoints(List<Point> l){
        points.addAll(l);
    }

    public List<Point> getPoints(){
        return points;
    }

}
