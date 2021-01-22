package io.github.vagnereix.clientes.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.*;
import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data //cria construtores com e sem param, toString, hashCodeEquals, getters e setters auto
@Builder
@NoArgsConstructor //manter construtor vazio
@AllArgsConstructor //Lombok gera construtor com todos os argumentos
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 150)
    @NotEmpty(message = "{campo.nome.obrigatorio}")
    private String nome;

    @Column(nullable = false, length = 11)
    @NotEmpty(message = "{campo.cpf.obrigatorio}")
    @CPF(message = "{campo.cpf.invalido}")
    private String cpf;

    @Column(name = "data_cadastro", updatable = false)
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataCadastro;

    @PrePersist //antes de persistir essa entidade no BD esse método é executado
    public void prePersist(){
        setDataCadastro(LocalDate.now());
    }

}
