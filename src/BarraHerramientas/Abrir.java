package BarraHerramientas;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Abrir {
	Icon icon = new ImageIcon("src/images/iconImage.png");
	String name = "Open";
	JButton open;
	
	Abrir(){
		open = new JButton(name,icon);
		
	}
}
