package Servicios;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;

public class Articulo implements Serializable{
	private int id;
	private String nombre;
	private String descripcion;
	private BigDecimal precio;
	private boolean envio;
	private boolean intercambio;
	private boolean negociable;
	private Timestamp venta;
	
	private Localidad localidad;
	private Usuario usuario;
	private SubCategoria subCategoria;
	

	
	public Articulo(){
		
	}



	public Articulo(int id, String nombre, String descripcion, BigDecimal precio, boolean envio, boolean intercambio,
			boolean negociable, Timestamp venta, Localidad localidad, Usuario usuario, SubCategoria subCategoria) {
		
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.envio = envio;
		this.intercambio = intercambio;
		this.negociable = negociable;
		this.venta = venta;
		this.localidad = localidad;
		this.usuario = usuario;
		this.subCategoria = subCategoria;
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



	public BigDecimal getPrecio() {
		return precio;
	}



	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}



	public boolean isEnvio() {
		return envio;
	}



	public void setEnvio(boolean envio) {
		this.envio = envio;
	}



	public boolean isIntercambio() {
		return intercambio;
	}



	public void setIntercambio(boolean intercambio) {
		this.intercambio = intercambio;
	}



	public boolean isNegociable() {
		return negociable;
	}



	public void setNegociable(boolean negociable) {
		this.negociable = negociable;
	}



	public Timestamp getVenta() {
		return venta;
	}



	public void setVenta(Timestamp venta) {
		this.venta = venta;
	}



	public Localidad getLocalidad() {
		return localidad;
	}



	public void setLocalidad(Localidad localidad) {
		this.localidad = localidad;
	}



	public Usuario getUsuario() {
		return usuario;
	}



	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}



	public SubCategoria getSubCategoria() {
		return subCategoria;
	}



	public void setSubCategoria(SubCategoria subCategoria) {
		this.subCategoria = subCategoria;
	}
	
}
