package june;

import java.awt.*;

import javax.swing.*;
//
public class Tree extends JPanel
{

	private static final long serialVersionUID = 1L;
	public int depth=4,stroke=1;public int tilt=90;public int angle=30,anglebalanceL,anglebalanceR;boolean gradual;
	public int count=0;
	public boolean leef=false;
	
	public Tree()
	{
		setBackground(Color.black);
	}
	
	public void ftree(Graphics2D g, int x1, int y1, double tilt, double depth) 
	{				
			g.setStroke(new BasicStroke(stroke));
			int x2 = x1 + (int) (Math.cos(Math.toRadians(tilt)) * depth* 10.0);	  
	        int y2 = y1 + (int) (Math.sin(Math.toRadians(tilt)) * depth * 10.0);
	        if (depth == 0)
	        	{
	        		g.setColor(Color.green);
	        		if(leef)
	        		g.drawOval(x2, y2, 2, 2);
	        		return;
	        	}
	        g.setColor(Color.WHITE);
	        g.drawLine(x1, y1, x2, y2);
	        
	        ftree(g, x2, y2, tilt - angle+anglebalanceL, depth - 0.5 );
	        ftree(g, x2, y2, tilt + angle-anglebalanceR, depth - 0.5);   
	        
	}
	
	public void paintComponent(Graphics g1)
	{
		Graphics2D g = (Graphics2D)g1;
		super.paintComponent(g);
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
		g.setColor(Color.WHITE);
        ftree(g, this.getWidth()/2,(int)(this.getHeight()*0.85), -tilt, depth);
	}

}
