package com.panvdev.apirest_prueba.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.panvdev.apirest_prueba.modelos.Comentario;
import com.panvdev.apirest_prueba.repositorios.ComentarioRepositorio;

@Service
public class ComentarioServicioImpl implements IComentarioServicio{
	
	@Autowired
	ComentarioRepositorio comentariorepositorio;
	
	@Override
	public List<Comentario> obtenerTodo() {
		return comentariorepositorio.findAll();
	}

	@Override
	public Comentario guardar(Comentario comentario) {
		return comentariorepositorio.save(comentario);
	}

	@Override
	public Comentario obtenerPorId(long id) {
		return comentariorepositorio.findById(id).orElse(null);
		
	}

	@Override
	public void eliminar(long id) {
		comentariorepositorio.deleteById(id);
	}

	@Override
	public List<Comentario> obtenerComentariosPublicacion(long id) {
		return comentariorepositorio.obtenerComentariosPublicacion(id).orElse(null);
	}

}
