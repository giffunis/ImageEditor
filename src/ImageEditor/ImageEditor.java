package ImageEditor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ImageEditor {

    JButton listaBotones[];
    String listaNombres[] = {"Abrir imagen", "Guardar imagen"};
    JTextArea areaTexto;    // Va a ser provisional.
    JPanel panelP;
    JFrame marco;
    
    ImageEditor(){
        marco = new JFrame("ImageEditor");
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   // Para que funcione el botón de cerrar
        marco.setLayout(new BorderLayout());    // Crea un borde para que el contenido del panel y el marco, estén separados.
        marco.setSize(400,200);
        marco.setIconImage(Toolkit.getDefaultToolkit().createImage("images/imageIcon.png"));
        //marco.pack();
        JFrame.setDefaultLookAndFeelDecorated(true);
        
        listaBotones = new JButton[listaNombres.length];
        panelP = new JPanel();
        panelP.setLayout(new FlowLayout(FlowLayout.LEFT));
        Icon icon = new ImageIcon("src/images/iconImage.png");
        
        for(int i = 0; i < listaNombres.length; i++){
            listaBotones[i] = new JButton(icon);
            listaBotones[i].setName(listaNombres[i]);
            listaBotones[i].setToolTipText(listaNombres[i]);
            listaBotones[i].setSelected(false);
            listaBotones[i].addMouseListener(new VigilaBarraHerr());
            panelP.add(listaBotones[i]);
        }	// End for
       
        marco.add(panelP,"North");
        
        areaTexto = new JTextArea("");	// Provisional
        marco.add(areaTexto,"Center");	// Provisional
        
        marco.setVisible(true);
    }
    
    class VigilaBarraHerr extends MouseAdapter{
    	public void mousePressed(MouseEvent e){
    		Component aux = e.getComponent();
    		Frame ventana = new Frame();
    		if(aux.getName().equals("Abrir imagen"))
    			areaTexto.append("Se ha pusado el botón de Abrir imágen \n");
    		else if(aux.getName().equals("Guardar imagen"))
    			areaTexto.append("Se ha pusado el botón de Guardar imágen \n");
    		else
    			areaTexto.append("Botón desconocido \n");
    	}
    	
    }
    
    public static void main(String[] args) {
        ImageEditor e1 = new ImageEditor();
    }
    
}
