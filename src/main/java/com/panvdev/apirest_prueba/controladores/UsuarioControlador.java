package com.panvdev.apirest_prueba.controladores;

import java.io.IOException;
import java.util.Date;
import java.text.SimpleDateFormat;

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
import org.springframework.web.bind.annotation.RequestParam;
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
		
		System.out.println("Entro al metodo");
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
			System.out.println("datos malos");
			return ResponseEntity.ok("Usuario no creado");
		} catch (IOException e) {
			System.out.println("Algo salio mal");
			e.printStackTrace();
			return ResponseEntity.ok("Usuario no creado");
		}
	}

	@GetMapping("/obtener/{id}")
	public Usuario obtenerUsuarioId(@PathVariable long id) {
		return usuarioservicio.obtenerPorId(id);
	}

	@PutMapping("/actualizar/{id}")
	public ResponseEntity<Usuario> actualizarUsuario(@PathVariable long id, @RequestBody Usuario usuario) {
		Usuario usuarioPorId = usuarioservicio.obtenerPorId(id);
		usuarioPorId.setNombre(usuario.getNombre());
		usuarioPorId.setApellido(usuario.getApellido());
		usuarioPorId.setCorreo(usuario.getCorreo());

		Usuario usuario_actualizado = usuarioservicio.guardar(usuarioPorId);
		return new ResponseEntity<>(usuario_actualizado, HttpStatus.CREATED);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<HashMap<String, Boolean>> eliminarUsuario(@PathVariable long id) {
		this.usuarioservicio.eliminar(id);

		HashMap<String, Boolean> estadoUsuarioEliminado = new HashMap<>();
		estadoUsuarioEliminado.put("eliminado", true);
		return ResponseEntity.ok(estadoUsuarioEliminado);
	}

}
