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
	JButton btnEscalaGrises;
	
	public BarraBotones(ImageEditor api){
		this.api = api;
		init_btnAbrir();
		init_btnEscalaGrises();
	}
	
	//	BTN ABRIR
	
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
		@SuppressWarnings("unused")
		Imagenes imagenCompleta = new Imagenes(auxImage,api);
	}
	
	// BTN ESCALA DE GRISES
	
	void init_btnEscalaGrises(){
		btnEscalaGrises = new JButton();
		btnEscalaGrises.setName("Escala de grises");
		btnEscalaGrises.setToolTipText("Escala de grises");
		btnEscalaGrises.setSelected(false);
		btnEscalaGrises.setIcon(new ImageIcon("src/images/EscalaGrises.png"));
		btnEscalaGrises.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEscalaGrisesActionPerformed(evt);
            }
        });
		add(btnEscalaGrises);
	}
	
	private void btnEscalaGrisesActionPerformed(java.awt.event.ActionEvent evt) {
		JInternalFrame internalFrame = api.desktopPane.getSelectedFrame();
		String aux = internalFrame.getTitle();
		int pos = 0;
		for(int i = 0; i < api.imagenes.size(); i++){
			if(aux == api.imagenes.get(i).internalFrame.getTitle()){
				pos = i;
			}
		}
//		JOptionPane.showMessageDialog(new JFrame(), pos);
		ProcesamientoImagen imagenEntrada = new ProcesamientoImagen();
		imagenEntrada.imageActual = api.imagenes.get(pos).imagenReal;
		BufferedImage imagenSalida = new BufferedImage(imagenEntrada.imageActual.getWidth(),imagenEntrada.imageActual.getHeight(),imagenEntrada.imageActual.getType());
		imagenSalida = imagenEntrada.escalaGrises();
		@SuppressWarnings("unused")
		Imagenes imagenCompleta = new Imagenes(imagenSalida,api);
	}
	

}