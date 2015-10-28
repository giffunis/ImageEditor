package BarraBotones;

import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.WritableRaster;
import java.util.Vector;

import javax.swing.*;

import Funciones.Histograma;
import Funciones.ProcesamientoImagen;
import ImageEditor.ImageEditor;
import ImageEditor.Imagenes;

@SuppressWarnings("serial")
public class BarraBotones extends JToolBar{
	
	static final String HISTO_ABSO = "Histograma Absoluto";
	
	ImageEditor api;
	JButton btnAbrir;
	JButton btnEscalaGrises;
	JButton btnGuardar;
	JButton btnHistogramaAbsoluto;
	
	public BarraBotones(ImageEditor api){
		this.api = api;
		init_btnAbrir();
		init_btnGuardar();
		init_btnEscalaGrises();
		init_btnHistogramaAbsoluto();
	}
	
//--------------------------------------BTN ABRIR------------------------------------------
	
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
	

//---------------------------------------- GUARDAR ---------------------------------------------

	void init_btnGuardar(){
		btnGuardar = new JButton();
		btnGuardar.setName("Guardar");
		btnGuardar.setToolTipText("Guardar");
		btnGuardar.setSelected(false);
		btnGuardar.setIcon(new ImageIcon("src/images/save.png"));
		btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
		add(btnGuardar);
	}
	
	private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {
		JInternalFrame internalFrame = api.desktopPane.getSelectedFrame();
		String aux = internalFrame.getTitle();
		int pos = 0;
		for(int i = 0; i < api.imagenes.size(); i++){
			if(aux == api.imagenes.get(i).internalFrame.getTitle()){
				pos = i;
			}
		}
//		JOptionPane.showMessageDialog(new JFrame(), pos);
		ProcesamientoImagen imagenSalida = new ProcesamientoImagen();
		
		
		
		imagenSalida.imageActual = api.imagenes.get(pos).imagenReal;
		imagenSalida.guardarImagen();
	}
	
//--------------------------------------BTN ESCALA DE GRISES----------------------------------
	
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
	
	static BufferedImage deepCopy(BufferedImage bi) {
        ColorModel cm = bi.getColorModel();
        boolean isAlphaPremultiplied = cm.isAlphaPremultiplied();
        WritableRaster raster = bi.copyData(null);
        return new BufferedImage(cm, raster, isAlphaPremultiplied, null);
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
		ProcesamientoImagen imagenSalida = new ProcesamientoImagen();
		imagenSalida.imageActual = deepCopy(api.imagenes.get(pos).imagenReal);
		imagenSalida.imageActual = imagenSalida.escalaGrises();	
		@SuppressWarnings("unused")
		Imagenes imagenCompleta = new Imagenes(imagenSalida.imageActual,api);
	}

//	-----------------------------btnHistogramaAbsoluto	
	
	void init_btnHistogramaAbsoluto(){
		
		btnHistogramaAbsoluto = new JButton();
		btnHistogramaAbsoluto.setName("Histograma absoluto");
		btnHistogramaAbsoluto.setToolTipText("Histograma Absoluto");
		btnHistogramaAbsoluto.setSelected(false);
		btnHistogramaAbsoluto.setIcon(new ImageIcon("src/images/EscalaGrises.png"));
		
		btnHistogramaAbsoluto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHistogramaAbsolutoActionPerformed(evt);
            }
        });
		add(btnHistogramaAbsoluto);
	}
	
	private void btnHistogramaAbsolutoActionPerformed(java.awt.event.ActionEvent evt) {
		JInternalFrame internalFrame = api.desktopPane.getSelectedFrame();
		String aux = internalFrame.getTitle();
		int pos = 0;
		for(int i = 0; i < api.imagenes.size(); i++){
			if(aux == api.imagenes.get(i).internalFrame.getTitle()){
				pos = i;
			}
		}
		ProcesamientoImagen imagenSalida = new ProcesamientoImagen();
		imagenSalida.imageActual = api.imagenes.get(pos).imagenReal;
		Vector<Integer> vectorHist = imagenSalida.histogramaAbsoluto();
		
		@SuppressWarnings("unused")
		Histograma histo = new Histograma(this.api,HISTO_ABSO + ": imagen " + (pos + 1),vectorHist);
	}
	
}