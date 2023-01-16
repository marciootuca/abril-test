package br.com.abril.editora.presenters;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ErroResponse {
	private List<String> messages;
	private Integer statusCode;
	private String reason;
}
