package com.panvdev.apirest_prueba.modelos;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty("codigo")
	private long codigo;
	@JsonProperty("nick")
    private String nick;
	@JsonProperty("correo")
    private String correo;
	@JsonProperty("contrasenia")
    private String contrasenia;
	@JsonProperty("nombre")
    private String nombre;
	@JsonProperty("apellido")
    private String apellido;
	@JsonProperty("fechanac")
    private String fechanac;
	@JsonProperty("namigos")
    private int namigos;
    
    @Lob
    @JsonProperty("fotoperfil")
    private byte[] fotoperfil;
    @JsonProperty("npublicaciones")
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



	public String getFechanac() {
		return fechanac;
	}



	public void setFechanac(String string) {
		this.fechanac = string;
	}



	public int getNamigos() {
		return namigos;
	}



	public void setNamigos(int namigos) {
		this.namigos = namigos;
	}



	public byte[] getFotoperfil() {
		return fotoperfil;
	}



	public void setFotoperfil(byte[] fotoperfil) {
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
	
	public boolean comprobarCampos() {
		if(this.apellido.length() > 0 && this.nombre.length() > 0 && 
				this.correo.length() > 0 && this.contrasenia.length() > 0 && 
				this.fechanac.length() > 0 && this.nick.length() > 0 && this.fotoperfil.length > 0) {
			return true;
		}
		return false;
	}
	
}
