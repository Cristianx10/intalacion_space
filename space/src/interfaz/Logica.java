package interfaz;

import java.util.ArrayList;

import pantalla.Pantalla;
import processing.core.PApplet;
import processing.core.PVector;
import space.Enemigo;
import space.Nave;
import space.Personaje;

public class Logica extends Thread{

	private PApplet app;
	private ArrayList<Personaje> juagdores;
	private Personaje personaje;
	private ArrayList<Enemigo> enemigos;
	private Pantalla pantalla;
	public boolean isPlay = true;
	
	public Logica() {
		this.app = Main.app;
		this.juagdores = new ArrayList<>();
		this.enemigos = new ArrayList<>();
		personaje = new Nave(new PVector(app.width/2,app.height-100));
		int indiceY = 1;
		for (int j = 0; j < 4; j++) {
		for (int i = 0; i < 8; i++) {
			Enemigo temp = new Enemigo(new PVector(app.width/12*(i+1),50*j),((Nave) personaje).balas);
			enemigos.add(temp);
			temp.start();
		}
		}
		new Thread((Nave)personaje).start();
		
	}
	
	public void draw() {
		personaje.draw();
		for (int i = 0; i < enemigos.size(); i++) {
			enemigos.get(i).draw();
		}
	}
	
	public void update() {
		if (enemigos.get(0).getX() < 30 || enemigos.get(enemigos.size()-1).getX() > app.width-30) {
			Enemigo.vel *= -1;
			for (int i = 0; i < enemigos.size(); i++) {
				enemigos.get(i).setY(enemigos.get(i).getY()+50);
			}
		}
		
		for (int i = 0; i < enemigos.size(); i++) {
			if (!enemigos.get(i).isAlive()) {
				enemigos.remove(i);
				return;
			}
		}
	}
	
	@Override
	public void run() {
		while(isPlay) {
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
