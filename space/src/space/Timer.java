package space;

import interfaz.Main;
import processing.core.PApplet;

public class Timer extends Thread {

	private boolean activo;
	private float time;
	private boolean iniciado;
	private boolean ejecucion;
	PApplet app;

	private float millisLast;

	public Timer() {
		this.app = Main.app;
		activo = true;
		iniciado = false;
	}

	@Override
	public void run() {
		millisLast = app.millis();
		while (activo) {
			try {
				if (ejecucion) {
					time = (app.millis() - millisLast) / 1000;
				}
				sleep(20);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public synchronized void start() {
		if (iniciado == false) {
			iniciado = true;
			super.start();
			ejecucion = true;
		}
	}

	public void iniciar() {
		ejecucion = true;
	}

	public void detener() {
		ejecucion = false;
	}

	public float getMillis() {
		return time;
	}
}
