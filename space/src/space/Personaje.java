package space;

import interfaz.Logica;
import interfaz.Main;
import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PVector;

public abstract class Personaje {
	
	protected PApplet app;
	protected Logica log;
	protected PVector pos;
	protected int width;
	protected int height;
	protected int aciertos, fallos;
	protected int velocidad;
	protected boolean isAlive;
	
	
	public Personaje(PVector pos) {
		this.app = Main.app;
		this.log = Main.log;
		this.pos = pos;
		this.width = 25;
		this.height = 25;
		this.isAlive = true;
		this.velocidad =0;
	}
	
	
	public void pintar() {
		this.draw();
		this.app.rectMode(PConstants.CENTER);
		this.app.rect(this.pos.x, this.pos.y, width, height);
	}
	
	public abstract void draw();
	
	
	public boolean sobre(Personaje p) {
		boolean sobre = false;
		if(PApplet.dist(this.pos.x, this.pos.y, p.pos.x, p.pos.y) < ((height/2) + (p.height/2))) {
			sobre = true;
		}
		return sobre;
	}
	
	public float getX() {
		return this.pos.x;
	}
	
	public float getY() {
		return this.pos.y;
	}
	
}
