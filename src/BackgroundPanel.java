import java.awt.Graphics;
import java.awt.LayoutManager;

import javax.swing.ImageIcon;
import javax.swing.JPanel;


@SuppressWarnings("serial")
public class BackgroundPanel extends JPanel {

	public BackgroundPanel(LayoutManager mngr) {
		super(mngr);
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		//ImageIcon background = new ImageIcon("./figures/ui_new.png");
		ImageIcon background = new ImageIcon("./figures/ui.png");
	    g.drawImage(background.getImage(), 0, 0, this);
	}
	
	/*public void paint(Graphics g) {
		super.paint(g);
		ImageIcon background = new ImageIcon("./figures/ui_new.png");
	    g.drawImage(background.getImage(), 0, 0, null);
	}*/
	
	/*public void repaint() {
		super.repaint();
		ImageIcon background = new ImageIcon("./figures/ui_new.png");
		this.getGraphics().drawImage(background.getImage(), 0, 25, null);
	}*/
}
