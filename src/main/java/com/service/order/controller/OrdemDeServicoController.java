package com.service.order.controller;

import com.service.order.DTO.OrdemDeServicoDTO;
import com.service.order.models.OrdemDeServico;
import com.service.order.service.OrdemDeServicoSERVICE;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/os")
public class OrdemDeServicoController {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private OrdemDeServicoSERVICE ordemDeServicoSERVICE;
    @Operation(summary = "FindAll - Listagem de Ordem de Serviço")
    @GetMapping
    public ResponseEntity<List<OrdemDeServicoDTO>> findAll() {
        List<OrdemDeServico> ordemDeServicoList = ordemDeServicoSERVICE.findAll();
        return ResponseEntity.ok().body(ordemDeServicoList.stream().map(x -> modelMapper.map(x, OrdemDeServicoDTO.class))
                .collect(Collectors.toList()));
    }

    @Operation(summary = "FindById - Buscar Ordem de Serviço por ID")
    @GetMapping("/{id}")
    public ResponseEntity<OrdemDeServicoDTO> findById(@PathVariable Long id) {
        OrdemDeServico ordemDeServico = ordemDeServicoSERVICE.findById(id);
        return ResponseEntity.ok().body(modelMapper.map(ordemDeServico, OrdemDeServicoDTO.class));
    }

    @Operation(summary = "Save - Incluir Ordem de Serviço")
    @PostMapping
    public ResponseEntity<OrdemDeServicoDTO> save(@Valid @RequestBody OrdemDeServicoDTO ordemDeServicoDTO) {
        OrdemDeServico ordemDeServico = ordemDeServicoSERVICE.save(ordemDeServicoDTO);
        return ResponseEntity.ok().body(modelMapper.map(ordemDeServico, OrdemDeServicoDTO.class));
    }

    @Operation(summary = "Update - Atualizar Ordem de Serviço")
    @PutMapping("/{id}")
    public ResponseEntity<OrdemDeServicoDTO> update(@PathVariable Long id, @RequestBody OrdemDeServicoDTO ordemDeServicoDTO) {
        ordemDeServicoDTO.setId(id);
        return ResponseEntity.ok().body(modelMapper.map(ordemDeServicoSERVICE.update(ordemDeServicoDTO), OrdemDeServicoDTO.class));
    }

    @Operation(summary = "Delete - Delete Ordem de Serviço")
    @DeleteMapping("/{id}")
    public ResponseEntity<OrdemDeServicoDTO> delete(@PathVariable Long id) {
        ordemDeServicoSERVICE.delete(id);
        return ResponseEntity.noContent().build();
    }

}
