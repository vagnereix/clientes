package io.github.vagnereix.clientes.model.exception;

public class UsuarioCadastradoException extends RuntimeException{
    public UsuarioCadastradoException(String login){
        super("Usuário " + login + " já existe em nosso sistema!");
    }
}
