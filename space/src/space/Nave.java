package space;

import java.util.ArrayList;

import processing.core.PImage;
import processing.core.PVector;

public class Nave extends Personaje implements Runnable {

	private boolean isMovingLeft, isMovingRight, isAlive;
	private int vel = 6;
	public ArrayList<Bala> balas;
	private PImage player;
	

	public Nave(PVector pos, int r) {
		super(pos);
		isMovingLeft = false;
		isMovingRight = false;
		isAlive = true;
		balas = new ArrayList<Bala>();
		
		switch (r) {
		case 1:
			player = app.loadImage("arco.png");
			Bala.proyectil = app.loadImage("Flecha.png");
			break;
		case 2:
			player = app.loadImage("Jugador.png");
			Bala.proyectil = app.loadImage("PCorazon.png");
			break;
			
		case 3:
			player = app.loadImage("Batman.png");
			Bala.proyectil = app.loadImage("Bala.png");
			break;

		}
	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		for (int i = 0; i < balas.size(); i++) {
			balas.get(i).draw();
		}
		app.fill(255, 0, 255, 80);
		app.image(player, pos.x, pos.y);
	}

	public void keyboardPressed() {
		if (app.keyCode == app.RIGHT) {
			isMovingRight = true;
		} else if (app.keyCode == app.LEFT) {
			isMovingLeft = true;
		}
	}

	public void keyboardReleased() {
		if (app.keyCode == app.RIGHT) {
			isMovingRight = false;
		} else if (app.keyCode == app.LEFT) {
			isMovingLeft = false;
		}
		if (app.key == ' ') {
			balas.add(new Bala(new PVector(pos.x, pos.y), this));
		}
	}

	public void update() {
		if (isMovingLeft) {
			pos.x -= vel;
		} else if (isMovingRight) {
			pos.x += vel;
		}
		
		for (int i = 0; i < this.balas.size(); i++) {
			Bala b = this.balas.get(i);
			if(b.getContacto()) {
				balas.remove(b);
			}
		}
		
	}

	@Override
	public void run() {
		while (isAlive) {
			update();
			for (int i = 0; i < balas.size(); i++) {
				balas.get(i).update();
			}
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
