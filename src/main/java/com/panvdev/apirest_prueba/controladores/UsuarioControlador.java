package com.panvdev.apirest_prueba.controladores;

import java.io.IOException;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.Gson;
import com.panvdev.apirest_prueba.modelos.Usuario;
import com.panvdev.apirest_prueba.servicios.UsuarioServicioImpl;

@RestController
@RequestMapping("/api/v1/usuario")
@CrossOrigin("*")
public class UsuarioControlador {

	@Autowired
	UsuarioServicioImpl usuarioservicio;

	@GetMapping("/all")
	public List<Usuario> obtenerUsuario() {
		return usuarioservicio.obtenerTodo();
	}

	@GetMapping("/login/{correo}/{contrasenia}")
	public long inicioSesion(@PathVariable String correo, @PathVariable String contrasenia) {
		return usuarioservicio.iniciarSesion(correo, contrasenia);
	}

	@PostMapping("/save")
	public ResponseEntity<?> guardarUsuario(@RequestPart("file") MultipartFile file, @RequestPart("data") String usuario) {
		
		byte[] imagenBytes;
		Usuario data;
		try {
			data = new Gson().fromJson(usuario, Usuario.class);
			imagenBytes = file.getBytes();
			data.setFotoperfil(imagenBytes);
			if (data.comprobarCampos()) {
				System.out.println("datos comprobados");
				usuarioservicio.guardar(data);
				return ResponseEntity.ok("Usuario creado exitosamente");
			}
			return ResponseEntity.ok("Usuario no creado");
		} catch (IOException e) {
			e.printStackTrace();
			return ResponseEntity.ok("Usuario no creado");
		}
	}
	

	@GetMapping("/obtener/{id}")
	public Usuario obtenerUsuarioId(@PathVariable long id) {
		return usuarioservicio.obtenerPorId(id);
	}

	@PostMapping("/actualizar")
	public ResponseEntity<?> actualizarUsuario(@RequestPart("data") String usuario) {
		Usuario data;
		data = new Gson().fromJson(usuario, Usuario.class);
		System.out.println(data.getFechanac());
		usuarioservicio.actualizarUsuario(data.getApellido(), data.getContrasenia(), data.getCorreo(), data.getFechanac(), data.getNick(), data.getNombre(), data.getCodigo());
		return ResponseEntity.ok("Usuario actualizado exitosamente");
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<HashMap<String, Boolean>> eliminarUsuario(@PathVariable long id) {
		this.usuarioservicio.eliminar(id);

		HashMap<String, Boolean> estadoUsuarioEliminado = new HashMap<>();
		estadoUsuarioEliminado.put("eliminado", true);
		return ResponseEntity.ok(estadoUsuarioEliminado);
	}

}
