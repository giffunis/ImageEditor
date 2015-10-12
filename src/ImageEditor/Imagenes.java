package ImageEditor;

import java.awt.BorderLayout;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Imagenes {

	JPanel panel;
	BufferedImage imagenReal;
	ImageEditor api;
	JInternalFrame internalFrame;
	

	public Imagenes(BufferedImage imagenReal, ImageEditor api){
		this.api = api;
		this.imagenReal = imagenReal;
		init_internalFrame();
		init_panel();
		internalFrame.add(panel, BorderLayout.CENTER);	
		internalFrame.pack();
		internalFrame.setVisible(true);
		this.api.panelPrincipal.add(internalFrame);
	}
	
	void init_internalFrame(){
		//JInternalFrame.setDefaultLookAndFeelDecorated(true);
		internalFrame = new JInternalFrame("imagen1");
		internalFrame.setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);
		internalFrame.setLayout(new BorderLayout());
	}
	
	void init_panel(){
		JLabel label = new JLabel();
		label.setIcon(new ImageIcon(imagenReal));
		panel = new JPanel();
		// panel.setBorder(BorderFactory.createEmptyBorder(30,30,30,30));
		panel.add(label);
	}
}
