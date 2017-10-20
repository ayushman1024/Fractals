package june;
import java.awt.*;

import javax.swing.JPanel;

public class Mandelbrot extends JPanel {

	private static final long serialVersionUID = 1L;
	public int max=800;
	public int moveX=0,moveY=0,zoom=1;
	boolean trigger=true;
	public int colorx=5;

    public void paintComponent(Graphics g3) {
    	Graphics2D g4 = (Graphics2D) g3;
    	super.paintComponent(g4);
    	int width = this.getWidth(), height =this.getHeight();
    	g4.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        if(trigger)
        {
        for (int row = 0; row < height; row++) 
        {
            for (int col = 0; col < width; col++)
            {
            	
                double c_re = ((col+moveX) - width/2)*4.0/(width*zoom);
                double c_im = ((row+moveY) - height/2)*4.0/(width*zoom);
                double x = 0, y = 0;
                int iterations = 0;
                while (x*x+y*y < 4 && iterations < max)
                {
                    double x_new = x*x-y*y+c_re;
                    y = 2*x*y+c_im;
                    x = x_new;
                    iterations++;
                } 
                if (iterations < max) 
                {
                	int ri =(int)(float) x,gi=(int)(float)y, bi =(int)(float) iterations;
                	ri=Math.abs((ri+(bi-colorx)*bi)%255);
                	gi=Math.abs((gi+colorx*bi)%255);
                	bi=Math.abs((bi+colorx)%255);
                	Color c =  new Color(ri,gi,bi);
                	g4.setColor(c); 
                	g4.drawLine(col,row,col,row) ;
                }
                else 
                { 
                	g4.setColor(Color.black);            	
                	g4.drawLine(col,row,col,row) ;
                };
            }
        }
        }
    
    }
  
	public Mandelbrot() 
	{
		setBackground(Color.BLACK);
	}

}


