package com.service.order.service;

import com.service.order.DTO.ClienteDTO;
import com.service.order.exception.DataIntegretiViolationExcention;
import com.service.order.exception.ObjectNotfoundException;
import com.service.order.models.Cliente;
import com.service.order.models.Pessoa;
import com.service.order.repository.ClienteRepository;
import com.service.order.repository.PessoaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteSERVICE {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private PessoaRepository pessoaRepository;

    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    public Cliente findById(Long id) {
        Optional<Cliente> cliente = clienteRepository.findById(id);
        return cliente.orElseThrow(() -> new ObjectNotfoundException("ERRO: Cliente Nao localizado"));
    }

    public Cliente save(ClienteDTO clienteDTO) {
        findByCpf(clienteDTO);
        return clienteRepository.save(modelMapper.map(clienteDTO, Cliente.class));

    }

    public Cliente update(ClienteDTO clienteDTO) {
        findByCpf(clienteDTO);
        return clienteRepository.save(modelMapper.map(clienteDTO, Cliente.class));

    }

    public void delete(Long id) {
        findById(id);
        clienteRepository.deleteById(id);
    }

    public void findByCpf(ClienteDTO clienteDTO) {
        Optional<Pessoa> pessoa = pessoaRepository.findByCpf(clienteDTO.getCpf());

        if (pessoa.isPresent() && !pessoa.get().getId().equals(clienteDTO.getId())) {
            throw new DataIntegretiViolationExcention("ERRO: CPF já Cadastrado.");
        }
    }
}
