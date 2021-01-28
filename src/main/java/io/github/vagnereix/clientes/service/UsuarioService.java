package io.github.vagnereix.clientes.service;

import io.github.vagnereix.clientes.model.entity.Usuario;
import io.github.vagnereix.clientes.model.exception.UsuarioCadastradoException;
import io.github.vagnereix.clientes.model.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    //método usado para buscar Usuario no banco e passar dados para o SecurityConfig
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException ("Login não encontrado!"));
        return User
            .builder()
            .username(usuario.getUsername())
            .password(usuario.getPassword())
            .roles("USER")
            .build();
    }

    public Usuario salvar(Usuario usuario) {
        boolean exists = usuarioRepository.existsByUsername(usuario.getUsername());
        if(exists){
            throw new UsuarioCadastradoException(usuario.getUsername());
        }
        return usuarioRepository.save(usuario);
    }
}
