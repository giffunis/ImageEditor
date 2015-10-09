package BarraBotones;

import javax.swing.*;

import ImageEditor.ImageEditor;

@SuppressWarnings("serial")
public class BarraBotones extends JToolBar{
	Abrir boton1;
	Guardar boton2;
	ImageEditor marco;
	
	public BarraBotones(ImageEditor marco){
		this.marco = marco;
		this.boton1 = new Abrir();
		this.boton2 = new Guardar();
		add(boton1);
		add(boton2);
	}

}
