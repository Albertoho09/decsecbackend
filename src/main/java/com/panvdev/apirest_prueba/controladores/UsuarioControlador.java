package com.panvdev.apirest_prueba.controladores;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.panvdev.apirest_prueba.modelos.Usuario;
import com.panvdev.apirest_prueba.servicios.UsuarioServicioImpl;

@RestController
@RequestMapping("/api/v1/usuario")
@CrossOrigin("*")
public class UsuarioControlador {
	
	@Autowired
	UsuarioServicioImpl usuarioservicio;
	
	
	@GetMapping("/all")
	public List<Usuario> obtenerUsuario(){
		return usuarioservicio.obtenerTodo();
	}
	
	@GetMapping("/login/{correo}/{contrasenia}")
	public long inicioSesion(@PathVariable String correo, @PathVariable String contrasenia){
		return usuarioservicio.iniciarSesion(correo, contrasenia);
	}
	
	
	@PostMapping("/save")
	public ResponseEntity<Usuario> guardarUsuario(@RequestBody Usuario usuario){
		Usuario nuevo_usuario = usuarioservicio.guardar(usuario);
		return new ResponseEntity<>(nuevo_usuario, HttpStatus.CREATED);
	}
	
	@GetMapping("/obtener/{id}")
	public ResponseEntity<Usuario> obtenerUsuarioId(@PathVariable long id){
		Usuario usuarioPorId = usuarioservicio.obtenerPorId(id);
		return ResponseEntity.ok(usuarioPorId);
	}
	
	@PutMapping("/actualizar/{id}")
	public ResponseEntity<Usuario> actualizarUsuario(@PathVariable long id, @RequestBody Usuario usuario){
		Usuario usuarioPorId = usuarioservicio.obtenerPorId(id);
		usuarioPorId.setNombre(usuario.getNombre());
		usuarioPorId.setApellido(usuario.getApellido());
		usuarioPorId.setCorreo(usuario.getCorreo());
		
		Usuario usuario_actualizado = usuarioservicio.guardar(usuarioPorId);
		return new ResponseEntity<>(usuario_actualizado, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<HashMap<String,Boolean>> eliminarUsuario(@PathVariable long id){
		this.usuarioservicio.eliminar(id);
		
		HashMap<String, Boolean> estadoUsuarioEliminado = new HashMap<>();
		estadoUsuarioEliminado.put("eliminado", true);
		return ResponseEntity.ok(estadoUsuarioEliminado);
	}
	
	
}
