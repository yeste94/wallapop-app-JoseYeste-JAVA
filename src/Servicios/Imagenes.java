package Servicios;

import java.io.Serializable;
import java.sql.Timestamp;

public class Imagenes implements Serializable{
	private int id;
	private String ruta;
	private Articulo articulo;
	
	
	public Imagenes(){
	}
	
	public Imagenes(int id, String ruta, Articulo articulo, Timestamp created_at, Timestamp update_at) {
		super();
		this.id = id;
		this.ruta = ruta;
		this.articulo = articulo;

	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRuta() {
		return ruta;
	}
	public void setRuta(String ruta) {
		this.ruta = ruta;
	}
	public Articulo getArticulo() {
		return articulo;
	}
	public void setArticulo(Articulo articulo) {
		this.articulo = articulo;
	}
}
