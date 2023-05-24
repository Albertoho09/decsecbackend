package com.panvdev.apirest_prueba.servicios;

import java.util.List;

import com.panvdev.apirest_prueba.modelos.Publicacion;


public interface IPublicacionServicio {

	public List<Publicacion> obtenerTodo();
	
	public Publicacion guardar(Publicacion publicacion);
	
	public Publicacion obtenerPorId(long id);
	
	public void eliminar(long id);
}
