package com.panvdev.apirest_prueba.controladores;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.Gson;
import com.panvdev.apirest_prueba.modelos.Publicacion;
import com.panvdev.apirest_prueba.modelos.Usuario;
import com.panvdev.apirest_prueba.servicios.PublicacionServicioImpl;
import com.panvdev.apirest_prueba.servicios.UsuarioServicioImpl;

@RestController
@RequestMapping("/api/v1/publicacion")
@CrossOrigin("*")
public class PublicacionControlador {

	@Autowired
	PublicacionServicioImpl publicacionservicio;
	
	@GetMapping("/all")
	public List<Publicacion> obtenerpublicaciones() {
		return publicacionservicio.obtenerTodo();
	}
	
	@GetMapping("/obtener/{idusuario}")
	public List<Publicacion> obtenerpublicacionesusuario(@PathVariable long idusuario) {
		return publicacionservicio.obtenerpublicacionesusuario(idusuario);
	}
	
	@GetMapping("/publicacionesamigos/{idusuario}")
	public List<Publicacion> obtenerpublicacionesamigos(@PathVariable long idusuario) {
		return publicacionservicio.obtenerpublicacionesamigos(idusuario);
	}
	
	@PostMapping("/save")
	public ResponseEntity<?> guardarPublicacion(@RequestPart("file") MultipartFile file, @RequestPart("data") String publicacion ) {
		
		byte[] imagenBytes;
		Publicacion data;
		try {
			data = new Gson().fromJson(publicacion, Publicacion.class);
			imagenBytes = file.getBytes();
			data.setFoto(imagenBytes);
			publicacionservicio.guardar(data);
			return ResponseEntity.ok("publicacion creada");
		} catch (IOException e) {
			e.printStackTrace();
			return ResponseEntity.ok("publicacion no creada");
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<HashMap<String, Boolean>> eliminarPublicacion(@PathVariable long id) {
		this.publicacionservicio.eliminar(id);

		HashMap<String, Boolean> estadoPublicacionEliminado = new HashMap<>();
		estadoPublicacionEliminado.put("eliminada", true);
		return ResponseEntity.ok(estadoPublicacionEliminado);
	}
	
	@PutMapping("/megusta/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void megusta(@PathVariable long id) {
		this.publicacionservicio.megusta(id);
	}
	
	
	@PutMapping("/nomegusta/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void nomegusta(@PathVariable long id) {
		this.publicacionservicio.nomegusta(id);
	}
	
	
}
