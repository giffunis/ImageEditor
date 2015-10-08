package BarraHerramientas;

import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;



public class Menu {
	 JButton listaBotones[];
	 String listaNombres[] = {"Abrir imagen", "Guardar imagen"};
	 public JPanel panelP;
	 
	 
	 public Menu(){
		 listaBotones = new JButton[listaNombres.length];
	     panelP = new JPanel();
	     panelP.setLayout(new FlowLayout(FlowLayout.LEFT));
	     //Icon icon = new ImageIcon("src/images/iconImage.png");
	     
	     for(int i = 0; i < listaNombres.length; i++){
            listaBotones[i] = new JButton();
            listaBotones[i].setName(listaNombres[i]);
            listaBotones[i].setToolTipText(listaNombres[i]);
            listaBotones[i].setSelected(false);
          //  listaBotones[i].addMouseListener(new VigilaBarraHerr());
            panelP.add(listaBotones[i]);
        }	// End for
        listaBotones[0].setIcon(new ImageIcon("src/images/open.png"));
        listaBotones[1].setIcon(new ImageIcon("src/images/save.png"));     
	 }
	 
	 
}
