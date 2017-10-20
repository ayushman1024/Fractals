package june;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JFileChooser;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Color;

public class Screensaver extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public String loc;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Screensaver frame = new Screensaver();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	JMenuItem open=new JMenuItem("Open File"); 
	private JTextField textloc;

	/* Create the frame.
	 */
	public Screensaver() {
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(211, 211, 211));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textloc = new JTextField();
		textloc.setBackground(new Color(255, 248, 220));
		textloc.setBounds(20, 405, 449, 35);
		contentPane.add(textloc);
		textloc.setColumns(10);
		
		JFileChooser fc = new JFileChooser("D:\\FractalWallpaper\\");
		fc.setApproveButtonToolTipText("Click here to make selected file wallpaper");
		fc.setAcceptAllFileFilterUsed(false);
		fc.setApproveButtonText("Set Wallpaper");
		fc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			   
				   int i=JFileChooser.APPROVE_OPTION;
				   if(i==JFileChooser.APPROVE_OPTION){      
				        try
				        {    					          
					        File file = fc.getSelectedFile();
					        loc =file.getPath();
					        textloc.setText(loc);	
					        new Wallpaper(textloc.getText());
							JOptionPane.showMessageDialog(null, "WallPaper Changed");
				        }
				        catch (Exception ex) {ex.printStackTrace();  }                 
				    }    				   
			}
		});
		fc.setBounds(10, 11, 637, 397);
		contentPane.add(fc);
		
		JLabel lblNewLabel_1 = new JLabel("File Selected To Make Wallpaper");
		lblNewLabel_1.setBounds(20, 446, 218, 19);
		contentPane.add(lblNewLabel_1);
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 734, 515);
	}
}
