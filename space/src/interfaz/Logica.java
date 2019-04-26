package interfaz;

import java.util.ArrayList;

import pantalla.CPantalla;
import pantalla.IPantalla;
import pantalla.IPantallaB;
import pantalla.IPantallaC;
import pantalla.Img;
import pantalla.Pantalla;
import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PVector;
import space.Enemigo;
import space.Nave;
import space.Personaje;

public class Logica extends Thread {

	private PApplet app;
	public static Img img;
	private Pantalla pantalla;
	private ArrayList<CPantalla> pantallas;
	private ArrayList<Enemigo> enemigos;

	public Logica() {
		this.app = Main.app;
		img = new Img();
		this.enemigos = new ArrayList<>();
		this.pantallas = new ArrayList();

		this.pantallas.add(inicio);
		this.pantallas.add(juego);
		
		

		this.pantalla = new Pantalla(pantallas);

		app.imageMode(app.CENTER);
	}

	public void draw() {

	}

	public void mousePressed() {

	}

	public void mouseReleased() {

	}

	public void keyPressed() {
		
	}

	public void keyReleased() {
		
	}

	public ArrayList<Enemigo> getEnemigos() {
		return this.enemigos;
	}

	CPantalla inicio = new CPantalla("inicio", new IPantallaB() {
		
		PImage fondo;
		
		@Override
		public void setup() {
			this.fondo = img.loadImage("img/inicio.png");
			
		}
		
		@Override
		public void settings() {
			
			
		}
		
		@Override
		public void mouseReleased() {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void mousePressed() {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void draw() {
			// TODO Auto-generated method stub
			
		}
	});

	CPantalla juego = new CPantalla("juego", new IPantalla() {

		private Nave personaje;
	
		private int mapY, map2Y;
		private PImage stage;
		int contador;
		public boolean isPlay = true;

		@Override
		public void setup() {

			new Thread((Nave) personaje).start();
		

			int r = (int) app.random(1, 4);
			personaje = new Nave(new PVector(app.width / 2, app.height - 100), r);
			Enemigo.r = r;

			switch (r) {
			case 1:
				stage = Img.loadImage("Amor.png");
				break;
			case 2:
				stage = Img.loadImage("Hogar.png");
				break;

			case 3:
				stage = Img.loadImage("Heroes.png");
				break;
			}

			for (int i = 0; i < 6; i++) {
				for (int j = 0; j < 3; j++) {
					Enemigo temp = new Enemigo(new PVector(170 * (i + 1), 50 - (120 * (j))));
					enemigos.add(temp);
					temp.start();
					contador = 0;
				}
			}
			mapY = app.height;
			mapY = mapY - (stage.height / 2);

		}

		@Override
		public void settings() {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseReleased() {
			// TODO Auto-generated method stub

		}

		@Override
		public void mousePressed() {
			// TODO Auto-generated method stub

		}

		@Override
		public void draw() {
				app.image(stage, app.width / 2, mapY - stage.height + 10);
				app.image(stage, app.width / 2, mapY);
				personaje.draw();
				for (int i = 0; i < enemigos.size(); i++) {
					enemigos.get(i).draw();
				}
			

			/*
			 * 
			 * 
			 */

			for (int i = 0; i < enemigos.size(); i++) {
				if (!enemigos.get(i).isIsalive()) {
					enemigos.remove(i);
					return;
				}
			}

			mapY += 5;
			map2Y += 5;

			if (mapY >= stage.height) {
				mapY = map2Y - (stage.height / 2);
			}

			if (map2Y >= stage.height) {
				map2Y = mapY - (stage.height / 2);
			}

			for (int i = 0; i < enemigos.size(); i++) {
				if (enemigos.get(i).getY() > app.height - 100) {
					isPlay = false;
					
					
					/*
					 * 
					 * 
					 * Siiguiente pantalla
					 */
				}
			}
		}

		@Override
		public void mouseMouseDraged() {
			// TODO Auto-generated method stub

		}

		@Override
		public void keyReleased() {
			this.personaje.keyboardReleased();
		}

		@Override
		public void keyPressed() {
			this.personaje.keyboardPressed();

		}

	});

}
