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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.panvdev.apirest_prueba.modelos.Comentario;
import com.panvdev.apirest_prueba.modelos.Peticion;
import com.panvdev.apirest_prueba.servicios.PeticionServicioImpl;

@RestController
@RequestMapping("/api/v1/peticion")
@CrossOrigin("*")
public class PeticionControlador {
	@Autowired
	PeticionServicioImpl peticionservicio;
	
	@GetMapping("/obtener/{id}")
	public List<Peticion> obtenerpeticionesusuario(@PathVariable long id) {
		return peticionservicio.peticionespendienteusuario(id);
	}
	
	@PostMapping("/actualizar/{id}/{estado}")
	public ResponseEntity<?> actualizarpeticion(@PathVariable long id, @PathVariable long estado) {
		peticionservicio.actualizarestado(id, estado);
		return ResponseEntity.ok("petición actualizada");
	}
	
	@PostMapping("/save")
	public ResponseEntity<?> guardarpeticion(@RequestBody Peticion peticion) {
		peticionservicio.guardar(peticion);
		return ResponseEntity.ok("petición guarda");
	}
	
	@GetMapping("/comprobar/{idemisor}/{idreceptor}/{estado}")
	public long comprobarPeticion(@PathVariable long idemisor, @PathVariable long idreceptor, @PathVariable long estado) {
		return peticionservicio.comprobarPeticion(idemisor, idreceptor, estado);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<HashMap<String, Boolean>> eliminarPeticion(@PathVariable long id) {
		this.peticionservicio.eliminar(id);

		HashMap<String, Boolean> estadoPeticionEliminado = new HashMap<>();
		estadoPeticionEliminado.put("eliminada", true);
		return ResponseEntity.ok(estadoPeticionEliminado);
	}
}
