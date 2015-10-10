package BarraBotones;

import javax.swing.*;

@SuppressWarnings("serial")
public class BarraBotones extends JToolBar{
	Abrir btn_abrir;
	Guardar btn_guardar;
	
	public BarraBotones(){
		this.btn_abrir = new Abrir();
		this.btn_guardar = new Guardar();
		add(btn_abrir);
		add(btn_guardar);
	}

}
