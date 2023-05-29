package com.panvdev.apirest_prueba.modelos;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonProperty;



@Entity
public class Comentario implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty("codigo")
	private long codigo;
	
	@JsonProperty("idpublicacion")
	private int idpublicacion;
	
	@JsonProperty("idusuario")
	private int idusuario;
	
	@JsonProperty("comentario")
    private String comentario;
	
	@JsonProperty("nickusuario")
    private String nickusuario;

	public Comentario() {
		
	}
	
	public String getNickusuario() {
		return nickusuario;
	}



	public void setNickusuario(String nickusuario) {
		this.nickusuario = nickusuario;
	}



	public long getCodigo() {
		return codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	public int getIdpublicacion() {
		return idpublicacion;
	}

	public void setIdpublicacion(int idpublicacion) {
		this.idpublicacion = idpublicacion;
	}

	public int getIdusuario() {
		return idusuario;
	}

	public void setIdusuario(int idusuario) {
		this.idusuario = idusuario;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}
