package br.com.abril.editora.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AssinaturaRequest {

	private Long produtoId;
	private String cep;

}
