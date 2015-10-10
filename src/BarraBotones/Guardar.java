package BarraBotones;

import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class Guardar extends JButton {
	Icon icono = new ImageIcon("src/images/Save.png");
	
	Guardar(){
		this.setName("Guardar");
		this.setToolTipText("Guardar");
		this.setSelected(false);
		this.addMouseListener(new VigilaGuardar());
		this.setIcon(icono);		
	}
	
	class VigilaGuardar extends MouseAdapter{
		public void mouseReleased(MouseEvent e){
			JOptionPane.showMessageDialog(new JFrame(), "¡Ha pulsado el botón de guardar!");
		}
	}
}







