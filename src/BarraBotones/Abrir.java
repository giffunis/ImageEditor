package BarraBotones;

import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class Abrir extends JButton {
	Icon icono = new ImageIcon("src/images/Open.png");
	
	Abrir(){
		super();
		this.setName("Abrir");
		this.setToolTipText("Abrir");
		this.setSelected(false);
		this.addMouseListener(new VigilaAbrir());
		this.setIcon(icono);		
	}
	
	class VigilaAbrir extends MouseAdapter{
		public void mouseReleased(MouseEvent e){
			JFileChooser fc = new JFileChooser();
			@SuppressWarnings("unused")
			int returnVal = fc.showDialog(Menu.panelP,"Attach");
		}
	}
}
