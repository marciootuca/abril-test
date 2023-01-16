package br.com.abril.editora.service;

import br.com.abril.editora.domain.Usuario;
import br.com.abril.editora.exception.ApiException;
import br.com.abril.editora.presenters.UsuarioResponse;
import br.com.abril.editora.repository.UsuarioRepository;
import br.com.abril.editora.request.UsuarioRequest;
import br.com.abril.editora.utils.AbrilUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	public void validate(UsuarioRequest request) throws ApiException {
		Usuario usuario = usuarioRepository.findUsuarioByNome(request.getNome())
				.orElseThrow(() -> ApiException.notFound("Usuario não cadastrado", "Erro na validação do usuário"));

		if(!AbrilUtils.validarSenha(request.getSenha(), usuario.getSenha())){
			throw ApiException.unauthorized("Usuario não autorizado no sistema", "Usuario não autorizado");
		}

	}
	
	public List<UsuarioResponse> save(List<UsuarioRequest> users) {

		return getUsuarios(users).stream()
				.map(user-> UsuarioResponse
						.builder()
						.id(user.getId())
						.nome(user.getNome())
						.build())
				.collect(Collectors.toList());
		
	}

	private  List<Usuario> getUsuarios(List<UsuarioRequest> users) {
		List<Usuario> usuarios = usuarioRepository.saveAll(users
				.stream()
				.map(user-> Usuario
						.builder()
						.nome(user.getNome())
						.senha(AbrilUtils.criptografarSenha(user.getSenha()))
						.build())
				.toList());
		return usuarios;
	}

}
