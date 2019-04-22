package space;

import processing.core.PVector;

public class Bala extends Personaje{

	public Bala(PVector pos) {
		super(pos);
	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		app.stroke(0,255,0);
		app.strokeWeight(6);
		app.line(pos.x, pos.y, pos.x, pos.y + 25);
		app.noStroke();
	}
	
	public void update() {
		pos.y -= 5;
	}

}
