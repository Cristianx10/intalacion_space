package pantalla;

import interfaz.Main;
import processing.core.PApplet;

public interface IPantalla{
	
	PApplet app = Main.app;
	
	public void mousePressed();
	public void mouseMouseDraged();
	public void mouseReleased();
	public void keyPressed();
	public void keyReleased();
	public void settings();
	public void setup();
	public void draw();
	
	
}