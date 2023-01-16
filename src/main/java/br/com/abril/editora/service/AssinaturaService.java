package br.com.abril.editora.service;

import br.com.abril.editora.domain.Pessoa;
import br.com.abril.editora.repository.PessoaRepository;
import br.com.abril.editora.request.AssinaturaRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AssinaturaService {
	
	private final PessoaRepository pessoaRepository;

	public List<Pessoa> find(AssinaturaRequest request){
		return pessoaRepository.findPessoaByCepAndProduto(request.getCep(), request.getProdutoId());
	}
}
