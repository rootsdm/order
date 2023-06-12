package com.service.order.DTO;

import com.service.order.models.Cliente;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ClienteDTO {

    private Long id;
    @NotBlank(message = "O Campo Nome é Requerido!")
    private String nome;

    @NotBlank(message = "O Campo CPF é Requerido!")
    private String cpf;

    @NotBlank(message = "O Campo Telefone é Requerido!")
    private String telefone;


    public ClienteDTO() {
    }

    public ClienteDTO(Cliente cliente){
        this.id = cliente.getId();
        this.nome = cliente.getNome();
        this.cpf = cliente.getCpf();
        this.telefone = cliente.getTelefone();
    }
}
