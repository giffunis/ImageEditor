package BarraHerramientas;

import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.*;
import java.io.File;
import javax.swing.*;
import javax.swing.filechooser.*;

import ImageEditor.ImageEditor;


public class Menu {
	 JButton listaBotones[];
	 String listaNombres[] = {"Guardar imagen"};
	 public JPanel panelP;
	 
	 
	 public Menu(){
		 listaBotones = new JButton[listaNombres.length];
//	     JButton openButton = new Open().open;
		 JButton openButton = new JButton();
		 
		 openButton.setName("Open");
		 openButton.setToolTipText("Open");
		 openButton.setSelected(false);
		 openButton.addActionListener(new ListenerOpenButton());
		 
		 panelP = new JPanel();
	     panelP.setLayout(new FlowLayout(FlowLayout.LEFT));
	     panelP.add(openButton);
	     
	     for(int i = 0; i < listaNombres.length; i++){
            listaBotones[i] = new JButton();
            listaBotones[i].setName(listaNombres[i]);
            listaBotones[i].setToolTipText(listaNombres[i]);
            listaBotones[i].setSelected(false);
          //  listaBotones[i].addMouseListener(new VigilaBarraHerr());
            panelP.add(listaBotones[i]);
        }	// End for
        listaBotones[0].setIcon(new ImageIcon("src/images/save.png"));
        
 
	 }
	 
	 public class ListenerOpenButton implements ActionListener{
			public void actionPerformed(ActionEvent e){
				JFileChooser fc = new JFileChooser();
				int returnVal = fc.showDialog(panelP,
                        "Attach");
			}
		}
	 
	 
//	 class Open {
//		Icon icon = new ImageIcon("src/images/open.png");
//		String name = "Open";
//		JButton open;
//			
//		Open(){
//			open = new JButton(name,icon);
//			open.addActionListener(new ListenerOpenButton());
//		}
//		
//		public class ListenerOpenButton implements ActionListener{
//			public void actionPerformed(ActionEvent e){
//				JFileChooser fc = new JFileChooser();
//				fc.addChoosableFileFilter(new FiltraImagenes());
////				fc.setAccessory(new PreVisualizarImagen(fc));
//				
//			}
//		}
//		
//		class FiltraImagenes extends FileFilter{
//			public boolean accept(File f){
//				String extension = null;
//				if(f.isDirectory())
//					return true;
//				String nom = f.getName();
//				int posi = nom.lastIndexOf(".");
//				if(posi >= 0 && nom != null)
//					extension = nom.substring(posi);
//				if(extension != null)
//					if(extension.equals(".jpg") || extension.equals(".gif") || extension.equals(".png") || extension.equals(".bmp"))
//						return true;
//					return false;
//			}
//			
//			public String getDescription(){
//				return "*.jpg;*.gif;*.png;*.bmp";
//			}
//		}
//	}
}
