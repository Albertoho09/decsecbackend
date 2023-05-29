package com.panvdev.apirest_prueba.repositorios;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.panvdev.apirest_prueba.modelos.Comentario;

@Repository
public interface ComentarioRepositorio extends JpaRepository<Comentario, Long>{
	
	@Query(value="SELECT * FROM comentario a WHERE a.idpublicacion = :idpublicacion", nativeQuery=true)
	Optional<List <Comentario>> obtenerComentariosPublicacion(Long idpublicacion);
}
