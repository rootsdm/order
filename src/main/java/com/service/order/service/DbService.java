package com.service.order.service;

import com.service.order.eNum.PrioridadeOs;
import com.service.order.eNum.StatusOs;
import com.service.order.models.Cliente;
import com.service.order.models.OrdemDeServico;
import com.service.order.models.Tecnico;
import com.service.order.repository.OrdemDeServicoRepository;
import com.service.order.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.Calendar;

@Service
public class DbService {
    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private OrdemDeServicoRepository ordemDeServicoRepository;

    public void instaciaDB() {
        Cliente cli1 = new Cliente(null, "sergio", "03917493403", "81994404605");

        Tecnico tec1 = new Tecnico(null, "paulo", "1234567", "87897878979");
        pessoaRepository.saveAll(Arrays.asList(cli1, tec1));

        OrdemDeServico os1 = new OrdemDeServico(null, Calendar.getInstance(), Calendar.getInstance(), StatusOs.ABERTA, PrioridadeOs.BAIXA, "teste add OS", cli1, tec1);
        ordemDeServicoRepository.saveAll(Arrays.asList(os1));
    }
}




