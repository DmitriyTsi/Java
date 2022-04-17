package pointcircle;

public class Circle {

    int r;
    int distanse;


    void circle (int distanse, int r) {
        this.r = r;
        this.distanse = distanse;
    }


    int result () {
        int result = 0;
        if (distanse <= r) result = 1;
        return result;
    }
}
