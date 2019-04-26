package pantalla;

import java.util.ArrayList;
import interfaz.Main;
import processing.core.PApplet;

public class Pantalla implements IPantalla {

	private ArrayList<CPantalla> pantallas;
	private int nPantalla, nPopUp;
	private ArrayList<CPantalla> popUps;

	public Pantalla(ArrayList<CPantalla> pantallas) {
		this.pantallas = pantallas;
		popUps = new ArrayList<>();
		for (int i = 0; i < pantallas.size(); i++) {
			CPantalla p = pantallas.get(i);
			if (p.getPantalla() instanceof IPantalla) {
				IPantalla ip = (IPantalla) p.getPantalla();
				ip.settings();

			} else if (p.getPantalla() instanceof IPantallaB) {
				IPantallaB ip = (IPantallaB) p.getPantalla();
				ip.settings();

			}
		}
	}

	@Override
	public void setup() {
		// TODO Auto-generated method stub

	}

	public void draw() {
		if (pantallas.size() > 0 && nPantalla < pantallas.size() && nPantalla > -1 && pantallas.size() > 0) {
			CPantalla p = pantallas.get(nPantalla);
			drawAll(p);

		}

		if (popUps.size() > 0 && nPopUp < popUps.size() && nPopUp > -1 && popUps.size() > 0) {
			CPantalla p = popUps.get(nPopUp);

			drawAll(p);
		}

	}

	public void mousePressed() {
		if (pantallas.size() > 0 && nPantalla < pantallas.size() && nPantalla > -1 && pantallas.size() > 0) {
			CPantalla p = pantallas.get(nPantalla);

			if (popUps.size() > 0) {

			} else {
				mousePressedAll(p);
			}

		}

		if (popUps.size() > 0 && nPopUp < popUps.size() && nPopUp > -1 && popUps.size() > 0) {
			CPantalla p = popUps.get(nPopUp);

			mousePressedAll(p);

		}

	}

	public void mouseReleased() {
		if (pantallas.size() > 0 && nPantalla < pantallas.size() && nPantalla > -1 && pantallas.size() > 0) {
			CPantalla p = pantallas.get(nPantalla);
			if (popUps.size() > 0) {

			} else {
				mouseReleasedAll(p);
			}
		}

		if (popUps.size() > 0 && nPopUp < popUps.size() && nPopUp > -1 && popUps.size() > 0) {
			CPantalla p = popUps.get(nPopUp);
			mouseReleasedAll(p);
		}

	}

	@Override
	public void mouseMouseDraged() {
		if (pantallas.size() > 0 && nPantalla < pantallas.size() && nPantalla > -1 && pantallas.size() > 0) {
			CPantalla p = pantallas.get(nPantalla);
			if (p.getPantalla() instanceof IPantalla) {
				IPantalla ip = (IPantalla) p.getPantalla();

				ip.mouseMouseDraged();

			} else if (p.getPantalla() instanceof IPantallaB) {
				IPantallaB ip = (IPantallaB) p.getPantalla();

			}

		}
	}

	public void keyPressed() {
		if (pantallas.size() > 0 && nPantalla < pantallas.size() && nPantalla > -1 && pantallas.size() > 0) {
			CPantalla p = pantallas.get(nPantalla);
			if (p.getPantalla() instanceof IPantalla) {
				IPantalla ip = (IPantalla) p.getPantalla();
				ip.keyPressed();

			} else if (p.getPantalla() instanceof IPantallaB) {
				IPantallaB ip = (IPantallaB) p.getPantalla();

			}

		}

	}

	public void keyReleased() {
		if (pantallas.size() > 0 && nPantalla < pantallas.size() && nPantalla > -1 && pantallas.size() > 0) {
			CPantalla p = pantallas.get(nPantalla);
			if (p.getPantalla() instanceof IPantalla) {
				IPantalla ip = (IPantalla) p.getPantalla();

				ip.keyReleased();

			} else if (p.getPantalla() instanceof IPantallaB) {
				IPantallaB ip = (IPantallaB) p.getPantalla();

			}
		}

	}

	public void setPantalla(int i) {
		this.nPantalla = i;
	}

	public void setPantalla(String i) {
		for (int j = 0; j < pantallas.size(); j++) {
			if (pantallas.get(j).getId().equals(i)) {
				this.nPantalla = j;
				return;
			}
		}
	}

	public void addPopUp(CPantalla p) {
		this.popUps.add(p);
	}

	public void quitarPopUp() {
		this.popUps.remove(nPopUp);
	}

	public void next() {
		if (pantallas.size() > 0 && nPantalla + 1 < pantallas.size()) {
			this.nPantalla++;
		}
	}

	public void back() {
		if (pantallas.size() > 0 && nPantalla - 1 >= 0) {
			this.nPantalla--;
		}
	}

	@Override
	public void settings() {
		// TODO Auto-generated method stub

	}

	private void drawAll(CPantalla p) {

		p.setVisible(false);

		if (p.getPantalla() instanceof IPantalla) {
			IPantalla ip = (IPantalla) p.getPantalla();

			if (p.isEjecucion() == false) {
				ip.setup();
				p.setEjecucion(true);
			}
			p.setVisible(true);
			ip.draw();

		} else if (p.getPantalla() instanceof IPantallaB) {
			IPantallaB ip = (IPantallaB) p.getPantalla();

			if (p.isEjecucion() == false) {
				ip.setup();
				p.setEjecucion(true);
			}
			p.setVisible(true);
			ip.draw();

		} else if (p.getPantalla() instanceof IPantallaC) {
			IPantallaC ip = (IPantallaC) p.getPantalla();

			if (p.isEjecucion() == false) {
				p.setEjecucion(true);
			}
			p.setVisible(true);
			ip.draw();

		}
	}

	private void mousePressedAll(CPantalla p) {
		if (p.getPantalla() instanceof IPantalla) {
			IPantalla ip = (IPantalla) p.getPantalla();
			ip.mousePressed();

		} else if (p.getPantalla() instanceof IPantallaB) {
			IPantallaB ip = (IPantallaB) p.getPantalla();
			ip.mousePressed();
		}
	}

	private void mouseReleasedAll(CPantalla p) {
		if (p.getPantalla() instanceof IPantalla) {
			IPantalla ip = (IPantalla) p.getPantalla();

			ip.mouseReleased();

		} else if (p.getPantalla() instanceof IPantallaB) {
			IPantallaB ip = (IPantallaB) p.getPantalla();
			ip.mouseReleased();

		}
	}

}
