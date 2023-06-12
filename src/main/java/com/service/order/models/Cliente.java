package com.service.order.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@Entity
public class Cliente extends Pessoa{

    public Cliente() {
        super();
    }
    public Cliente(Long id, String nome, String cpf, String telefone) {
        super(id, nome, cpf, telefone);
    }


//    @OneToMany
//    @Column(name = "OsList")
//    private List<OrdemDeServico> ordemDeServicoList;

}
