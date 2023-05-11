package com.panvdev.apirest_prueba.modelos;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long codigo;
	
    private String nick;
    private String correo;
    private String contrasenia;
    private String nombre;
    private String apellido;
    private Date fechanac;
    private int namigos;
    private String fotoperfil;
    private int npublicaciones;
	
	public Usuario() {
	}

	public long getId() {
		return codigo;
	}

	public void setId(long id) {
		this.codigo = id;
	}



	public String getNick() {
		return nick;
	}



	public void setNick(String nick) {
		this.nick = nick;
	}



	public String getCorreo() {
		return correo;
	}



	public void setCorreo(String correo) {
		this.correo = correo;
	}



	public String getContrasenia() {
		return contrasenia;
	}



	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public String getApellido() {
		return apellido;
	}



	public void setApellido(String apellido) {
		this.apellido = apellido;
	}



	public Date getFechanac() {
		return fechanac;
	}



	public void setFechanac(Date fechanac) {
		this.fechanac = fechanac;
	}



	public int getNamigos() {
		return namigos;
	}



	public void setNamigos(int namigos) {
		this.namigos = namigos;
	}



	public String getFotoperfil() {
		return fotoperfil;
	}



	public void setFotoperfil(String fotoperfil) {
		this.fotoperfil = fotoperfil;
	}



	public int getNpublicaciones() {
		return npublicaciones;
	}



	public void setNpublicaciones(int npublicaciones) {
		this.npublicaciones = npublicaciones;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
