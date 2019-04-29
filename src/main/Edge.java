package main;

public class Edge extends Point{

    // VARIABLES
    private Boolean begin;
    private Segment segment;
    private Double angle;
    private Boolean visualize;

    // CONSTRUCOR
    public Edge(Double _x, Double _y){
        super(_x, _y);
    }

    // GETTERS / SETTERS
    public Boolean getBegin() {
        return begin;
    }

    public void setBegin(Boolean begin) {
        this.begin = begin;
    }

    public Segment getSegment() {
        return segment;
    }

    public void setSegment(Segment segment) {
        this.segment = segment;
    }

    public Double getAngle() {
        return angle;
    }

    public void setAngle(Double angle) {
        this.angle = angle;
    }

    public Boolean getVisualize() {
        return visualize;
    }

    public void setVisualize(Boolean visualize) {
        this.visualize = visualize;
    }
}