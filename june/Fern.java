package june;

import javax.swing.JPanel;
import java.awt.*;
public class Fern extends JPanel {
	public int dim = 640;
	public int cgreen=150;
	public int iter=10000;
	static final long serialVersionUID = 1L;
    public Fern() {   	
        setBackground(Color.white);
    }
    void createFern(int w, int h,Graphics2D g) {
        double x = 0;
        double y = 0;
        for (int i = 0; i < iter; i++) {
            double tmpx, tmpy;
            double r = Math.random();

            if (r <= 0.01) {
                tmpx = 0;
                tmpy = 0.16 * y;
            } else if (r <= 0.08) {
                tmpx = 0.2 * x - 0.26 * y;
                tmpy = 0.23 * x + 0.22 * y + 1.6;
            } else if (r <= 0.15) {
                tmpx = -0.15 * x + 0.28 * y;
                tmpy = 0.26 * x + 0.24 * y + 0.44;
            } else {
                tmpx = 0.85 * x + 0.04 * y;
                tmpy = -0.04 * x + 0.85 * y + 1.6;
            }
            x = tmpx;
            y = tmpy;
            g.setColor(new Color(5,(cgreen)%255,20));
            g.drawLine((int) Math.round(w / 2 + x * w / 11),  (int) Math.round(h - y * h / 11),(int) Math.round(w / 2 + x * w / 11),  (int) Math.round(h - y * h / 11));       
        }
    }
    @Override
    public void paintComponent(Graphics gg) {
        super.paintComponent(gg);
        Graphics2D g = (Graphics2D) gg;
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        createFern(dim,dim,g);
    }
}