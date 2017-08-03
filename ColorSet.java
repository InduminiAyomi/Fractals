import java.awt.*;

public class ColorSet {

    private int count;
    protected static Color color;    

    public void setColor() {     // set color for each point according to the iteration count

       if(count < 5)  this.color = new Color(0,0,0);
        else if(count < 8)  this.color = new Color(21,20,23);
        else if(count < 10)  this.color = new Color(28,26,36);
        else if(count < 15)  this.color = new Color(39,36,44);
        else if(count < 20)  this.color = new Color(57,49,68);
        else if(count < 30)  this.color = new Color(55,31,87);
        else if(count < 50)  this.color = new Color(20,247,12);
        else if(count < 100)  this.color = new Color(12,23,87);
        else if(count < 150)  this.color = new Color(36,62,232);
        else if(count < 180)  this.color = new Color(36,232,172);
        else if(count < 200)  this.color = new Color(29,119,47);
        else if(count < 230)  this.color = new Color(97,16,91);
        else if(count < 260)  this.color = new Color(237,172,229);
        else if(count < 300)  this.color = new Color(255,255,26);
        else if(count < 350)  this.color = new Color(255,163,1);
        else if(count < 400)  this.color = new Color(255,82,8);
        else if(count < 500)  this.color = new Color(154,56,18);
        else if(count < 600)  this.color = new Color(252,42,8);
        else if(count < 700)  this.color = new Color(239,114,114);
        else if(count < 800)  this.color = new Color(30,30,7);
        else if(count < 900)  this.color = new Color(36,232,172);
        else   this.color = new Color(20,247,12);



    }

    public ColorSet(int count) {     // get number of iterations via constructor
        this.count = count;
    }

    public ColorSet(){}        // default constructor

}
