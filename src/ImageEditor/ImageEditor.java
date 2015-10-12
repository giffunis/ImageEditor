package ImageEditor;

import java.awt.BorderLayout;

import javax.swing.*;

import BarraBotones.BarraBotones;

public class ImageEditor {

	//	Declaración de variables
	JFrame framePrincipal;
	JPanel panelPrincipal;
	BarraBotones barraBotonesPrincipal;
	
	//Constructor
	ImageEditor(){
		init_panelPrincipal();
		init_barraBotonesPrincipal();
		init_framePrincipal();
	}
	
	void init_panelPrincipal(){
		JLabel etiqueta = new JLabel("ImageEditor.");
		panelPrincipal = new JPanel();
		panelPrincipal.setBorder(BorderFactory.createEmptyBorder(30,30,30,30));
		panelPrincipal.add(etiqueta);
	}
	
	void init_barraBotonesPrincipal(){
		barraBotonesPrincipal = new BarraBotones();
	}
	
	void init_framePrincipal(){
		JFrame.setDefaultLookAndFeelDecorated(true);
		framePrincipal = new JFrame("ImageEditor");
		framePrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		framePrincipal.add(panelPrincipal, BorderLayout.CENTER);	//	Añadimos panelPrincipal al framePrincipal
		framePrincipal.add("North", barraBotonesPrincipal);	//	Añadimos barraPrincipal al framePrincipal
		framePrincipal.pack();
		framePrincipal.setVisible(true);
	}
	
    public static void main(String[] args) {
    	@SuppressWarnings("unused")
		ImageEditor programa = new ImageEditor();
    }
    
}
