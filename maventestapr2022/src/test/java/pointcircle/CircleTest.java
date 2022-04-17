package pointcircle;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CircleTest {


    @Test
    void shouldGetResultTrue() {

        Circle circle = new Circle();
        circle.circle(10, 15);

        int resultTrue = circle.result();

        assertEquals(1, resultTrue);
    }


    @Test
    void shouldGetResultFalse() {

        Circle circle2 = new Circle();
        circle2.circle(12, 9);

        int resultFalse = circle2.result();

        assertEquals(0, resultFalse);
    }
}

