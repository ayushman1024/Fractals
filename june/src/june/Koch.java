package june;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

public class Koch extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	
	public void kochcurve(Graphics2D gk,int d,int countl,int countr) 
	{
		int l3,l2,t;
		int cl=countl,cr=countr;
		l3=d/3;l2=d/2;t= (int) Math.round((d/3)*Math.sin(Math.PI/3));
		gk.drawLine(0,0,l3,0);gk.drawLine(2*l3,0,d,0);
		gk.drawLine(l3,0,l2,-t);
		gk.drawLine(l2,-t,2*l3,0);
		
		/*erase*/
		gk.setColor(Color.BLACK);
		gk.drawLine(l3,0,2*l3,0);
		gk.setColor(Color.WHITE);
		if(cl!=0)
			kochcurve(gk,l3,--cl,--cr);
		if(cr!=0)
		{
			gk.translate(2*l3, 0);
			kochcurve(gk,l3,--cl,--cr);
			gk.translate(-2*l3, 0);
		}
			
		if(countl!=0)
		{
			//
			gk.translate(l3,0);
			gk.rotate(-Math.PI/3);
			kochcurve(gk,l3,--countl,--countr);
			gk.rotate(Math.PI/3);
			gk.translate(-l3, 0);
		}
		
		if(countr!=0)
		{
			gk.translate(l2,-t);
			gk.rotate(Math.PI/3);
			kochcurve(gk,l3,--countl,--countr);
			gk.rotate(-Math.PI/3);
			gk.translate(-l2,t);
		
		  }	
		  
	}
	
	public void paintComponent(Graphics gkc)
	{
		Graphics2D gt = (Graphics2D)gkc;
		super.paintComponent(gt);
		gt.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
		gt.setColor(Color.WHITE);
		gt.translate(0,500);
		kochcurve(gt,800,8,8);
		
	}
	public Koch() {
		setBackground(Color.BLACK);	
		setBounds(130, 11, 1169, 693);	
	}
}
