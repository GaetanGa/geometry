package tests;

import main.Point;
import org.junit.Test;
import main.Polygon;

public class TestPolygon {

    @Test
    public void testCreatingPolygon() {
        Polygon p = new Polygon();
        p.add(new Point(1, 2));

    }
}
