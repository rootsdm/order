package com.service.order.models;

import com.service.order.eNum.PrioridadeOs;
import com.service.order.eNum.StatusOs;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.Calendar;
@Entity
@Table(name = "tbl_ordemDeServico")
public class OrdemDeServico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "dtAbertura")
    private Calendar dataAbertura;

    @Column(name = "dtFechamento")
    private Calendar dataFechamento;

    @Column(name = "status")
    private StatusOs statusOs;

    @Column(name = "prioridade")
    private PrioridadeOs prioridadeOs;


    @NotBlank(message = "O Observação Nome é Requerido")
    @Column(name = "observacao")
    private String observacao;

    @ManyToOne
    @JoinColumn(name = "cliente_ID")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "tecnico_ID")
    private Tecnico tecnico;


    public OrdemDeServico(){

    }

    public OrdemDeServico(Long id, Calendar dataAbertura, Calendar dataFechamento, StatusOs statusOs, PrioridadeOs prioridadeOs, String observacao, Cliente cliente, Tecnico tecnico) {
        this.id = id;
        this.dataAbertura = dataAbertura;
        this.dataFechamento = dataFechamento;
        this.statusOs = statusOs;
        this.prioridadeOs = prioridadeOs;
        this.observacao = observacao;
        this.cliente = cliente;
        this.tecnico = tecnico;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Calendar getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(Calendar dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public Calendar getDataFechamento() {
        return dataFechamento;
    }

    public void setDataFechamento(Calendar dataFechamento) {
        this.dataFechamento = dataFechamento;
    }

    public StatusOs getStatusOs() {
        return statusOs;
    }

    public void setStatusOs(StatusOs statusOs) {
        this.statusOs = statusOs;
    }

    public PrioridadeOs getPrioridadeOs() {
        return prioridadeOs;
    }

    public void setPrioridadeOs(PrioridadeOs prioridadeOs) {
        this.prioridadeOs = prioridadeOs;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Tecnico getTecnico() {
        return tecnico;
    }

    public void setTecnico(Tecnico tecnico) {
        this.tecnico = tecnico;
    }
//    public OrdemDeServico(Long id, StatusOs statusOs, PrioridadeOs prioridadeOs, String observacao, Cliente cliente, Tecnico tecnico) {
//        this.id = id;
//        this.dataAbertura = dataAbertura.setDataAbertura(Calendar.getInstance());
//        //this.dataFechamento = dataFechamento;
//        this.statusOs = StatusOs.toEnum(statusOs == null) ? 0 : statusOs.getCod();
//        this.prioridadeOs = (prioridadeOs == null) ? 0 : prioridadeOs.getCod();
//        this.observacao = observacao;
//        this.cliente = cliente;
//        this.tecnico = tecnico;
//    }


}
