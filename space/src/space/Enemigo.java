package space;

import java.util.ArrayList;

import interfaz.Main;
import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PVector;

public class Enemigo extends Thread {
	private PApplet app;
	private PVector pos;
	public int vel;
	private int width;
	private int height;
	private int c;
	public static int r;
	private boolean isAlive;
	private ArrayList<Bala> balas;	
	private PImage enemigo;
	public Enemigo(PVector pos, ArrayList<Bala> balas) {
		this.balas = balas;
		this.app = Main.app;
		this.pos = pos;
		this.width = 25;
		this.height = 25;
		this.vel = 2;
		isAlive = true;
		
		switch (r) {
		case 1:
			c = (int) app.random(1,3);
			switch (c) {
			case 1:
				enemigo = app.loadImage("Corazon1.png");
				vel = 4;
				break;
			case 2:
				enemigo = app.loadImage("Corazon2.png");
				vel = 7;
				break;

			}
			break;
		case 2:
			c = (int) app.random(1,4);
			switch (c) {
			case 1:
			enemigo = app.loadImage("Gatito1.png");
			vel = 4;
			break;
			case 2:
				enemigo = app.loadImage("Gatito2.png");
				vel = 4;
				break;
			case 3:
				enemigo = app.loadImage("Gatito3.png");
				vel = 7;
				break;
			}

			break;
			
		case 3:
			c = (int) app.random(1,3);
			switch (c) {
			case 1:
			enemigo = app.loadImage("Ladron1.png");
			vel = 4;
			break;
			case 2:
				enemigo = app.loadImage("Ladron2.png");
				vel = 7;
				break;
			}
			
			break;

		}
	
	}

	public void draw() {
		// TODO Auto-generated method stub
		app.fill(255,0,0);
		app.image(enemigo, pos.x, pos.y);
	}
	
	public void update(){
		pos.y += vel;		
	}
	
	public void collision() {
		for (int i = 0; i < balas.size(); i++) {
			if (app.dist(pos.x, pos.y, balas.get(i).getX(), balas.get(i).getY())< enemigo.width/2) {
				isAlive = false;
				balas.remove(i);
				return;
			}
		}
	}

	
	public void run() {
		while(isAlive) {
			update();
			collision();
		try {
			sleep(20);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}
	
	public float getX() {
		return pos.x;
	}
	
	public float getY() {
		return pos.y;
	}
	
	public void setY(float y) {
		pos.y = y;
	}

	public boolean isIsalive() {
		return isAlive;
	}
	

}
