package BarraBotones;

import javax.swing.*;

import ImageEditor.ImageEditor;

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
		JOptionPane.showMessageDialog(new JFrame(), "¡Ha pulsado el botón abrir!");
	}
	

}