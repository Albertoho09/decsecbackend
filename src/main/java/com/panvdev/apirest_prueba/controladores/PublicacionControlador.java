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
import com.panvdev.apirest_prueba.modelos.Publicacion;
import com.panvdev.apirest_prueba.modelos.Usuario;
import com.panvdev.apirest_prueba.servicios.PublicacionServicioImpl;

@RestController
@RequestMapping("/api/v1/publicacion")
@CrossOrigin("*")
public class PublicacionControlador {

	@Autowired
	PublicacionServicioImpl publicacionservicio;
	
	@GetMapping("/all")
	public List<Publicacion> obtenerpublicaciones() {
		return publicacionservicio.obtenerTodo();
	}	@PostMapping("/save")
	
	@GetMapping("/save")
	public ResponseEntity<?> guardarPublicacion(@RequestPart("file") MultipartFile file, @RequestPart("data") String publicacion) {
		
		System.out.println("Entro al metodo");
		byte[] imagenBytes = null;
		Publicacion data;
			data = new Gson().fromJson(publicacion, Publicacion.class);
			try {
				imagenBytes = file.getBytes();
			} catch (IOException e) {
				e.printStackTrace();
			}
			data.setFoto(imagenBytes);

				publicacionservicio.guardar(data);
				return ResponseEntity.ok("Usuario creado exitosamente");
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<HashMap<String, Boolean>> eliminarPublicacion(@PathVariable long id) {
		this.publicacionservicio.eliminar(id);

		HashMap<String, Boolean> estadoPublicacionEliminado = new HashMap<>();
		estadoPublicacionEliminado.put("eliminada", true);
		return ResponseEntity.ok(estadoPublicacionEliminado);
	}
	
}
