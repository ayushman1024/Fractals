package june;

import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.JTextPane;
import java.awt.SystemColor;

public class Kochx extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Kochx() {
		setLayout(null);
		
		Koch drawkoch = new Koch();
		drawkoch.setBounds(189, 11, 1074, 678);
		add(drawkoch);
		
		JPanel kochcontrol = new JPanel();
		kochcontrol.setBounds(10, 11, 169, 678);
		add(kochcontrol);
		kochcontrol.setLayout(null);
		
		JTextPane textiter = new JTextPane();
		textiter.setBackground(SystemColor.menu);
		textiter.setText("7");
		textiter.setBounds(58, 129, 78, 20);
		kochcontrol.add(textiter);
		
		JSlider sliderkoch = new JSlider();
		sliderkoch.setMinorTickSpacing(10);
		sliderkoch.setMinimum(10);
		sliderkoch.setMaximum(70);
		sliderkoch.setValue(60);
		sliderkoch.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				drawkoch.iter=sliderkoch.getValue()/10;
				drawkoch.repaint();
				textiter.setText(Integer.toString(drawkoch.iter));
			}
		});
		sliderkoch.setOrientation(SwingConstants.VERTICAL);
		sliderkoch.setBounds(71, 160, 27, 303);
		kochcontrol.add(sliderkoch);
		
		JLabel lblKochSnowflakeCurve = new JLabel("Koch Snowflake Curve");
		lblKochSnowflakeCurve.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblKochSnowflakeCurve.setBounds(10, 24, 159, 37);
		kochcontrol.add(lblKochSnowflakeCurve);
		
		

	}
}
