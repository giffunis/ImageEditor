package ImageEditor;

import java.awt.BorderLayout;

//import java.awt.GridLayout;
import java.util.Vector;

import javax.swing.*;

import BarraBotones.BarraBotones;
import MenuBar.BarraMenu;

public class ImageEditor {

	//	Declaración de variables
	JFrame framePrincipal;
	public JDesktopPane desktopPane;
	BarraBotones barraBotonesPrincipal;
	public Vector<Imagenes> imagenes;
	BarraMenu menuBar;
	
	//Constructor
	ImageEditor(){
		imagenes = new Vector<Imagenes>(0);
		
		init_framePrincipal();
		init_desktopPanel();
		init_barraBotonesPrincipal();
		init_menuBar();
		
		framePrincipal.add(desktopPane, BorderLayout.CENTER);	//	Añadimos panelPrincipal al framePrincipal
		framePrincipal.add("North", barraBotonesPrincipal);	//	Añadimos barraPrincipal al framePrincipal
		framePrincipal.setJMenuBar(menuBar);
		
		framePrincipal.setExtendedState(JFrame.MAXIMIZED_BOTH);
		framePrincipal.setVisible(true);
	}
	
	void init_desktopPanel(){
		desktopPane = new JDesktopPane();
		//desktopPane.setLayout(new GridLayout(3,3));
	}
	
	void init_barraBotonesPrincipal(){
		barraBotonesPrincipal = new BarraBotones(this);
	}
	
	void init_menuBar(){
		menuBar = new BarraMenu(this);
	}
	
	void init_framePrincipal(){
		JFrame.setDefaultLookAndFeelDecorated(false);
		framePrincipal = new JFrame("ImageEditor");
		framePrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		framePrincipal.setLayout(new BorderLayout());
	}
	
    public static void main(String[] args) {
    	@SuppressWarnings("unused")
		ImageEditor programa = new ImageEditor();
    }
    
}
