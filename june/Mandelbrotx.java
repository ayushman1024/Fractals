package june;

import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Mandelbrotx extends JPanel {
	/** 
	 */
	public JSlider sliderX,sliderY,mslider;
	private static final long serialVersionUID = 1L;
	public String wall;JButton btnWallpaper;
	/**
	 * 
	 */
	public Mandelbrotx() {
		setLayout(null);
		
		JPanel mandelcontrol = new JPanel();
		mandelcontrol.setBounds(0, 11, 120, 654);
		add(mandelcontrol);		
		mandelcontrol.setLayout(null);
		
		Mandelbrot mandeldraw = new Mandelbrot();
		mandeldraw.addKeyListener(new KeyAdapter() {
			@Override
				public void keyPressed(KeyEvent ep) {
				    int key = ep.getKeyCode();
				    System.out.println(key);
				    switch( key ) { 
				        case KeyEvent.VK_UP:
				            mandeldraw.moveY+=100;mandeldraw.repaint();
				            break;
				        case KeyEvent.VK_DOWN:
				            mandeldraw.moveY-=100;mandeldraw.repaint();
				            break;
				        case KeyEvent.VK_LEFT:
				            mandeldraw.moveX-=100;mandeldraw.repaint();
				            break;
				        case KeyEvent.VK_RIGHT :
				            mandeldraw.moveX+=100;mandeldraw.repaint();
				            break;
				     }
				} 		
			
		});
		mandeldraw.addMouseWheelListener(new MouseWheelListener() {
			public void mouseWheelMoved(MouseWheelEvent ewheel) {
				mslider.setValue(10);
				mandeldraw.zoom = mandeldraw.zoom-ewheel.getWheelRotation();
				mandeldraw.repaint();				
			}
		});
		mandeldraw.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent edrag) {
				sliderX.setValue(-edrag.getX());
				sliderY.setValue(+edrag.getY());		
			}
		});
		mandeldraw.setBounds(130, 11, 1202, 654);
		mandeldraw.setFocusable(true);
		add(mandeldraw);  
		
		mslider = new JSlider();
		mslider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent ex) {
				mandeldraw.max = mslider.getValue()*10;	
			}
		});
		mslider.setOrientation(SwingConstants.VERTICAL);
		mslider.setBounds(79, 46, 20, 101);
		mandelcontrol.add(mslider);
		
		JButton btnDraw = new JButton("Draw|Re-Paint");
		btnDraw.setHorizontalAlignment(SwingConstants.LEADING);
		btnDraw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ey) {
				mandeldraw.trigger=true;
				mandeldraw.repaint();
			}
		});
		btnDraw.setBounds(0, 0, 120, 46);
		mandelcontrol.add(btnDraw);
		
		sliderX = new JSlider();
		sliderX.setValue(0);
		sliderX.setMinorTickSpacing(100);
		sliderX.setMinimum(-10000);
		sliderX.setMaximum(10000);
		sliderX.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent exx) {
				mandeldraw.moveX =sliderX.getValue();
				mandeldraw.repaint();
			}
		});
		sliderX.setBounds(0, 270, 120, 26);
		mandelcontrol.add(sliderX);
		
		sliderY = new JSlider();
		sliderY.setValue(0);
		sliderY.setMinimum(-10000);
		sliderY.setMaximum(10000);
		sliderY.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent eyy) {
				mandeldraw.moveY = - sliderY.getValue();
				mandeldraw.repaint();
			}
		});
		sliderY.setOrientation(SwingConstants.VERTICAL);
		sliderY.setBounds(0, 307, 26, 135);
		mandelcontrol.add(sliderY);
		
		JLabel lblX = new JLabel("X-axis");
		lblX.setBounds(10, 242, 56, 22);
		mandelcontrol.add(lblX);
		
		JLabel lblNewLabel = new JLabel("Y-axis");
		lblNewLabel.setLabelFor(sliderY);
		lblNewLabel.setBounds(46, 321, 53, 23);
		mandelcontrol.add(lblNewLabel);
		
		JSlider sliderzoom = new JSlider();
		sliderzoom.setMaximum(30);
		sliderzoom.setMinimum(1);
		sliderzoom.setValue(1);
		sliderzoom.setMinorTickSpacing(1);
		sliderzoom.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent ezm) {
				mandeldraw.zoom=sliderzoom.getValue();
				
				mslider.setValue(10);
				mandeldraw.repaint();
			}
		});
		sliderzoom.setBounds(10, 166, 89, 26);
		mandelcontrol.add(sliderzoom);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 0, 110, 2);
		mandelcontrol.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(0, 242, 110, 2);
		mandelcontrol.add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(0, 153, 110, 2);
		mandelcontrol.add(separator_2);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(0, 453, 110, 2);
		mandelcontrol.add(separator_3);
		
		JLabel lblIterations = new JLabel("Iterations");
		lblIterations.setBounds(13, 86, 56, 14);
		mandelcontrol.add(lblIterations);
		
		JLabel lblZoom = new JLabel("ZOOM");
		lblZoom.setBounds(31, 187, 79, 23);
		mandelcontrol.add(lblZoom);
		
		JLabel lblMove = new JLabel("MOVE");
		lblMove.setBounds(43, 355, 56, 14);
		mandelcontrol.add(lblMove);
		
		JLabel lblAlongAxis = new JLabel("Along Axis");
		lblAlongAxis.setBounds(43, 367, 77, 14);
		mandelcontrol.add(lblAlongAxis);
		
		JButton btncaptureM = new JButton("CAPTURE");
		btncaptureM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ec) {
				BufferedImage image = new BufferedImage(mandeldraw.getWidth(), mandeldraw.getHeight(), BufferedImage.TYPE_INT_RGB);
                Graphics2D g = image.createGraphics();
                mandeldraw.printAll(g);
                g.dispose();
                try {
                	wall="D:\\FractalWallpaper\\"+"fractal_Mandelbrot"+Math.round(1000*Math.random())+".jpg";
                    ImageIO.write(image, "jpg", new File(wall));                    
                    try {
                   int choice= JOptionPane.showOptionDialog(null, "Image Saved in Folder D:\\FractalWallpaper \n Want to make it your Wallpaper","Captured",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,null,null,null);
                   if(choice==JOptionPane.YES_OPTION) { new Screensaver(); }
                    }catch(Exception e) {}
                    btnWallpaper.setEnabled(true);
                } catch (IOException exp) {
                    exp.printStackTrace();
                }
			}
		});
		btncaptureM.setBounds(10, 526, 89, 23);
		mandelcontrol.add(btncaptureM);
		
		JSlider slidercolor = new JSlider();
		slidercolor.setValue(5);
		slidercolor.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent ed) {
				mandeldraw.colorx= 1+ slidercolor.getValue();
				mandeldraw.repaint();
			}
		});
		slidercolor.setBounds(0, 466, 110, 26);
		mandelcontrol.add(slidercolor);
		JLabel lblColour = new JLabel("Colour");
		lblColour.setBounds(44, 488, 66, 27);
		mandelcontrol.add(lblColour);
		
		btnWallpaper = new JButton("Wallpaper");
		btnWallpaper.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Wallpaper(wall);
			}
		});
		btnWallpaper.setBounds(10, 570, 89, 23);
		btnWallpaper.setEnabled(false);
		mandelcontrol.add(btnWallpaper);
		
	}
}
