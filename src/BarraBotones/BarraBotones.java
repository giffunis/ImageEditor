package BarraBotones;

import java.awt.image.BufferedImage;

import javax.swing.*;

import Funciones.ProcesamientoImagen;
import ImageEditor.ImageEditor;
import ImageEditor.Imagenes;

@SuppressWarnings("serial")
public class BarraBotones extends JToolBar{
	
	ImageEditor api;
	JButton btnAbrir;
	
	public BarraBotones(ImageEditor api){
		this.api = api;
		init_btnAbrir();
	}
	
	void init_btnAbrir(){
		btnAbrir = new JButton();
		btnAbrir.setName("Abrir");
		btnAbrir.setToolTipText("Abrir");
		btnAbrir.setSelected(false);
		btnAbrir.setIcon(new ImageIcon("src/images/Open.png"));	
		btnAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbrirActionPerformed(evt);
            }
        });
		add(btnAbrir);
	}
	
	private void btnAbrirActionPerformed(java.awt.event.ActionEvent evt) {
		ProcesamientoImagen objProcesamiento =new ProcesamientoImagen();
		BufferedImage auxImage;
		auxImage = objProcesamiento.abrirImagen();
		Imagenes imagenCompleta = new Imagenes(auxImage,api);
		api.imagenes.add(imagenCompleta);
		
		
	}
	

}