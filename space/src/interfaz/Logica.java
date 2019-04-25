package interfaz;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PVector;
import space.Enemigo;
import space.Nave;
import space.Personaje;

public class Logica extends Thread {

	private PApplet app;
	private Personaje personaje;
	private ArrayList<Enemigo> enemigos;
	private int pantalla, mapY, map2Y;
	private PImage stage;
	int contador;
	public boolean isPlay = true;

	public Logica() {
		this.app = Main.app;
		app.imageMode(app.CENTER);
		int r = (int) app.random(1,4);
		this.enemigos = new ArrayList<>();
		personaje = new Nave(new PVector(app.width / 2, app.height - 100), r);
		Enemigo.r = r;
		new Thread((Nave) personaje).start();
		
		pantalla = 6;
	
		
		
		switch (r) {
		case 1:
			stage = app.loadImage("Amor.png");
			break;
		case 2:
			stage = app.loadImage("Hogar.png");
			break;
			
		case 3:
			stage = app.loadImage("Heroes.png");
			break;

		}
		
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 3; j++) {
					Enemigo temp = new Enemigo(new PVector(170*(i+1), 50 - (120*(j))), ((Nave) personaje).balas);
					enemigos.add(temp);
					temp.start();
					contador = 0;
			}
		}
		mapY = app.height;
		mapY = mapY-(stage.height/2);
	}

	public void draw() {
		if (pantalla == 6) {
			app.image(stage, app.width/2, mapY-stage.height+10);
			app.image(stage, app.width/2, mapY);
			personaje.draw();
			for (int i = 0; i < enemigos.size(); i++) {
				enemigos.get(i).draw();
			}
		}
	}

	public void update() {

		for (int i = 0; i < enemigos.size(); i++) {
			if (!enemigos.get(i).isAlive()) {
				enemigos.remove(i);
				return;
			}
		}
		
		mapY+= 5;
		map2Y+= 5;
		if (mapY >= stage.height) {
			mapY = map2Y-(stage.height/2);
		}
		if (map2Y >= stage.height) {
			map2Y = mapY-(stage.height/2);
		}
		for (int i = 0; i < enemigos.size(); i++) {
				
			if (enemigos.get(i).getY() > app.height-100) {
				isPlay = false;
				pantalla = 7;
			}
		}
	}

	@Override
	public void run() {
		while (isPlay) {
			update();
			// TODO Auto-generated method stub
			try {
				sleep(21);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void mousePressed() {

	}

	public void mouseReleased() {

	}

	public void keyPressed() {
		((Nave) personaje).keyboardPressed();
	}

	public void keyReleased() {
		((Nave) personaje).keyboardReleased();
	}

}
