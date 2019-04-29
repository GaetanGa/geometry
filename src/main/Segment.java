package main;

public class Segment {

    // VARIABLES
    private Edge p1;
    private Edge p2;
    private Double distance;

    //CONSTRUCTOR
    public Segment(){

    }

    // GETTERS / SETTERS
    public Edge getP1() {
        return p1;
    }

    public void setP1(Edge p1) {
        this.p1 = p1;
    }

    public Edge getP2() {
        return p2;
    }

    public void setP2(Edge p2) {
        this.p2 = p2;
    }

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }
}
