package DesignPatterns.bridge;

/**
 * @author: lingjun.jlj
 * @Date: 2018/7/19 11:00
 * @Description:
 */
public class RedCircle implements DrawAPI {

    @Override
    public void drawCircle(int radius, int x, int y) {
        System.out.println("Draw Circle [ color : red , radius :"
                + radius + ",x: " + x + " , y: " + y + " ]");
    }
}
