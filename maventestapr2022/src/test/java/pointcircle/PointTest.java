package pointcircle;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class PointTest {

    @Test
    void shouldGetPointDiatance() {


        Point point = new Point();

        int  pointDiatance = point.pointDiatance(10, 10, 15, 15);

        assertEquals(7, pointDiatance);

    }



}