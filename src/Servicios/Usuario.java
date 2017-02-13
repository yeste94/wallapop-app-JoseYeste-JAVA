package Servicios;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


public class Usuario implements Serializable{
	
	private String mail;
	private String pass;
	private String nick;
	private String foto;

	
	public Usuario(){
		
	}
	public Usuario(String mail,String pass){
		this.mail=mail;
		this.pass=pass;
	}

	public Usuario(String mail, String pass, String nick, String foto, Timestamp created_at, Timestamp updated_at) {
		super();
		this.mail = mail;
		this.pass = pass;
		this.nick = nick;
		this.foto = foto;

	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	
}
