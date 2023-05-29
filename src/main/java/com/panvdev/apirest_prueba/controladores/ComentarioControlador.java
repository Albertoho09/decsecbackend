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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.panvdev.apirest_prueba.modelos.Comentario;
import com.panvdev.apirest_prueba.servicios.ComentarioServicioImpl;

@RestController
@RequestMapping("/api/v1/comentario")
@CrossOrigin("*")
public class ComentarioControlador {
	
	@Autowired
	ComentarioServicioImpl comentarioservicio;
	
	
	@GetMapping("/all")
	public List<Comentario> obtenercomentarios() {
		return comentarioservicio.obtenerTodo();
	}
	
	@GetMapping("/obtener/{id}")
	public List<Comentario> obtenercomentariospublicacion(@PathVariable long id) {
		return comentarioservicio.obtenerComentariosPublicacion(id);
	}
	
	
	@PostMapping("/save")
	public ResponseEntity<?> guardarComentario(@RequestBody Comentario comentario) {
		comentarioservicio.guardar(comentario);
		return ResponseEntity.ok("Comentario Creado");
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<HashMap<String, Boolean>> eliminarComentario(@PathVariable long id) {
		this.comentarioservicio.eliminar(id);
		HashMap<String, Boolean> estadoComentarioEliminado = new HashMap<>();
		estadoComentarioEliminado.put("eliminado", true);
		return ResponseEntity.ok(estadoComentarioEliminado);
	}
}
