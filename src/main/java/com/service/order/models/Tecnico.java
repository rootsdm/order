package com.service.order.models;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Tecnico extends Pessoa{
    public Tecnico(){
        super();
    }
    public Tecnico(Long id, String nome, String cpf, String telefone) {
        super(id, nome, cpf, telefone);
    }


//    @OneToMany
//    @Column(name = "OsList")
//    private List<OrdemDeServico> ordemDeServicoList;

}
