package june;

import java.awt.BasicStroke;
import java.awt.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JPanel;
public class Koch extends JPanel {
	
	private static final long serialVersionUID = 1L;
	public int iter=6;
	
	public void kochcurve(Graphics2D gk,int d,int l,int r) 
	{
		int l3,l2,t;
		int cl=l,countl=l,cr=r,countr=r;
		l3=d/3;
		l2=d/2;
		t= (int) ((d/3)*Math.sin(Math.PI/3));
		if(l!=1)
		{		
		//gk.drawLine(0,0,l3,0);gk.drawLine(2*l3,0,d,0);
		gk.drawLine(l3,0,l2,-t);
		gk.drawLine(l2,-t,2*l3,0);
		
		/*erase middle*/
		gk.setColor(Color.BLACK);
			gk.drawLine(l3,0,2*l3,0);
		gk.setColor(Color.WHITE);
		}
		
		if(cl!=1) 
		{
			kochcurve(gk,l3,--cl,cr);       //		1
		}
		if(countl!=1)
		{
			gk.translate(l3,0);
			gk.rotate(-Math.PI/3);
			kochcurve(gk,l3,--countl,countr);   	//		2
			gk.rotate(Math.PI/3);
			gk.translate(-l3, 0);
		}

		if(countr!=1)
		{
			gk.translate(l2,-t);
			gk.rotate(Math.PI/3);
			kochcurve(gk,l3,countl,--countr);		//		3
			gk.rotate(-Math.PI/3);
			gk.translate(-l2,t);	
		  }	
		if(cr!=1)
		{
			gk.translate(2*l3, 0);
			kochcurve(gk,l3,cl,--cr);		//		4	
			gk.translate(-2*l3, 0);
		}				  
	}
	
	public void paintComponent(Graphics gkc)
	{
		Graphics2D gt = (Graphics2D)gkc;
		super.paintComponent(gt);
		gt.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
		gt.setColor(Color.WHITE);
		gt.translate(0,500);
		//gt.setStroke(new BasicStroke(0.4f));
		gt.drawLine(0, 0, 1000, 0);
		kochcurve(gt,1000,iter,iter);
		
	}
	public Koch() {
		setBackground(Color.BLACK);	
		setBounds(130, 11, 1069, 693);	
	}
}
