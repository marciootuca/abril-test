package br.com.abril.editora.utils;

import org.springframework.security.crypto.bcrypt.BCrypt;

public class AbrilUtils {

    public static String criptografarSenha(String senha){
        String salt = BCrypt.gensalt();
        return BCrypt.hashpw(senha, salt);
    }

    public static boolean validarSenha(String senhaCifrada, String senha) {
        return BCrypt.checkpw(senhaCifrada, senha);
    }
}
