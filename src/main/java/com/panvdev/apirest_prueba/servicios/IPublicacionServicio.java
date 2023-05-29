package com.panvdev.apirest_prueba.servicios;

import java.util.List;
import java.util.Optional;

import com.panvdev.apirest_prueba.modelos.Publicacion;


public interface IPublicacionServicio {

	public List<Publicacion> obtenerTodo();
	
	public Publicacion guardar(Publicacion publicacion);
	
	public Publicacion obtenerPorId(long id);
	
	public void eliminar(long id);
	
	public void megusta(long id);
	
	public void nomegusta(long id);
	
	public List<Publicacion> obtenerpublicacionesusuario(long idusuario);
}
