package br.com.abril.editora.exception;

import br.com.abril.editora.presenters.ErroResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Collections;

@RestControllerAdvice
public class ApiExceptionHandle extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ApiException.class)
    public ResponseEntity<ErroResponse> apiExceptionHandle(ApiException e, WebRequest request){
		ErroResponse error = ErroResponse.builder()
				.messages(e.getMsg())
				.statusCode(e.getStatusCode())
				.reason(e.getReason())
				.build();
		return ResponseEntity.status(HttpStatus.valueOf(e.getStatusCode())).body(error);
    }


	@Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
    		HttpHeaders headers, HttpStatus status, WebRequest request) {

    	ErroResponse error = ErroResponse.builder()
				.messages(ex.getBindingResult().getAllErrors().stream().map(ObjectError::getDefaultMessage).toList())
    			.statusCode(status.value())
    			.reason("Erro de validacao.")
    			.build();
    	
    	return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }
    
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> apiExceptionHandle(Exception e, WebRequest request){
    	ErroResponse error = ErroResponse.builder()
    			.messages(Collections.singletonList(e.getMessage()))
    			.statusCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
    			.reason(e.getStackTrace().toString())
    			.build();
    	return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
    }
}
