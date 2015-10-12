package ImageEditor;

import java.awt.BorderLayout;

import javax.swing.*;

public class ImageEditor {

	//	Declaración de variables
	JFrame framePrincipal;
	JPanel panelPrincipal;
	
	//Constructor
	ImageEditor(){
		init_panelPrincipal();
		init_framePrincipal();
	}
	
	void init_panelPrincipal(){
		JLabel etiqueta = new JLabel("ImageEditor.");
		panelPrincipal = new JPanel();
		panelPrincipal.setBorder(BorderFactory.createEmptyBorder(30,30,30,30));
		panelPrincipal.add(etiqueta);
	}
	
	void init_framePrincipal(){
		JFrame.setDefaultLookAndFeelDecorated(true);
		framePrincipal = new JFrame("ImageEditor");
		framePrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		framePrincipal.add(panelPrincipal, BorderLayout.CENTER);
		framePrincipal.pack();
		framePrincipal.setVisible(true);
	}
	
    public static void main(String[] args) {
    	@SuppressWarnings("unused")
		ImageEditor programa = new ImageEditor();
    }
    
}
