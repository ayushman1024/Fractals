package june;

import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.Color;
import javax.swing.JRadioButton;

public class Treex extends JPanel {

	/**
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public Treex() {
		
		setLayout(null);	
		JPanel TreeControl = new JPanel();
		TreeControl.setBounds(10, 11, 118, 693);
		add(TreeControl);
		
		Tree TreeDraw = new Tree();
		TreeDraw.setBounds(130, 11, 1202, 693);
		add(TreeDraw);

		//////
		JSlider sliderdepth = new JSlider();
		sliderdepth.setOrientation(SwingConstants.VERTICAL);
		sliderdepth.setBackground(UIManager.getColor("Button.shadow"));
		sliderdepth.setMaximum(200);
		sliderdepth.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e1) {
				int choicedepth = sliderdepth.getValue()/10;
				TreeDraw.depth=choicedepth;
				TreeDraw.repaint();
			}
		});
		sliderdepth.setBounds(62, 150, 16, 90);
		TreeControl.add(sliderdepth);
		
		JSlider slidertilt = new JSlider();
		slidertilt.setOrientation(SwingConstants.VERTICAL);
		slidertilt.setBackground(UIManager.getColor("Button.shadow"));
		slidertilt.setBounds(62, 251, 16, 90);
		slidertilt.setValue(50);
		slidertilt.setMinimum(-180);
		slidertilt.setMaximum(180);
		slidertilt.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e2) {
				
				int choicetilt = slidertilt.getValue()/5;
				TreeDraw.tilt = 90-choicetilt;
				TreeDraw.repaint();	        
			}
		});
		TreeControl.setLayout(null);
		TreeControl.add(slidertilt);
		
		JLabel lblDepth = new JLabel("DEPTH");
		lblDepth.setBounds(52, 124, 46, 14);
		TreeControl.add(lblDepth);
		
		JLabel lblFractalSimulator = new JLabel("Fractal");
		lblFractalSimulator.setBounds(12, 39, 86, 33);
		TreeControl.add(lblFractalSimulator);
		lblFractalSimulator.setFont(new Font("Tempus Sans ITC", Font.BOLD | Font.ITALIC, 18));
		lblFractalSimulator.setForeground(UIManager.getColor("Button.foreground"));
		JLabel lblTilt = new JLabel("TILT");
		lblTilt.setBounds(62, 352, 34, 14);
		TreeControl.add(lblTilt);
		
		JButton btncapture = new JButton("Capture");
		btncapture.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e3) {
				 BufferedImage image = new BufferedImage(TreeDraw.getWidth(), TreeDraw.getHeight(), BufferedImage.TYPE_INT_RGB);
                 Graphics2D g = image.createGraphics();
                 TreeDraw.printAll(g);
                 g.dispose();
                 try {
                	 String locPic="D:\\FractalWallpaper\\"+"fractal_Tree.jpg";
                     ImageIO.write(image, "jpg", new File(locPic));
                     JOptionPane.showMessageDialog(null, "fractal_Tree.jpg is saved in your D:\\FractalWallpaper\\");
                     new Screensaver();
                 } catch (IOException exp) {
                     exp.printStackTrace();
                 }
			}
		});
		btncapture.setBounds(12, 570, 86, 26);
		TreeControl.add(btncapture);
		
		JSlider slideranglebalance = new JSlider();
		slideranglebalance.setBackground(UIManager.getColor("Button.shadow"));
		slideranglebalance.setMajorTickSpacing(1);
		slideranglebalance.setValue(5);
		slideranglebalance.setMaximum(150);
		slideranglebalance.setMinimum(-150);
		slideranglebalance.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e4) {
				TreeDraw.angle = slideranglebalance.getValue();
				TreeDraw.repaint();
			}
		});
		slideranglebalance.setOrientation(SwingConstants.VERTICAL);
		slideranglebalance.setBounds(12, 251, 16, 90);
		TreeControl.add(slideranglebalance);
		
		JSlider sliderangleLR = new JSlider();
		sliderangleLR.setBackground(UIManager.getColor("Button.shadow"));
		sliderangleLR.setMaximum(75);
		sliderangleLR.setMinimum(-75);
		sliderangleLR.setMinorTickSpacing(1);
		sliderangleLR.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e5) {
				TreeDraw.anglebalanceR = 20+sliderangleLR.getValue();
				TreeDraw.anglebalanceL = 20-sliderangleLR.getValue();
				TreeDraw.repaint();
			}
		});
		sliderangleLR.setOrientation(SwingConstants.VERTICAL);
		sliderangleLR.setBounds(12, 150, 16, 90);
		TreeControl.add(sliderangleLR);		
		
		JLabel lblNewLabel = new JLabel("ANGLE");
		lblNewLabel.setBounds(10, 351, 46, 16);
		TreeControl.add(lblNewLabel);
		
		JLabel lblLr = new JLabel("L/R");
		lblLr.setBounds(12, 123, 26, 16);
		TreeControl.add(lblLr);
		
		JSpinner spinnerstroke = new JSpinner();
		spinnerstroke.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e6) {
				Object o = spinnerstroke.getValue();
				Integer n = (Integer) o;
				TreeDraw.stroke = n.intValue();
				TreeDraw.repaint();
			}
		});
		spinnerstroke.setModel(new SpinnerNumberModel(1, 1, 8, 1));
		spinnerstroke.setBounds(12, 377, 66, 20);
		TreeControl.add(spinnerstroke);
		
		JLabel lblFractalimgjpg = new JLabel("fractalIMG.jpg");
		lblFractalimgjpg.setFont(new Font("Dialog", Font.ITALIC, 10));
		lblFractalimgjpg.setBounds(12, 607, 94, 16);
		TreeControl.add(lblFractalimgjpg);
		
		JLabel lblTree = new JLabel("Tree");
		lblTree.setForeground(Color.BLACK);
		lblTree.setFont(new Font("Tempus Sans ITC", Font.BOLD | Font.ITALIC, 18));
		lblTree.setBounds(12, 72, 86, 26);
		TreeControl.add(lblTree);
		
		JRadioButton btnleef = new JRadioButton("Leafs");
		btnleef.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TreeDraw.leef= btnleef.isSelected();
				TreeDraw.repaint();
				
			}
		});
		btnleef.setBounds(6, 417, 109, 23);
		TreeControl.add(btnleef);
	
		//////
		
	}
}
