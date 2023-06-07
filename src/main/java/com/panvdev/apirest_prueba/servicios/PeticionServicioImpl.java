package com.panvdev.apirest_prueba.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.panvdev.apirest_prueba.modelos.Peticion;
import com.panvdev.apirest_prueba.repositorios.PeticionRepositorio;

@Service
public class PeticionServicioImpl implements IPeticionServicio{
	
	@Autowired
	PeticionRepositorio peticionrepositorio;

	@Override
	public List<Peticion> obtenerTodo() {
		
		return peticionrepositorio.findAll();
	}

	@Override
	public Peticion guardar(Peticion peticion) {
		return peticionrepositorio.save(peticion);
	}

	@Override
	public Optional<Peticion> obtenerPorId(long id) {
		return peticionrepositorio.findById(id);
	}

	@Override
	public void eliminar(long id) {
		peticionrepositorio.deleteById(id);
	}

	@Override
	public List<Peticion> peticionespendienteusuario(Long idreceptor) {
		
		return peticionrepositorio.peticionespendienteusuario(idreceptor);
	}

	@Override
	public void actualizarestado(long codigo, long estado) {
		peticionrepositorio.actualizarestado(codigo, estado);
		
	}

	@Override
	public long comprobarPeticion(Long idemisor, Long idreceptor, Long estado) {
		return peticionrepositorio.comprobarpeticion(idemisor, idreceptor, estado);
	}

}
