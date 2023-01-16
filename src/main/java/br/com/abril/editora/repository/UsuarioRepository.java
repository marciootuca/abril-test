package br.com.abril.editora.repository;

import br.com.abril.editora.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>  {

	Optional<Usuario> findUsuarioByNome(String nome);

}