package Servicios;

import java.io.Serializable;
import java.sql.Timestamp;

public class Categoria implements Serializable{
	private int id;
	private String nombre;
	private String descripcion;
	
	
	public Categoria(){
	}

	public Categoria(int id, String nombre, String descripcion, Timestamp created_at, Timestamp update_at) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	
}
