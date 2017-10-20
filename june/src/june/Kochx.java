package june;

import javax.swing.JPanel;

public class Kochx extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Kochx() {
		setLayout(null);
		
		Koch panel = new Koch();
		panel.setBounds(128, 11, 862, 678);
		add(panel);

	}
}
