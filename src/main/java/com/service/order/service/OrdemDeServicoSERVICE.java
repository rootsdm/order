package com.service.order.service;

import com.service.order.DTO.OrdemDeServicoDTO;
import com.service.order.exception.ObjectNotfoundException;
import com.service.order.models.OrdemDeServico;
import com.service.order.repository.OrdemDeServicoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrdemDeServicoSERVICE {

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private OrdemDeServicoRepository ordemDeServicoRepository;

    public List<OrdemDeServico> findAll() {
        return ordemDeServicoRepository.findAll();
    }

    public OrdemDeServico findById(Long id) {
        Optional<OrdemDeServico> ordemDeServico = ordemDeServicoRepository.findById(id);
        return ordemDeServico.orElseThrow(() -> new ObjectNotfoundException("ERRO: OS Nao localizada"));
    }

    public OrdemDeServico save(OrdemDeServicoDTO ordemDeServicoDTO) {
        return ordemDeServicoRepository.save(modelMapper.map(ordemDeServicoDTO, OrdemDeServico.class));
    }

    public OrdemDeServico update(OrdemDeServicoDTO ordemDeServicoDTO) {
        return ordemDeServicoRepository.save(modelMapper.map(ordemDeServicoDTO, OrdemDeServico.class));

    }

    public void delete(Long id) {
        findById(id);
        ordemDeServicoRepository.deleteById(id);
    }


}
