package Servicios;

import java.io.Serializable;
import java.sql.Timestamp;

public class Provincia implements Serializable{
	private String nombre;

	
	public Provincia(){
	}
	
	public Provincia(String nombre, Timestamp created_at, Timestamp ipdate_at) {
		super();
		this.nombre = nombre;

	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
