package Funciones;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;



import java.util.Vector;

public class ProcesamientoImagen {
	static final int SIZE = 256;
	//Imagen actual que se ha cargado
	public BufferedImage imageActual;
     
    //Método que devuelve una imagen abierta desde archivo
    //Retorna un objeto BufferedImagen
    public BufferedImage abrirImagen(){
        //Creamos la variable que será devuelta (la creamos como null)
        BufferedImage bmp=null;
        //Creamos un nuevo cuadro de diálogo para seleccionar imagen
        JFileChooser selector=new JFileChooser();
        //Le damos un título
        selector.setDialogTitle("Seleccione una imagen");
        //Filtramos los tipos de archivos
        FileNameExtensionFilter filtroImagen = new FileNameExtensionFilter("JPG & GIF & BMP & PNG", "jpg", "gif", "bmp", "png");
        selector.setFileFilter(filtroImagen);
        //Abrimos el cuadro de diálog
        int flag=selector.showOpenDialog(null);
        //Comprobamos que pulse en aceptar
        if(flag==JFileChooser.APPROVE_OPTION){
            try {
                //Devuelve el fichero seleccionado
                File imagenSeleccionada=selector.getSelectedFile();
                //Asignamos a la variable bmp la imagen leida
                bmp = ImageIO.read(imagenSeleccionada);
            } catch (Exception e) {
            }
                  
        }
        //Asignamos la imagen cargada a la propiedad imageActual
        imageActual=bmp;
        //Retornamos el valor
        return bmp;
    }
    
    public void guardarImagen(){
    	//Creamos un nuevo cuadro de diálogo para seleccionar imagen
        JFileChooser selector=new JFileChooser();
        //Le damos un título
        selector.setDialogTitle("Guardar como...");
        
        
        FileFilter filter1 = new ExtensionFileFilter("JPG", new String[] { "JPG"});
        FileFilter filter2 = new ExtensionFileFilter("GIF", new String[] { "GIF"});
        FileFilter filter3 = new ExtensionFileFilter("BMP", new String[] { "BMP"});
        FileFilter filter4 = new ExtensionFileFilter("PNG", new String[] { "PNG"});
        
        selector.setAcceptAllFileFilterUsed(false);
        selector.addChoosableFileFilter(filter1);
        selector.addChoosableFileFilter(filter2);
        selector.addChoosableFileFilter(filter3);
        selector.addChoosableFileFilter(filter4);
        
        
        //Abrimos el cuadro de diálog
        int flag=selector.showSaveDialog(null);
        //Comprobamos que pulse en aceptar
        if(flag==JFileChooser.APPROVE_OPTION){
            try {
            	String name = selector.getSelectedFile().getAbsolutePath();
            	String name1 = selector.getFileFilter().getDescription();
            	String ext = "png";
            	if (name1.equals("JPG")){
                    ext = "jpg";
                    name = name +"."+ ext;
                    System.out.println(name);
                }
                else if(name1.equals("PNG")){
                    ext = "png";
                    name = name +"."+ ext;
                    System.out.println(name);
                }
                else if(name1.equals("GIF")){
                    ext = "gif";
                    name = name +"."+ ext;
                    System.out.println(name);
                }
                else if(name1.equals("BMP")){
                    ext = "bmp";
                    name = name +"."+ ext;
                    System.out.println(name);
                }
                else if(name1.equals("All Files")){     
                    System.out.println(name);
                }
                else{
                	JOptionPane.showMessageDialog(new JFrame(), "Error guardando la imagen");
                }
            	try{
            		ImageIO.write(imageActual, ext, new File(name));
            	} catch(Exception e){
            		JOptionPane.showMessageDialog(new JFrame(), "Error guardando la imagen");
            	}
            	  	
            } catch (Exception e) {
            }
                  
        }  	
    }
     
    public BufferedImage escalaGrises(){
        //Variables que almacenarán los píxeles
        int gris,colorSRGB;
        Color colorAux;
                 
        //Recorremos la imagen píxel a píxel
        for( int i = 0; i < imageActual.getWidth(); i++ ){
            for( int j = 0; j < imageActual.getHeight(); j++ ){
                //Almacenamos el color del píxel
                colorAux=new Color(this.imageActual.getRGB(i, j));
                //Calculamos la media de los tres canales (rojo, verde, azul)
                gris =(int)(0.222*colorAux.getRed()+0.707*colorAux.getGreen()+0.071*colorAux.getBlue());
                //Cambiamos a formato sRGB
                colorSRGB=(gris << 16) | (gris << 8) | gris;
                //Asignamos el nuevo valor al BufferedImage
                imageActual.setRGB(i, j,colorSRGB);
            }
        }
        //Retornamos la imagen
        return imageActual;
    }
    
    public Vector<Integer> histogramaAbsoluto(){
    
    	Vector<Integer> hist = new Vector<Integer>(0);
    	Color aux;
    	
    	for(int i = 0; i < SIZE; i++)
    		hist.addElement(0);
    	
    	for( int i = 0; i < imageActual.getWidth(); i++ )
            for( int j = 0; j < imageActual.getHeight(); j++ ){
                aux = new Color(this.imageActual.getRGB(i, j));
                hist.set(aux.getRed(),hist.get(aux.getRed()) + 1);
            }
    	
    	return hist;
    }
    
    public Vector<Integer> histogramaAcumulativo(){
    	Vector<Integer> hist = histogramaAbsoluto();
    	Vector<Integer> salida = new Vector<Integer>(0);
    	
    	salida.addElement(hist.get(0));
    	for(int i = 1; i< hist.size(); i++)
    		salida.addElement(salida.get(i - 1) + hist.get(i));
    	
    	return salida;
    }
    
    
}
