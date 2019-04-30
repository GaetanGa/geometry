package main;

import java.util.ArrayList;
import java.util.List;

public class View {

    // VARIABLES
    private List<Segment> segments;
    private List<Edge> edges;
    private Point viewer;

    // CONSTRUCTOR
    public View() {
        this.segments = new ArrayList<>();
        this.edges = new ArrayList<>();
        this.viewer = new Point(0d, 0d);
    }

    // METHODES

    /**
     * Creation of the map borders
     * @param size
     */
    public void loadEdgeOfMap(Double size){
        addSegment(0d, 0d, 0d, size);
        addSegment(0d,0d, size,0d);
        addSegment(size,0d, size, size);
        addSegment(0d, size, size, size);
    }

    /**
     * Add a segment to the view
     * @param x1
     * @param y1
     * @param x2
     * @param y2
     */
    public void addSegment(Double x1, Double y1, Double x2, Double y2){
        Edge p1 = new Edge(x1, y1);
        Edge p2 = new Edge(x2, y2);

        Segment segment = new Segment(p1, p2);
        segments.add(segment);
        edges.add(p1);
        edges.add(p2);
    }

    /**
     * Loading elements composing the map
     * @param size
     * @param blocks
     * @param walls
     */
    public void loadMap(Double size, List<Block> blocks, List<Segment> walls){
        segments.clear();
        edges.clear();

        // Loading the edge of the map
        loadEdgeOfMap(size);

        // Streaming the list of blocks to create their segments
        blocks.stream().forEach(b -> {
            // Recovering properties of the current block
            Double x = b.getX();
            Double y = b.getY();
            Double r = b.getR();

            // Building the segments composing the block
            addSegment(x - r, y - r, x - r, y + r);
            addSegment(x - r, y + r, x + r, y + r);
            addSegment(x + r, y + r, x + r, y - r);
            addSegment(x + r, y - r, x - r, y - r);
        });

        // Streaming the list of walls to create corresponding segments
        walls.stream().forEach(w -> {
            addSegment(w.getP1().getX(), w.getP1().getY(), w.getP2().getX(), w.getP2().getY());
        });

    }

    /**
     * Set the position of the viewer
     * @param x
     * @param y
     */
    public void setViewerLocation(Double x, Double y){
        viewer.setX(x);
        viewer.setY(y);

        segments.stream().forEach(seg -> {
            Double dx = 0.5 * (seg.getP1().getX() + seg.getP2().getX()) - x;
            Double dy = 0.5 * (seg.getP1().getY() + seg.getP2().getY()) - y;

            seg.setD(dx * dx + dy * dy);
            seg.getP1().setAngle(Math.atan2(seg.getP1().getY() - y, seg.getP1().getX() - x));
            seg.getP2().setAngle(Math.atan2(seg.getP2().getY() - y, seg.getP2().getX() - x));

            Double dAngle = seg.getP2().getAngle() - seg.getP1().getAngle();

            if(dAngle <= -Math.PI) dAngle += 2 * Math.PI;
            if(dAngle > Math.PI) dAngle -= 2 * Math.PI;

            seg.getP1().setBegin(dAngle > 0d);
            seg.getP2().setBegin(!seg.getP1().getBegin());
        });
    }

    /**
     * Indicate if a segment is in front of another relative to a point
     * @param a
     * @param b
     * @param point
     * @return
     */
    protected Boolean segmentAInFrontOfB(Segment a, Segment b, Point point){
        Boolean A1 = leftOf(a, interpolate(b.getP1(), b.getP2(), 0.01));
        Boolean A2 = leftOf(a, interpolate(b.getP1(), b.getP2(), 0.01));
        Boolean A3 = leftOf(a, point);
        Boolean B1 = leftOf(b, interpolate(a.getP1(), a.getP2(), 0.01));
        Boolean B2 = leftOf(b, interpolate(a.getP1(), a.getP2(), 0.01));
        Boolean B3 = leftOf(b, point);

        if( B1.equals(B2) && !B2.equals(B3)) return true;
        if( A1.equals(A2) && A2.equals(A3)) return true;
        if( A1.equals(A2) && !A2.equals(A3)) return false;
        if( B1.equals(B2) && B2.equals(B3)) return false;

        return false;
    }

    /**
     * Method to scan for visible edges
     * @param maxAngle
     */
    public void scan(Double maxAngle){

    }

    /**
     *
     * @param a
     * @param b
     * @return
     */
    protected Integer compareEdge(Edge a, Edge b){
        if(a.getAngle() > b.getAngle()) return 1;
        if(a.getAngle() < b.getAngle()) return -1;
        if(!a.getBegin() && b.getBegin()) return 1;
        if(a.getBegin() && !b.getBegin()) return -1;
        return 0;
    }

    /**
     *
     * @param s
     * @param p
     * @return
     */
    protected Boolean leftOf(Segment s, Point p){
        Double cross = (s.getP2().getX() - s.getP1().getX()) * (p.getY() - s.getP1().getY()) - (s.getP2().getY() - s.getP1().getY()) * (p.getX() - s.getP1().getX());
        return cross < 0;
    }

    /**
     *
     * @param p
     * @param q
     * @param f
     * @return
     */
    protected Point interpolate(Point p, Point q, Double f){
        return new Point(p.getX() * (1 - f) + q.getX() * f, p.getY() * (1 - f) + q.getY() * f);
    }


    // GETTERS / SETTERS

    public List<Segment> getSegments() {
        return segments;
    }

    public void setSegments(List<Segment> segments) {
        this.segments = segments;
    }

    public List<Edge> getEdges() {
        return edges;
    }

    public void setEdges(List<Edge> edges) {
        this.edges = edges;
    }

    public Point getViewer() {
        return viewer;
    }

    public void setViewer(Point viewer) {
        this.viewer = viewer;
    }
}
