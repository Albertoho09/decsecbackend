package com.panvdev.apirest_prueba.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.panvdev.apirest_prueba.modelos.Usuario;
import com.panvdev.apirest_prueba.repositorios.UsuarioRepositorio;

@Service
public class UsuarioServicioImpl implements IUsuarioServicio{
	
	@Autowired
	UsuarioRepositorio usuariorepositorio;

	@Override
	public List<Usuario> obtenerTodo() {
		return usuariorepositorio.findAll();
	}

	@Override
	public Usuario guardar(Usuario usuario) {
		return usuariorepositorio.save(usuario);
	}

	@Override
	public Usuario obtenerPorId(long id) {
		return usuariorepositorio.findById(id).orElse(null);
	}

	@Override
	public void eliminar(long id) {
		usuariorepositorio.deleteById(id);
		
	}

	@Override
	public long iniciarSesion(String correo, String contrasenia) {  
		return usuariorepositorio.login(correo, contrasenia).orElse(-1L);
	}

}
