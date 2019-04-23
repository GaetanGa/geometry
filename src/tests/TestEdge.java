package tests;

import main.Edge;
import main.Point;
import org.junit.Test;

public class TestEdge {

    @Test
    public void testCreatingEdge() {
        Edge e = new Edge(new Point(1, 1), new Point(10,20));

        //accès aux coordonnées des extrémités
        //intersection avec un rayon
    }
}
