package pantalla;

import interfaz.Main;
import processing.core.PApplet;

public interface IPantallaB{
	
	PApplet app = Main.app;
	
	public void mouseReleased();
	public void mousePressed();
	public void draw();
	public void setup();
	public void settings();
	
	
}