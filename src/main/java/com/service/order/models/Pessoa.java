package com.service.order.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "tbl_pessoa")
public abstract class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotBlank(message = "O campo Nome é Requerido")
    @Column(name = "nome")
    private String nome;

    @NotBlank(message = "O CPF Nome é Requerido")
    @Column(name = "cpf")
    private String cpf;

    @NotBlank(message = "O Telefone Nome é Requerido")
    @Column(name = "telefone")
    private String telefone;

}
