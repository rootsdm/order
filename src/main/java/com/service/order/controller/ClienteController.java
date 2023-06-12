package com.service.order.controller;

import com.service.order.DTO.ClienteDTO;
import com.service.order.models.Cliente;
import com.service.order.service.ClienteSERVICE;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ClienteSERVICE clienteSERVICE;

    @Operation(summary = "FindAll - Lista de Clientes")
    @GetMapping
    public ResponseEntity<List<ClienteDTO>> findAll() {
        List<Cliente> clienteList = clienteSERVICE.findAll();
        return ResponseEntity.ok().body(clienteList.stream().map(x -> modelMapper.map(x, ClienteDTO.class))
                .collect(Collectors.toList()));
    }

    @Operation(summary = "FindById - Buscar Cliente por ID")
    @GetMapping("/{id}")
    public ResponseEntity<ClienteDTO> findById(@PathVariable Long id) {
        Cliente cliente = clienteSERVICE.findById(id);
        return ResponseEntity.ok().body(modelMapper.map(cliente, ClienteDTO.class));
    }

    @Operation(summary = "Save - Salvar Cliente")
    @PostMapping
    public ResponseEntity<ClienteDTO> save(@Valid  @RequestBody ClienteDTO clienteDTO) {
        Cliente cliente = clienteSERVICE.save(clienteDTO);
        return ResponseEntity.ok().body(modelMapper.map(cliente, ClienteDTO.class));
    }

    @Operation(summary = "Update - Atualizar de Cliente por ID")
    @PutMapping("/{id}")
    public ResponseEntity<ClienteDTO> update(@PathVariable Long id, @RequestBody ClienteDTO clienteDTO) {
        clienteDTO.setId(id);
        return ResponseEntity.ok().body(modelMapper.map(clienteSERVICE.update(clienteDTO), ClienteDTO.class));
    }

    @Operation(summary = "Delete - Exclusão de Cliente por ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<ClienteDTO> delete(@PathVariable Long id) {
        clienteSERVICE.delete(id);
        return ResponseEntity.noContent().build();
    }


}
