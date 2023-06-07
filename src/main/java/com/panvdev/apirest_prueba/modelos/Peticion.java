package com.panvdev.apirest_prueba.modelos;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Peticion implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty("codigo")
	private long codigo;
	
	@JsonProperty("idemisor")
    private String idemisor;
	
	@JsonProperty("idreceptor")
    private String idreceptor;
	
	@JsonProperty("estado")
	private int estado;
	
	
	public Peticion() {
		
	}


	public long getCodigo() {
		return codigo;
	}


	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}


	public String getIdemisor() {
		return idemisor;
	}


	public void setIdemisor(String idemisor) {
		this.idemisor = idemisor;
	}


	public String getIdreceptor() {
		return idreceptor;
	}


	public void setIdreceptor(String idreceptor) {
		this.idreceptor = idreceptor;
	}


	public int getEstado() {
		return estado;
	}


	public void setEstado(int estado) {
		this.estado = estado;
	}
	
	
}
