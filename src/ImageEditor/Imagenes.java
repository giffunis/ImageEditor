package ImageEditor;

import java.awt.BorderLayout;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Imagenes {
	JFrame marco;
	JPanel panel;
	BufferedImage imagenReal;
	
	public Imagenes(BufferedImage imagenReal){
		this.imagenReal = imagenReal;
		init_marco();
		init_panel();
		marco.add(panel, BorderLayout.CENTER);	
		marco.pack();
		marco.setVisible(true);
	}
	
	void init_marco(){
		JFrame.setDefaultLookAndFeelDecorated(true);
		marco = new JFrame("imagen1");
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		marco.setLayout(new BorderLayout());
	}
	
	void init_panel(){
		JLabel label = new JLabel();
		label.setIcon(new ImageIcon(imagenReal));
		panel = new JPanel();
		// panel.setBorder(BorderFactory.createEmptyBorder(30,30,30,30));
		panel.add(label);
	}
}
