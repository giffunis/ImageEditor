package BarraBotones;

import java.awt.*;
import javax.swing.*;

public class Menu {
	 JButton listaBotones[];
	 String listaNombres[] = {"Guardar imagen"};
	 public static JPanel panelP;
	 
	 public Menu(){
		 Abrir openButton = new Abrir();
		 Guardar saveButton = new Guardar();
		 
		 panelP = new JPanel();
	     panelP.setLayout(new FlowLayout(FlowLayout.LEFT));
	     panelP.add(openButton);
	     panelP.add(saveButton);  
	 }
}
