package main;

public class Segment {

    // VARIABLES
    private Edge p1;
    private Edge p2;
    private Double d;

    //CONSTRUCTOR
    public Segment(Edge _p1, Edge _p2){
        this.p1 = _p1;
        this.p2 = _p2;

        p1.setSegment(this);
        p2.setSegment(this);
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

    public Double getD() {
        return d;
    }

    public void setD(Double d) {
        this.d = d;
    }
}
