package space;

import processing.core.PImage;
import processing.core.PVector;

public class Bala extends Personaje{
    public static PImage proyectil;
	public Bala(PVector pos, int r) {
		super(pos, r);
	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		app.image(proyectil, pos.x, pos.y);
	}
	
	public void update() {
		pos.y -= 8;
	}

}
