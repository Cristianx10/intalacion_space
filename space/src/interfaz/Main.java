package interfaz;

import processing.core.PApplet;
import processing.event.KeyEvent;

public class Main extends PApplet{
	
	static PApplet app;
	static Logica log;

	public static void main(String[] args) {
		PApplet.main("interfaz.Main");

	}
	
	@Override
	public void settings() {
		size(1200, 700);
		
	}
	
	@Override
	public void setup() {
		app = this;
		log = new Logica(this);
		
	}
	
	@Override
	public void draw() {
		log.draw();
	}
	
	@Override
	public void mousePressed() {
		log.mousePressed();
	}
	
	@Override
	public void mouseReleased() {
		log.mouseReleased();
	}
	
	@Override
	public void keyPressed() {
		log.keyPressed();
	}
	
	@Override
	public void keyReleased() {
		log.keyReleased();
	}
	

}