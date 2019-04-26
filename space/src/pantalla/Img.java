package pantalla;

import java.util.ArrayList;

import org.omg.CORBA.OMGVMCID;

import interfaz.Main;
import processing.core.PApplet;
import processing.core.PImage;

public class Img {
	static ArrayList<OImagen> imagenes;
	private PApplet app;
	
	public Img() {
		this.app = Main.app;
		this.imagenes = new ArrayList<>();
	}
	
	public static PImage loadImage(String url){
		PImage img = null;
		for (int i = 0; i < imagenes.size(); i++) {
			OImagen ima = imagenes.get(i);
			if(ima.url == url) {
				img = ima.getImage();
				return img;
			}
		}
		
		if(img == null) {
			OImagen ima = new OImagen(Main.app.loadImage(url), url);
			img = ima.getImage();
		}
		
		return img;
	}
	
}

class OImagen{
	private PImage imagen;
	public String url;
	
	public OImagen(PImage imagen, String url) {
		this.imagen = imagen;
		this.url = url;
	}
	
	public PImage getImage() {
		return this.imagen;
	}
}