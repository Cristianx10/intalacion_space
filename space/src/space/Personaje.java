package space;

import interfaz.Main;
import processing.core.PApplet;
import processing.core.PVector;

public abstract class Personaje {
	
	protected PApplet app;
	protected PVector pos;
	protected int width;
	protected int height;
	
	
	public Personaje(PVector pos) {
		this.app = Main.app;
		this.pos = pos;
		this.width = 25;
		this.height = 25;
	}
	
	public void pintar() {
		this.draw();
		this.app.rect(this.pos.x, this.pos.y, width, height);
	}
	
	public abstract void draw();
	
	
	public boolean sobre(Personaje p) {
		boolean sobre = false;
		if(PApplet.dist(this.pos.x, this.pos.y, p.pos.x, p.pos.y) < ((width/2) + (p.width/2))) {
			sobre = true;
		}
		return sobre;
	}
	
	public float getX() {
		return pos.x;
	}
	
	public float getY() {
		return pos.y;
	}
	
}
