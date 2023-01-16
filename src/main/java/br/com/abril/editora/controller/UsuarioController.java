package br.com.abril.editora.controller;

import br.com.abril.editora.exception.ApiException;
import br.com.abril.editora.presenters.UsuarioResponse;
import br.com.abril.editora.request.UsuarioRequest;
import br.com.abril.editora.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/usuario")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;

    @PostMapping("/validar")
    public ResponseEntity<Void> validate(@RequestBody UsuarioRequest request) throws ApiException {
        usuarioService.validate(request);
        return ResponseEntity.ok().build();
    }

    @PostMapping
    public ResponseEntity<List<UsuarioResponse>> save(@RequestBody @Valid List<UsuarioRequest> request) {
        List<UsuarioResponse> users = usuarioService.save(request);
        return ResponseEntity.ok(users);
    }
}
