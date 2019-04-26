
package interfaz;

import processing.core.PApplet;
import processing.event.KeyEvent;

public class Main extends PApplet{
	
	public static PApplet app;
	public static Logica log;

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
		log = new Logica();
		log.start();
		
	}
	
	@Override
	public void draw() {
		background(0);
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
