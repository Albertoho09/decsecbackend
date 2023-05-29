package com.panvdev.apirest_prueba.servicios;

import java.util.List;

import com.panvdev.apirest_prueba.modelos.Comentario;

public interface IComentarioServicio {
	public List<Comentario> obtenerTodo();
	
	public Comentario guardar(Comentario comentario);
	
	public Comentario obtenerPorId(long id);
	
	public void eliminar(long id);
	
	public List<Comentario> obtenerComentariosPublicacion(long id);
}
