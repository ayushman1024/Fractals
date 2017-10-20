package june;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.swing.JSlider;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;

public class Fernx extends JPanel {

	private static final long serialVersionUID = 1L;
	public Fernx() {
		setLayout(null);
		
		Fern drawfern = new Fern();
		drawfern.setBounds(225, 11, 906, 662);
		add(drawfern);
		
		JPanel controlfern = new JPanel();
		controlfern.setBounds(10, 11, 216, 662);
		add(controlfern);
		controlfern.setLayout(null);
		
		JSlider slidergreen = new JSlider();
		slidergreen.setValue(150);
		slidergreen.setMaximum(254);
		slidergreen.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent eg) {
				drawfern.cgreen=slidergreen.getValue();
				drawfern.repaint();
			}
		});
		slidergreen.setBounds(10, 492, 185, 26);
		controlfern.add(slidergreen);
		JButton btncaptureM = new JButton("CAPTURE");
		btncaptureM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ec) {
				BufferedImage image = new BufferedImage(drawfern.getWidth(), drawfern.getHeight(), BufferedImage.TYPE_INT_RGB);
                Graphics2D g = image.createGraphics();
                drawfern.printAll(g);
                g.dispose();
                try {
                    ImageIO.write(image, "jpg", new File("Barnsley Fern"+Math.round(1000*Math.random())+".jpg"));                    
                    JOptionPane.showMessageDialog(null, "Barnsley Fern.jpg is saved in your File System");
                } catch (IOException exp) {
                    exp.printStackTrace();
                }
			}
		});
		btncaptureM.setBounds(57, 583, 89, 23);
		controlfern.add(btncaptureM);
		
		JLabel lblGreen = new JLabel("Green");
		lblGreen.setBounds(10, 517, 46, 23);
		controlfern.add(lblGreen);
		
		JLabel lblSize = new JLabel("Size");
		lblSize.setBounds(10, 458, 46, 23);
		controlfern.add(lblSize);
		
		JSlider slidersize = new JSlider();
		slidersize.setValue(64);
		slidersize.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent esx) {
				drawfern.dim = 10*slidersize.getValue();
				drawfern.repaint();
			}
		});
		slidersize.setBounds(10, 432, 185, 26);
		controlfern.add(slidersize);
		
		JLabel lblBarnsleyFern = new JLabel("Barnsley Fern");
		lblBarnsleyFern.setForeground(new Color(0, 0, 0));
		lblBarnsleyFern.setFont(new Font("Tempus Sans ITC", Font.ITALIC, 22));
		lblBarnsleyFern.setBounds(10, 11, 185, 79);
		controlfern.add(lblBarnsleyFern);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 101, 205, 2);
		controlfern.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(205, 0, 2, 662);
		controlfern.add(separator_1);
		separator_1.setOrientation(SwingConstants.VERTICAL);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(0, 570, 205, 2);
		controlfern.add(separator_2);
		
		JTextPane textiter = new JTextPane();
		textiter.setText("50000");
		textiter.setBounds(96, 317, 80, 23);
		controlfern.add(textiter);
		
		JSlider iterslider = new JSlider();
		iterslider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				drawfern.iter = 2000*iterslider.getValue();
				textiter.setText(Integer.toString(2000*iterslider.getValue()));
				drawfern.repaint();
			}
		});
		iterslider.setValue(25);
		iterslider.setMinimum(10);
		iterslider.setMaximum(100);
		iterslider.setBounds(0, 280, 185, 26);
		controlfern.add(iterslider);
		
		JLabel lblNewLabel = new JLabel("Iterations :");
		lblNewLabel.setBounds(10, 314, 80, 26);
		controlfern.add(lblNewLabel);

	}
}
