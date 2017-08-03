/*  
	E/13/057 - K.I.A.De Silva
	CO225 - Project 1
	Fractals
 */

import javax.swing.*;
import java.awt.*;

public class Fractal extends JPanel{

    private static int WIDTH = 800;     // set the width of the JFrame
    private static int HEIGHT = 800;    // set the height of the JFrame 

    public static String setType;       // get the type of the set

    public static double realMax,realMin,complexMax,complexMin;   
	public static int numOfIterations;
    public static double realPrt,imgPrt;


    public static void main(String args[]) throws Exception {

	
        JFrame frame = new JFrame("Fractal");  
    
        frame.setContentPane(new Fractal());
        frame.setPreferredSize(new Dimension(WIDTH, HEIGHT));

        frame.setSize(WIDTH, HEIGHT);                  // set the size of the frame
        frame.pack(); 
        frame.setVisible(true);
        frame.setResizable(false);                     // set resizable ability of the frame 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		try{
        if(args[0].equals("Mandelbrot")){       

            setType = "MandelbrotSet";

            switch (args.length){

                case 1:           // set default values
              
                    realMin = -1;
                    realMax = 1;
                    complexMin = -1;
                    complexMax = 1;
                    numOfIterations = 1000;
                    break;

                case 5:
						realMin = Double.parseDouble(args[1]);           // convert String input to double and assign to variables
						realMax = Double.parseDouble(args[2]);
						complexMin = Double.parseDouble(args[3]);
						complexMax = Double.parseDouble(args[4]);
						numOfIterations = 1000;
						break;
						
                case 6:    
					
					realMin = Double.parseDouble(args[1]);
					realMax = Double.parseDouble(args[2]);
					complexMin = Double.parseDouble(args[3]);
					complexMax = Double.parseDouble(args[4]);
					numOfIterations = Integer.parseInt(args[5]);
					break;
					

                default:
                    System.out.println("Invalid Input");
                    System.exit(0);             // terminate the program
            }

        }
        
		else if(args[0].equals("Julia")){

			setType = "JuliaSet";

            switch (args.length){

                case 1:                   // set default values
                    realPrt = -0.4;
                    imgPrt = 0.6;
                    break;

                case 3: 
					realPrt = Double.parseDouble(args[1]);
					imgPrt = Double.parseDouble(args[2]);
					break;

                default:
                    System.out.println("Invalid Input");
                    System.exit(0);                // terminate the program

            }

        }
		else{
			System.out.println("Invalid Input");
            System.exit(0);                    // terminate the program
		}
		
		}catch(Exception e){                 // catch NumberFormatException
			System.out.println(e.toString());
			System.exit(0);            
		}

    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

       if(setType == "MandelbrotSet"){

            MandelbrotSet mSet = new MandelbrotSet();   
			
			// set realMin,realMax,complexMin,complexMax values           
            mSet.setRealMin(realMin);
            mSet.setRealMax(realMax);
            mSet.setComplexMin(complexMin);
            mSet.setComplexMax(complexMax);
            mSet.setNumOfIterations(numOfIterations);
            mSet.drawMandelbrot(g);           // call drawMandelbrot method to draw it

        }
        else{

            JuliaSet jSet = new JuliaSet();
			
			// set real and complex parts of c
            jSet.setRealPrt(realPrt);
            jSet.setImgPrt(imgPrt);
            jSet.drawJulia(g);         // call drawJulia method to draw it

        }
            
    }

}