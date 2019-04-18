package pantalla;

public class CPantalla{
	
	private boolean ejecucion;
	private Object pantalla;
	private String id;
	private boolean visible;
	
	
	public CPantalla( String id, IPantalla p) {
		this.pantalla = p;
		this.id = id;
		visible = false;
	}
	
	public CPantalla(String id, IPantallaB p) {
		this.pantalla = p;
		this.id = id;
		visible = false;
	}

	
	public CPantalla(String id, IPantallaC p) {
		this.pantalla = p;
		this.id = id;
		visible = false;
	}

	
	public Object getPantalla() {
		return pantalla;
	}

	public void setPantalla(Object pantalla) {
		this.pantalla = pantalla;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public boolean isEjecucion() {
		return ejecucion;
	}

	public void setEjecucion(boolean ejecucion) {
		this.ejecucion = ejecucion;
	}

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}
	
	
	
	
	
}