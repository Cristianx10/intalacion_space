package interfaz;

import java.util.ArrayList;

import pantalla.CPantalla;
import pantalla.IPantalla;
import pantalla.IPantallaB;
import pantalla.IPantallaC;
import pantalla.Img;
import pantalla.Pantalla;
import processing.core.PApplet;
import processing.core.PConstants;
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
		this.pantallas.add(ruleta);
		this.pantallas.add(juego);
		
		

		this.pantalla = new Pantalla(pantallas);

		app.imageMode(app.CENTER);
	}

	public void draw() {
			this.pantalla.draw();
	}

	public void mousePressed() {
		this.pantalla.mousePressed();
	}

	public void mouseReleased() {
		this.pantalla.mouseReleased();
	}

	public void keyPressed() {
		this.pantalla.keyPressed();
	
	}
	
	public void mouseDragged() {
		this.pantalla.mouseMouseDraged();
	}

	public void keyReleased() {
		this.pantalla.keyReleased();
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
			pantalla.next();
			
		}
		
		@Override
		public void draw() {
			app.imageMode(PConstants.CORNER);
			app.image(this.fondo, 0, 0);
			
		}
	});
	
	CPantalla ruleta = new CPantalla("ruleta", new IPantalla() {
		
		private PImage pantalla, boton,clic;
		private int x, y, contador, cuenta, cuentaT1, cuentaT2, contadorT1, contadorT2;
		private PImage[] logos;
		private String[] tiempo1, tiempo2;
		private boolean ruletaActivada;
		private int random1, random2, random3;
		
		@Override
		public void setup() {
			pantalla = app.loadImage("pantallas.png");
			clic = app.loadImage("clic.png");
			logos = new PImage[3];
			tiempo1 = new String[4];
			tiempo2 = new String[4];

			ruletaActivada = false;

			boton = app.loadImage("boton.png");
			logos[0] = app.loadImage("corazon.png");
			logos[1] = app.loadImage("pata.png");
			logos[2] = app.loadImage("super.png");

			tiempo1[0] = "0:40";
			tiempo1[1] = "1:00";
			tiempo1[2] = "1:20";
			tiempo1[3] = "1:40";

			tiempo2[0] = "0:25";
			tiempo2[1] = "0:35";
			tiempo2[2] = "0:45";
			tiempo2[3] = "1:00";

			random1 = (int) app.random(50, 150);
			random2 = (int) app.random(50, 150);
			random3 = (int) app.random(50, 150);
			y = 290;
			x = 1056;
			contador = 0;
			contadorT1 = 0;
			contadorT2 = 0;
			cuenta = 60;
			cuentaT1 = 60;
			cuentaT2 = 60;
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
		public void mouseMouseDraged() {
			// al arrastrar el cuadrito se mueve
			if (y > 280 && ruletaActivada == false && y < 540 && app.mouseX > x - boton.width / 2
					&& app.mouseX < x + boton.width / 2 && app.mouseY > y - boton.height / 2
					&& app.mouseY < y + boton.height / 2) {
				y = app.mouseY;

			}
	
		}
		
		@Override
		public void keyReleased() {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void keyPressed() {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void draw() {
			app.imageMode(app.CORNER);
			app.image(pantalla, 0, 0);
			app.imageMode(app.CENTER);

			app.image(boton, x, y);
			if (y >= 535) {
				ruletaActivada = true;
			}
			if (ruletaActivada == true) {
				// matematica y bla bla
				if(random1>0)random1--;
				if(random2>0)random2--;
				if(random3>0)random3--;
				cuenta -= random1;
				cuentaT1 -= random1;
				cuentaT2 -= random2;
				// sumarle a los contadores cuando la cuenta sea menor que 0
				if (cuenta <= 0) {
					contador++;
					cuenta = 60;
				}
				if (cuentaT1 <= 0) {
					contadorT1++;
					cuentaT1 = 60;
				}
				if (cuentaT2 <= 0) {
					contadorT2++;
					cuentaT2 = 60;
				}
				// condiciones para que los contadores vuelvan a 0
				if (contador > 2)
					contador = 0;
				if (contadorT1 > 3)
					contadorT1 = 0;
				if (contadorT2 > 3)
					contadorT2 = 0;

				// imagenes y textos manipulados por contador
				app.image(logos[contador], 333, 420);
				app.textAlign(app.CENTER);
				app.textSize(80);
				app.fill(0);
				app.text(tiempo1[contadorT1], 600, 440);
				app.text(tiempo2[contadorT2], 875, 440);

				if (random1 == 0 && random2 == 0 && random3 == 0) {
					app.image(clic, app.width/2, 650);
				}
			}
			
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
			
			int r = (int) app.random(1, 4);
			personaje = new Nave(new PVector(app.width / 2, app.height - 100), r);
			this.personaje.start();
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
