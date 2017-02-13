package Servicios;

import java.io.Serializable;
import java.sql.Timestamp;

public class Localidad implements Serializable{
	
	private String nombre;
	private Provincia provincia;
	
	public Localidad(){
	}

	public Localidad(String nombre, Provincia provincia, Timestamp created_at, Timestamp update_at) {
		super();
		this.nombre = nombre;
		this.provincia = provincia;

	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Provincia getProvincia() {
		return provincia;
	}

	public void setProvincia(Provincia provincia) {
		this.provincia = provincia;
	}

	
}
