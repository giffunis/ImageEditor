package MenuBar;

import java.awt.image.BufferedImage;

import javax.swing.JInternalFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import Funciones.ProcesamientoImagen;
import ImageEditor.ImageEditor;
import ImageEditor.Imagenes;

@SuppressWarnings("serial")
public class BarraMenu extends JMenuBar {
	ImageEditor api;
	JMenu archivo;
	JMenuItem menuItem;

	public BarraMenu(ImageEditor api){
		this.api = api;
		initMenu();
	}
	
	// -------------- Inicializando el Menu file ----------------------
	
	void initMenu(){
		archivo = new JMenu("Archivo");
		initAbrir();
		initGuardar();
		add(archivo);
	}
	//--------------------------------------BTN ABRIR------------------------------------------
	void initAbrir(){
		menuItem = new JMenuItem("Abrir");
		menuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbrirActionPerformed(evt);
            }
        });
		archivo.add(menuItem);
	}
	private void btnAbrirActionPerformed(java.awt.event.ActionEvent evt) {
		ProcesamientoImagen objProcesamiento =new ProcesamientoImagen();
		BufferedImage auxImage;
		auxImage = objProcesamiento.abrirImagen();
		@SuppressWarnings("unused")
		Imagenes imagenCompleta = new Imagenes(auxImage,api);
	}
	//---------------------------------------- GUARDAR ---------------------------------------------
	void initGuardar(){
		menuItem = new JMenuItem("Guardar");
		menuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
		archivo.add(menuItem);
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
	
	
	
	
	
	
	
	
}
