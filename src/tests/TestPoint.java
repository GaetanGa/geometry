package tests;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import main.Point;

public class TestPoint {

    @Test
    public void testCreatingOriginPoint() {
        Point p = new Point();

        assertEquals(0, p.getX(), 1e-9);
        assertEquals(0, p.getY(), 1e-9);

    }

    @Test
    public void testCreatingPointFromCoordinates() {
        Point p = new Point(4.2, 5.1);

        assertEquals(4.2, p.getX(), 1e-9);
        assertEquals(5.1, p.getY(), 1e-9);
    }


}
