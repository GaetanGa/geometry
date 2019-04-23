package main;

public class Polygon {

    private Point[] points;

    public Polygon(double[] x, double[] y) {
        //Fill the list of the peaks
        for (int i = 0; i < x.length; i++) {
            this.points[i] = new Point(x[i], y[i]);
        }
    }


}
