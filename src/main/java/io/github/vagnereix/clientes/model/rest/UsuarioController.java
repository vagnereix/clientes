package io.github.vagnereix.clientes.model.rest;

import io.github.vagnereix.clientes.model.entity.Usuario;
import io.github.vagnereix.clientes.model.exception.UsuarioCadastradoException;
import io.github.vagnereix.clientes.model.repository.UsuarioRepository;
import io.github.vagnereix.clientes.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void salvar(@RequestBody @Valid Usuario usuario){
        try {
            usuarioService.salvar(usuario);
        } catch (UsuarioCadastradoException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

}
