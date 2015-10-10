package BarraBotones;

import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import javax.swing.filechooser.FileFilter ;


@SuppressWarnings("serial")
public class Abrir extends JButton {
	Icon icono = new ImageIcon("src/images/Open.png");
	
	Abrir(){
		this.setName("Abrir");
		this.setToolTipText("Abrir");
		this.setSelected(false);
		this.addMouseListener(new VigilaAbrir());
		this.setIcon(icono);		
	}
	
	class VigilaAbrir extends MouseAdapter{
		public void mouseReleased(MouseEvent e){
			JFileChooser fc = new JFileChooser();
			fc.addChoosableFileFilter(new FiltraImagenes());
			int res = fc.showDialog(null,"Abrir imagen");
			if(res == JFileChooser.APPROVE_OPTION){
				File fichero = fc.getSelectedFile();
				JOptionPane.showMessageDialog(new JFrame(), fichero.getName());
			}else{
				JOptionPane.showMessageDialog(new JFrame(), "Formato no acceptado");
			}
		}
		
	}
	
	class FiltraImagenes extends FileFilter{
		public boolean accept(File f){
			String extension = null;
			if(f.isDirectory())
				return true;
			String nom = f.getName();
			int posi = nom.lastIndexOf(".");
			if(posi >= 0 && nom != null)
				extension = nom.substring(posi);
			if(extension != null)
				if(extension.equals(".bmp") || extension.equals(".png") || extension.equals(".jpeg") || extension.equals(".giff"))
					return true;
			return false;
		}
		
		public String getDescription(){
			return "*.bmp;*.png;*.jpeg;*.gif";
		}
	}
}
