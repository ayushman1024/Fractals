package june;
import java.awt.Desktop;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

public class Junex extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	/**
	 * Junex have multiple Tabs of all fractals(Treex,Juliax,Mandelbrotx,Juliax)
	 */
	/**
	 * Main Fractal Window Constructor of Junex
	 */
	public Junex() {
		try 
		{
			for(LookAndFeelInfo info: UIManager.getInstalledLookAndFeels())
			{
				if("Nimbus".equals(info.getName()))
				{
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		}catch(Exception el) {}
							
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("ToolBar.shadow"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		///Adding Tabs///
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 11, 1342, 685);
		contentPane.add(tabbedPane);
		
		Treex Treez = new Treex();    //Treez is tabbed pane for Tree
		tabbedPane.addTab("Fractal Tree", null, Treez, null);
		Treez.setBounds(50, 100, 1320, 650);
		Treez.setLayout(null);
		
		Fernx Fernz = new Fernx();
		tabbedPane.addTab("Barnsley Fern", null, Fernz, null);
		
		Mandelbrotx Mandelz = new Mandelbrotx();
		tabbedPane.addTab("Mandelbrot Set", null, Mandelz, null);
		
		Juliax Juliaz = new Juliax();
		tabbedPane.addTab("Julia Set", null, Juliaz, null);
		
		Kochx Kochz = new Kochx();
		tabbedPane.addTab("Koch curve", null, Kochz, null);
		//////
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e6) {	
				try {
					 int choice = JOptionPane.showOptionDialog(null, 
						      "Please give us feedback", 
						      "Good Bye !!", 
						      JOptionPane.YES_NO_CANCEL_OPTION, 
						      JOptionPane.QUESTION_MESSAGE, 
						      null, null, null);
						  // Online Feedback
						  if (choice == JOptionPane.YES_OPTION)
						  {
							  Desktop.getDesktop().browse(new URL("https://docs.google.com/forms/d/e/1FAIpQLScWGohxSlK6eZw-DmpK6R1WqxenV2tgx1fptma3QXCsfhWNbQ/viewform?usp=sf_link").toURI());
						  }
						  if(choice == JOptionPane.NO_OPTION)
						  {
							  JOptionPane.showMessageDialog(null, "Thank you \n Made by ...");
						  }		
						  if(choice==JOptionPane.CANCEL_OPTION)
						  {
							  JOptionPane.showMessageDialog(null, "Please Restart :(");
						  }
				} catch (MalformedURLException e) {				
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (URISyntaxException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			@Override
			public void windowClosed(WindowEvent arg0) {
						
			}
		});
		//setIconImage(Toolkit.getDefaultToolkit().getImage(Junex.class.getResource("/june/ICON.jpg")));
		setTitle("Fractal Simulator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(1, 1, 1402, 736);	
	}
}
