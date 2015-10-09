package ImageEditor;

import javax.swing.*;
import java.awt.*;

import BarraBotones.BarraBotones;
import BarraBotones.Menu;


public class ImageEditor {

	Menu menu;
    JFrame marco;
    
    ImageEditor(){
        marco = new JFrame("ImageEditor");
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   // Para que funcione el botón de cerrar
        marco.setLayout(new BorderLayout());    // Crea un borde para que el contenido del panel y el marco, estén separados.
        marco.setSize(400,200);
        marco.setIconImage(Toolkit.getDefaultToolkit().createImage("images/imageIcon.png"));
        //marco.pack();
        JFrame.setDefaultLookAndFeelDecorated(true);
        //menu = new Menu();
        //marco.add(menu.panelP,"North");
        BarraBotones barra = new BarraBotones(this);
        marco.add("North", barra);
        marco.setVisible(true);
    }
        
    public static void main(String[] args) {
        @SuppressWarnings("unused")
		ImageEditor e1 = new ImageEditor();
    }
    
}
