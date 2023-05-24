package com.panvdev.apirest_prueba.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.panvdev.apirest_prueba.modelos.Publicacion;


@Repository
public interface PublicacionRepositorio extends JpaRepository<Publicacion, Long> {

}
