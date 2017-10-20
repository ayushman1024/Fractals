package june;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JWindow;
import javax.swing.border.BevelBorder;
import javax.swing.JProgressBar;
import java.net.*;
import java.io.*;
import javax.swing.JTextPane;

public class Splashf extends JWindow {
private static final long serialVersionUID = 1L;
private JTextPane connect;
 public Splashf() {
	  Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
	  int width = 700;
	    int height = 480;
	    int x = (screen.width - width) / 2;
	    int y = (screen.height - height) / 2;
	    setBounds(x, y, width, height);	  
  	getContentPane().setLayout(null);
  	JLabel lblFractalArts = new JLabel("FRACTAL  ARTS");
  	lblFractalArts.setForeground(new Color(255, 255, 204));
  	lblFractalArts.setFont(new Font("Pristina", Font.PLAIN, 53));
  	lblFractalArts.setBounds(131, 48, 401, 86);
  	getContentPane().add(lblFractalArts); 
  	
  	connect = new JTextPane();
  	connect.setFont(new Font("Lucida Sans", Font.PLAIN, 16));
  	connect.setForeground(new Color(185, 150, 240));
  	connect.setBackground(new Color(0, 0, 0));
  	connect.setBounds(10, 361, 680, 108);
  	getContentPane().add(connect);
  	
try{		
	URL url_name = new URL("http://bot.whatismyipaddress.com"); 
	BufferedReader sc = new BufferedReader(new InputStreamReader(url_name.openStream()));
	String systemipaddress = sc.readLine().trim();
	InetAddress localhost = InetAddress.getLocalHost();
  	connect.setText("Connected to internet\nSystem IP Address "+(localhost.getHostAddress()).trim()+"\n\n"+"Public IP Address: " + systemipaddress );
    	}catch(Exception e){
    		connect.setText("\tYou are not connected to internet\n"+"Some features requires Internet connections.");
    		e.printStackTrace();} 	
  }
 
 //\/\/\/\/\/\/\Azmn/\/\/\/\/\/\/\///
  
  public void showSplash(int duration) {  
	    JPanel content = (JPanel) getContentPane();
	    content.setBackground(Color.black);
	    JLabel label = new JLabel(new ImageIcon("1.gif"));
	    JLabel copyrt = new JLabel("AZMN",JLabel.CENTER);
	    copyrt.setFont(new Font("Sans-Serif", Font.BOLD, 12));
	    content.add(label, BorderLayout.CENTER);
	    content.add(copyrt, BorderLayout.SOUTH);
	   // content.setBorder(BorderFactory.createLineBorder(oraRed, 10));
	    content.setBorder(BorderFactory.createSoftBevelBorder(BevelBorder.LOWERED,Color.DARK_GRAY,Color.GRAY));    
	    setVisible(true);
	    
	 	JProgressBar progressBar = new JProgressBar();
	  	progressBar.setBounds(151, 180, 379, 14);
	  	getContentPane().add(progressBar);
	  	for(int i =0;i<100;i++) 
	  	{
	  		progressBar.setStringPainted(true);
	  		progressBar.setValue(i);
	  		try {
		      Thread.sleep(duration);
		    } catch (Exception e) {}
	  	}
    setVisible(false);
  }
  
  //\/\/\/\/\/\/Azmn\/\/\/\/\/\/\/\///
  
  public static void main(String[] args) {	  
	  Splashf splash = new Splashf();
	  splash.showSplash(50);   
	  EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							Junex frame = new Junex();
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
  }
}

