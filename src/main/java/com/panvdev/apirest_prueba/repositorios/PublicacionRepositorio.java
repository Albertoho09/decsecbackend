package com.panvdev.apirest_prueba.repositorios;


import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.panvdev.apirest_prueba.modelos.Publicacion;


@Repository
public interface PublicacionRepositorio extends JpaRepository<Publicacion, Long> {
	
	
	@Query(value="SELECT * FROM publicacion WHERE idusuario = :idusuario ORDER BY codigo DESC", nativeQuery=true)
	List <Publicacion> publicacionesusuario(Long idusuario);
	
	@Query(value="SELECT * FROM publicacion WHERE idusuario IN (SELECT idreceptor FROM peticion WHERE estado = 1 and idemisor = :idusuario) ORDER BY codigo DESC", nativeQuery=true)
	List <Publicacion> publicacionesamigos(Long idusuario);
	
	@Transactional
	@Modifying
	@Query(value="UPDATE publicacion SET likes = likes + 1 WHERE codigo = :id", nativeQuery=true)
	void megusta(Long id);
	
	@Transactional
	@Modifying
	@Query(value="UPDATE publicacion SET likes = likes - 1 WHERE codigo = :id", nativeQuery=true)
	void nomegusta(Long id);

}
