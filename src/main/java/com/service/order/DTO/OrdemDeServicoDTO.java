package com.service.order.DTO;

import com.service.order.eNum.PrioridadeOs;
import com.service.order.eNum.StatusOs;
import com.service.order.models.Cliente;
import com.service.order.models.OrdemDeServico;
import com.service.order.models.Tecnico;
import lombok.Data;

import java.util.Calendar;

@Data
public class OrdemDeServicoDTO {

    private Long id;

    private Calendar dataAbertura;

    private Calendar dataFechamento;

    private StatusOs statusOs;

    private PrioridadeOs prioridadeOs;

    private String observacao;

    private Cliente cliente;

    private Tecnico tecnico;

    public OrdemDeServicoDTO(){

    }
    public OrdemDeServicoDTO(OrdemDeServico ordemDeServico) {
        this.id = ordemDeServico.getId();
        this.statusOs = ordemDeServico.getStatusOs();
        this.prioridadeOs = ordemDeServico.getPrioridadeOs();
        this.observacao = ordemDeServico.getObservacao();
        this.cliente = ordemDeServico.getCliente();
        this.tecnico = ordemDeServico.getTecnico();
    }


}
