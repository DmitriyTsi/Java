package pointcircle;

public class Point {

    int x;
    int y;
    int xc;
    int yc;
    int distanse;


    void point(int x, int y) {
        this.x = x;
        this.y = y;
    }


    int pointDiatance(int x, int y, int xc, int yc) {
        this.x = x;
        this.y = y;
        this.xc = xc;
        this.yc = yc;

        distanse = (int) Math.sqrt(Math.pow(xc - x, 2) +Math.pow(xc - y, 2));
        return distanse;
    }
}