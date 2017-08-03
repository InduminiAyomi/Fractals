import java.awt.*;

public class JuliaSet {

	// set realMin,realMax,complexMin,complexMax and numOfIterations
	// these values are same for any julia set
    private int numOfIterations = 1000;
    protected static double realMin = -1,realMax = 1,complexMin = -1,complexMax = 1;

    private double realPrt, imgPrt;

    public JuliaSet() {
    }

    public void setRealPrt(double realPrt) {
        this.realPrt = realPrt;                    // set real part of the c
    }

    public void setImgPrt(double imgPrt) {
        this.imgPrt = imgPrt;                       // set imaginary part of the c
    }


    public void drawJulia (Graphics g) {

        for(int yPoint=0; yPoint<=800; yPoint++){                // increment y points
            for(int xPoint=0; xPoint<=800; xPoint++){            // increment x points

				// get real and complex values of Zn for different x,y points
				double Zn_real = this.realMin + (this.realMax-this.realMin)*xPoint/800;
                double Zn_complex = this.complexMax - (this.complexMax-this.complexMin)*yPoint/800;

                double x = Math.pow(Zn_real,2) -  Math.pow(Zn_complex,2);    // real part of the square of Zn
                double y = 2*Zn_real*Zn_complex;                             // complex part of the square of Zn

                double square = Math.sqrt(Math.pow(x,2)+Math.pow(y,2));       //  square root of Zn

                int count=0;

                while (count < this.numOfIterations){       // go until numOfIterations greater than count

                    if( square>4)  break;                   // if square root of Zn if greater than 4

                    double Zn = Math.pow(Zn_real,2) - Math.pow(Zn_complex,2) + realPrt;     // get real part of Zn+1
                    Zn_complex = 2*Zn_real*Zn_complex + imgPrt;                             // get complex part of Zn+1
					Zn_real = Zn;

                    count++;                                 // count number of iterations
                    square = Math.sqrt(Math.pow(Zn_real,2)+ Math.pow(Zn_complex,2));        // get square root of Zn

                }

                ColorSet c = new ColorSet(count);          // give iteration count to the set color
                c.setColor();                              // set color of the point according to the num of iterations

                DrawPoint d = new DrawPoint(yPoint,xPoint);  // give x,y points to draw
                d.draw(g);                                   //  call draw method by giving Graphics 

            }
        }
    }
}
