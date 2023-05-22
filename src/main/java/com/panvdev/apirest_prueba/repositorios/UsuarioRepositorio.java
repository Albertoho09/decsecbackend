package com.panvdev.apirest_prueba.repositorios;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.panvdev.apirest_prueba.modelos.Usuario;

@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, Long> {
	@Query(value="SELECT u.codigo FROM usuario u WHERE u.correo = :correo AND u.contrasenia = :contrasenia", nativeQuery=true)
	Optional<Long> login(String correo, String contrasenia);
}
