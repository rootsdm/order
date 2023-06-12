package com.service.order.service;

import com.service.order.DTO.ClienteDTO;
import com.service.order.DTO.TecnicoDTO;
import com.service.order.exception.DataIntegretiViolationExcention;
import com.service.order.exception.ObjectNotfoundException;
import com.service.order.models.Pessoa;
import com.service.order.models.Tecnico;
import com.service.order.repository.PessoaRepository;
import com.service.order.repository.TecnicoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TecnicoSERVICE {

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private TecnicoRepository tecnicoRepository;

    @Autowired
    private PessoaRepository pessoaRepository;

    public List<Tecnico> findAll() {
        return tecnicoRepository.findAll();
    }

    public Tecnico findById(Long id) {
        Optional<Tecnico> tecnico = tecnicoRepository.findById(id);
        return tecnico.orElseThrow(() -> new ObjectNotfoundException("ERRO: Tecnico Nao localizado"));
    }

    public Tecnico save(TecnicoDTO tecnicoDTO) {
        findByCpf(tecnicoDTO);
        return tecnicoRepository.save(modelMapper.map(tecnicoDTO, Tecnico.class));

    }

    public Tecnico update(TecnicoDTO tecnicoDTO) {
        findByCpf(tecnicoDTO);
        return tecnicoRepository.save(modelMapper.map(tecnicoDTO, Tecnico.class));

    }

    public void delete(Long id) {
        findById(id);
        tecnicoRepository.deleteById(id);
    }

    public void findByCpf(TecnicoDTO tecnicoDTO) {
        Optional<Pessoa> pessoa = pessoaRepository.findByCpf(tecnicoDTO.getCpf());
        if (pessoa.isPresent() && !pessoa.get().getId().equals(tecnicoDTO.getId())) {
            throw new DataIntegretiViolationExcention("ERRO: CPF já Cadastrado.");
        }
    }

}
