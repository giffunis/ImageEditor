package ImageEditor;

import javax.swing.*;
import java.awt.*;

import BarraBotones.BarraBotones;


public class ImageEditor {

	BarraBotones barra;
    JFrame marco;
    
    ImageEditor(){
        marco = new JFrame("ImageEditor");
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   // Para que funcione el botón de cerrar
        marco.setLayout(new BorderLayout());    // Crea un borde para que el contenido del panel y el marco, estén separados.
        marco.setSize(400,200);
        marco.setIconImage(Toolkit.getDefaultToolkit().createImage("images/imageIcon.png"));
        JFrame.setDefaultLookAndFeelDecorated(true);
        
        barra = new BarraBotones();
        marco.add("North", barra);
        
        marco.setVisible(true);
    }
        
    public static void main(String[] args) {
        @SuppressWarnings("unused")
		ImageEditor e1 = new ImageEditor();
    }
    
}
