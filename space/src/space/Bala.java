package space;

import processing.core.PImage;
import processing.core.PVector;

public class Bala extends Personaje {
	public static PImage proyectil;
	private boolean contacto;


	public Bala(PVector pos, Personaje p) {
		super(pos);
		this.contacto = false;
		this.velocidad = 8;
		
	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		this.app.image(proyectil, pos.x, pos.y);
	}

	public void update() {
		if (this.pos.y < -this.height) {
			this.contacto = true;
			this.fallos++;
		}
		
		for (int i = 0; i < log.getEnemigos().size(); i++) {
			Enemigo e = log.getEnemigos().get(i);
			if(sobre(e)) {
				contacto = true;
				e.setIsalive(false);
				this.aciertos++;
			}
		}
		
		this.pos.y -= this.velocidad;
	}
	
	public boolean getContacto(){
		return this.contacto;
	}

}

