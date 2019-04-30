package tests;

import main.Edge;
import main.Segment;
import main.View;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestView {

    private View view;

    @Before
    public void setUp(){
        view = new View();
    }

    @Test
    public void loadEdgeOfMapTest(){
        view.loadEdgeOfMap(20d);

        assertEquals(4, view.getSegments().size());
    }

}
