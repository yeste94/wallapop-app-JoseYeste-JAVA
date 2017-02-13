package Servicios;

import java.io.Serializable;
import java.sql.Timestamp;

public class SubCategoria implements Serializable{
	private int id;
	private String nombre;
	private String descripcion;
	private Categoria categoria;

	
	
	public SubCategoria(){
		
	}



	public SubCategoria(int id, String nombre, String descripcion, Categoria categoria) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.categoria = categoria;
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



	public Categoria getCategoria() {
		return categoria;
	}



	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

}
