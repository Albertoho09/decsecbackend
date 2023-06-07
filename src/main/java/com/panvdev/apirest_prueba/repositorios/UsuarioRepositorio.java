package com.panvdev.apirest_prueba.repositorios;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.panvdev.apirest_prueba.modelos.Usuario;

@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, Long> {
	@Query(value="SELECT u.codigo FROM usuario u WHERE u.correo = :correo AND u.contrasenia = :contrasenia", nativeQuery=true)
	Optional<Long> login(String correo, String contrasenia);
	
	@Query(value="SELECT * FROM usuario WHERE codigo IN (SELECT idreceptor FROM peticion WHERE idemisor = :id AND estado = 1)", nativeQuery=true)
	List<Usuario> amigos(Long id);
	
	@Transactional
	@Modifying
	@Query(value="update usuario set apellido= :apellido, contrasenia= :contrasenia, correo= :correo, fechanac= :fechanac, nick= :nick, nombre= :nombre where codigo= :codigo", nativeQuery=true)
	void actualizarUsuario(String apellido, String contrasenia, String correo, String fechanac, String nick, String nombre, long codigo);
}
