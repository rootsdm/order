package com.service.order.DTO;

import com.service.order.models.Tecnico;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class TecnicoDTO {

    private Long id;

    @NotBlank(message = "O Campo Nome é Requerido!")
    private String nome;

    @NotBlank(message = "O Campo CPF é Requerido!")
    private String cpf;

    @NotBlank(message = "O Campo Telefone é Requerido!")
    private String telefone;

    public TecnicoDTO(){

    }

    public TecnicoDTO(Tecnico tecnico) {
        this.id = tecnico.getId();
        this.nome = tecnico.getNome();
        this.cpf = tecnico.getCpf();
        this.telefone = tecnico.getTelefone();

    }
}
