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
public class Publicacion implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty("codigo")
	private long codigo;
	
	@JsonProperty("comentario")
    private String comentario;
	
    @Lob
    @JsonProperty("foto")
    private byte[] foto;
    
    @JsonProperty("likes")
    private int likes;
    
    @JsonProperty("ncomentarios")
    private int ncomentarios;
    
    @JsonProperty("idusuario")
    private int idusuario;

    public Publicacion() {
		
	}
    
	public long getCodigo() {
		return codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public byte[] getFoto() {
		return foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}

	public int getLikes() {
		return likes;
	}

	public void setLikes(int likes) {
		this.likes = likes;
	}

	public int getNcomentarios() {
		return ncomentarios;
	}

	public void setNcomentarios(int ncomentarios) {
		this.ncomentarios = ncomentarios;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
    
}
