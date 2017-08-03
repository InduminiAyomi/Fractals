import java.awt.*;

public class MandelbrotSet {


    private int numOfIterations;
    private static double realMin,realMax,complexMin,complexMax;

	// default constructor
    public MandelbrotSet(){
    }

    public void setRealMin(double realMin) {
        this.realMin = realMin;                            // set realMin value
    }

    public void setNumOfIterations(int numOfIterations) {
        this.numOfIterations = numOfIterations;            // set numOfIterations
    }

    public void setRealMax(double realMax) {  
        this.realMax = realMax;                            // set realMax value
    }

    public void setComplexMin(double complexMin) {
        this.complexMin = complexMin;                      // set complexMin value
    }

    public void setComplexMax(double complexMax) {
        this.complexMax = complexMax;                      // set complexMax value
    }


	// draw Mandelbrot Set
    public void drawMandelbrot(Graphics g) {

        for(int yPoint=0; yPoint<= 800; yPoint++){            // increment y points
            for(int xPoint=0; xPoint<= 800; xPoint++){        // increment x points

				// get real and complex values of c for different x,y points
                double c_realPart = this.realMin + (this.realMax-this.realMin)*xPoint/800;    
                double c_complexPart = this.complexMax - (this.complexMax-this.complexMin)*yPoint/800;

                int count=0;
                double Zn_real=0,Zn_complex=0;

                double square = 0;

                while ( count < this.numOfIterations) {      // go until numOfIterations greater than count

                    if(square > 4) break;                    // if square root of Zn if greater than 4

                    double Zn = Math.pow(Zn_real,2)-Math.pow(Zn_complex,2) + c_realPart;   // get real part of Zn+1
                    Zn_complex = 2*Zn_real*Zn_complex + c_complexPart;                     // get complex part of Zn+1
                    Zn_real = Zn;

                    count++;            // count number of iterations

                    square = Math.sqrt(Math.pow(Zn_real,2) + Math.pow(Zn_complex,2));   // get square root of Zn

                }

                ColorSet c = new ColorSet(count);          // give iteration count to the set color
                c.setColor();                              // set color of the point according to the num of iterations

                DrawPoint d = new DrawPoint(yPoint,xPoint);  // give x,y points to draw
                d.draw(g);                                   //  call draw method by giving Graphics 

            }
        }
    }

}
