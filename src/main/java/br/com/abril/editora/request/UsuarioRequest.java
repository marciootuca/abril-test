package br.com.abril.editora.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioRequest {
	
	@NotBlank(message = "Favor digitar o nome do usuário")
	private String nome;
	
	@NotBlank(message = "Favor digitar a senha do usuário")
	private String senha;
	

}
