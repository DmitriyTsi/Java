package pointcircle;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class PointTest {


    // Каждый тест делится на 3 операции when
    //when начальные данные (исходные условия)
    //given: осуществление самой операции
    //then: сама проверка

    @Test
    void shouldGetPointDiatance() {


        Point point = new Point();

        int  pointDiatance = point.pointDiatance(10, 10, 15, 15);

        assertEquals(7, pointDiatance);

    }



}