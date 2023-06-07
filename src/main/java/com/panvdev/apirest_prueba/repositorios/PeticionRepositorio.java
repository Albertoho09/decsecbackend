package com.panvdev.apirest_prueba.repositorios;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.panvdev.apirest_prueba.modelos.Peticion;

public interface PeticionRepositorio extends JpaRepository<Peticion, Long> {

	@Query(value="SELECT * from peticion where idreceptor = :idreceptor and estado = 0", nativeQuery=true)
	List <Peticion> peticionespendienteusuario(Long idreceptor);
	
	@Query(value="SELECT COUNT(*) from peticion where idreceptor = :idreceptor and idemisor = :idemisor and estado = :estado", nativeQuery=true)
	Long comprobarpeticion(Long idemisor, Long idreceptor , Long estado);
	
	@Transactional
	@Modifying
	@Query(value="UPDATE peticion set estado = :estado where codigo = :codigo", nativeQuery=true)
	void actualizarestado(Long codigo, Long estado);
}
