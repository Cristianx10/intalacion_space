package space;

import java.util.ArrayList;

import processing.core.PVector;

public class Nave extends Personaje implements Runnable {

	private boolean isMovingLeft, isMovingRight, isAlive;
	private int vel = 3;
	public static ArrayList<Bala> balas;

	public Nave(PVector pos) {
		super(pos);
		isMovingLeft = false;
		isMovingRight = false;
		isAlive = true;
		balas = new ArrayList<Bala>();
	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		for (int i = 0; i < balas.size(); i++) {
			balas.get(i).draw();
		}
		app.fill(255, 0, 255, 80);
		app.triangle(pos.x - width, pos.y + height, pos.x + width, pos.y + height, pos.x, pos.y - height);
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
			balas.add(new Bala(new PVector(pos.x, pos.y)));
		}
	}

	public void update() {
		if (isMovingLeft) {
			pos.x -= vel;
		} else if (isMovingRight) {
			pos.x += vel;
		}
		
		for (int i = 0; i < balas.size(); i++) {
			if (balas.get(i).getY() < -50) {
				balas.remove(i);
			}
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (isAlive) {
			update();
			for (int i = 0; i < balas.size(); i++) {
				balas.get(i).update();
			}
			try {
				Thread.sleep(16);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
