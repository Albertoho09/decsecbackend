package com.panvdev.apirest_prueba.servicios;

import java.util.List;
import java.util.Optional;

import com.panvdev.apirest_prueba.modelos.Usuario;

public interface IUsuarioServicio{

	public List<Usuario> obtenerTodo();
	
	public Usuario guardar(Usuario usuario);
	
	public Usuario obtenerPorId(long id);
	
	public void eliminar(long id);
	
	public long iniciarSesion(String correo, String contrasenia);
	
	public List<Usuario> obteneramigo(long id);
	
	public void actualizarUsuario(String apellido, String contrasenia, String correo, String fechanac, String nick, String nombre, long codigo);
}
