package br.com.abril.editora.exception;

import lombok.Builder;
import lombok.Getter;
import lombok.Singular;
import lombok.ToString;
import org.springframework.http.HttpStatus;

import java.util.List;

@Getter
@ToString
public class ApiException extends Exception {

    private List<String> msg;
    private Integer statusCode;
    private String reason;

    @Builder
    public ApiException(Integer statusCode, List<String> message, String reason){
        this.statusCode = statusCode;
        this. msg = message;
        this.reason = reason;
    }

    public static ApiException badRequest(String message, String reason){
        return new ApiException(HttpStatus.BAD_REQUEST.value(), List.of(message), reason);
    }

    public static ApiException notFound(String message, String reason){
        return new ApiException(HttpStatus.NOT_FOUND.value(), List.of(message), reason);
    }

    public static ApiException internal(String message, String reason){
        return new ApiException(HttpStatus.INTERNAL_SERVER_ERROR.value(), List.of(message), reason);
    }

    public static ApiException unauthorized(String message, String reason){
        return new ApiException(HttpStatus.UNAUTHORIZED.value(), List.of(message), reason);
    }

}
