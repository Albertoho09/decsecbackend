package com.panvdev.apirest_prueba.servicios;

import java.util.List;
import java.util.Optional;

import com.panvdev.apirest_prueba.modelos.Peticion;

public interface IPeticionServicio {
	public List<Peticion> obtenerTodo();
	
	public Peticion guardar(Peticion comentario);
	
	public Optional<Peticion> obtenerPorId(long id);
	
	public void eliminar(long id);
	
	public void actualizarestado(long codigo, long estado);
	
	public List <Peticion> peticionespendienteusuario(Long idreceptor);
	
	public long comprobarPeticion(Long idemisor, Long idreceptor , Long estado);
}
