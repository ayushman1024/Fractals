package june;

import javax.swing.JPanel;
import java.awt.Color;

public class Juliax extends JPanel {

	private static final long serialVersionUID = 1L;
	public Juliax() {
		setBackground(new Color(0, 0, 0));
		setLayout(null);	
		Julia drawjulia = new Julia();
		drawjulia.setBounds(251, 83, 778, 495);
		add(drawjulia);
	}
}
