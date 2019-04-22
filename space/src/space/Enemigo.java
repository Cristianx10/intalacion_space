package space;

import java.util.ArrayList;

import interfaz.Main;
import processing.core.PApplet;
import processing.core.PVector;

public class Enemigo extends Thread {
	private PApplet app;
	private PVector pos;
	public static int vel;
	private int width;
	private int height;
	private boolean isAlive;
	private ArrayList<Bala> balas;	
	public Enemigo(PVector pos, ArrayList<Bala> balas) {
		this.balas = balas;
		this.app = Main.app;
		this.pos = pos;
		this.width = 25;
		this.height = 25;
		this.vel = 2;
		isAlive = true;
	}

	public void draw() {
		// TODO Auto-generated method stub
		app.fill(255,0,0);
		app.ellipse(pos.x, pos.y, width, height);
	}
	
	public void update(){
		pos.x += vel;		
	}
	
	public void collision() {
		for (int i = 0; i < balas.size(); i++) {
			if (app.dist(pos.x, pos.y, balas.get(i).getX(), balas.get(i).getY())< width) {
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
