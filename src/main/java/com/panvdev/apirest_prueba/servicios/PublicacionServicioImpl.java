package com.panvdev.apirest_prueba.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.panvdev.apirest_prueba.modelos.Publicacion;
import com.panvdev.apirest_prueba.repositorios.PublicacionRepositorio;

@Service
public class PublicacionServicioImpl implements IPublicacionServicio{
	
	@Autowired
	PublicacionRepositorio publicacionrepositorio;
	
	@Override
	public List<Publicacion> obtenerTodo() {
		return publicacionrepositorio.findAll();

	}

	@Override
	public Publicacion guardar(Publicacion publicacion) {
		return publicacionrepositorio.save(publicacion);

	}

	@Override
	public Publicacion obtenerPorId(long id) {
		return publicacionrepositorio.findById(id).orElse(null);
	}

	@Override
	public void eliminar(long id) {
		publicacionrepositorio.deleteById(id);
		
	}

	@Override
	public void megusta(long id) {
		publicacionrepositorio.megusta(id);
		
	}

	@Override
	public void nomegusta(long id) {
		publicacionrepositorio.nomegusta(id);
	}

	@Override
	public List<Publicacion> obtenerpublicacionesusuario(long idusuario) {
		
		return publicacionrepositorio.publicacionesusuario(idusuario);
	}

	@Override
	public List<Publicacion> obtenerpublicacionesamigos(long idusuario) {
		return publicacionrepositorio.publicacionesamigos(idusuario);
	}
	
	

}
