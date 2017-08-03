import java.awt.*;
import java.awt.geom.Line2D;

public class DrawPoint extends ColorSet{ 

    private int pointX,pointY;

    public DrawPoint(int pointY, int pointX) {      // get x,y points
        this.pointX = pointX;
        this.pointY = pointY;
    }

    public void draw(Graphics g) {

        Graphics2D g2 = (Graphics2D) g;       // cast Graphics to Graphics2D
        g2.setColor(this.color);              // set color of the point
        g2.draw(new Line2D.Double(pointX, pointY, pointX, pointY));       // draw point using Line2D

    }

}
