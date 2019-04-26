package space;

import java.util.ArrayList;

import interfaz.Main;
import pantalla.Img;
import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PImage;
import processing.core.PVector;

public class Enemigo extends Personaje implements Runnable {
	
	private int c;
	public static int r;
	private ArrayList<Bala> balas;
	private PImage enemigo;

	private Thread hilo;

	public Enemigo(PVector pos) {
		super(pos);
		this.app = Main.app;
		this.hilo = new Thread(this);
		this.width = 100;
		this.height = 100;
		this.velocidad = 4;
		

		switch (r) {
		case 1:
			c = (int) app.random(1, 3);
			switch (c) {
			case 1:
				enemigo = Img.loadImage("Corazon1.png");
				break;
			case 2:
				enemigo = Img.loadImage("Corazon2.png");
				break;
			}
			break;
		case 2:
			c = (int) app.random(1, 4);
			switch (c) {
			case 1:
				this.enemigo = Img.loadImage("Gatito1.png");
				break;
			case 2:
				this.enemigo = Img.loadImage("Gatito2.png");
				break;
			case 3:
				this.enemigo = Img.loadImage("Gatito3.png");
				break;
			}

			break;

		case 3:
			c = (int) app.random(1, 3);
			switch (c) {
			case 1:
				this.enemigo = Img.loadImage("Ladron1.png");
				break;
			case 2:
				this.enemigo = Img.loadImage("Ladron2.png");
				break;
			}

			break;

		}

	}

	public void draw() {
		this.app.fill(255, 0, 0);
		this.app.imageMode(PConstants.CENTER);
		this.app.image(enemigo, pos.x, pos.y);
	}

	public void update() {
		this.pos.x += this.velocidad;

		if (this.pos.x < 50 || this.pos.x > this.app.width - 50) {
			this.velocidad *= -1;
			this.pos.y += 150;
		}
	}

	public void start() {
		this.hilo.start();
	}

	public void run() {
		while (isAlive) {
			try {
				update();
				
				Thread.sleep(20);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}


	public void setY(float y) {
		this.pos.y = y;
	}

	public boolean isIsalive() {
		return isAlive;
	}

	public void setIsalive(boolean vivo) {
		this.isAlive = vivo;
	}

}
