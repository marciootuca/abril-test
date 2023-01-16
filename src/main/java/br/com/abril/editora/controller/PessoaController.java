package br.com.abril.editora.controller;

import br.com.abril.editora.domain.Pessoa;
import br.com.abril.editora.request.AssinaturaRequest;
import br.com.abril.editora.service.AssinaturaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/pessoa")
@RequiredArgsConstructor
public class PessoaController {

	private final AssinaturaService assinaturaService;
    
	@GetMapping
    public ResponseEntity<List<Pessoa>> find(AssinaturaRequest request) {
    	List<Pessoa> signatures = assinaturaService.find(request);
    	return ResponseEntity.ok(signatures);
    }
    
    
}
