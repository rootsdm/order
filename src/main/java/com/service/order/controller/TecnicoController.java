package com.service.order.controller;

import com.service.order.DTO.TecnicoDTO;
import com.service.order.models.Tecnico;
import com.service.order.service.TecnicoSERVICE;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/tecnico")
public class TecnicoController {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private TecnicoSERVICE tecnicoSERVICE;

    @Operation(summary = "FindAll- Lista de Tecnicos")
    @GetMapping
    public ResponseEntity<List<TecnicoDTO>> findAll(){
        List<Tecnico> tecnicoList = tecnicoSERVICE.findAll();
        return ResponseEntity.ok().body(tecnicoList.stream().map(x->modelMapper.map(x, TecnicoDTO.class))
                .collect(Collectors.toList()));
    }

    @Operation(summary = "FindById - Buscar de Tecnico por ID")
    @GetMapping("/{id}")
    public ResponseEntity<TecnicoDTO> findById(@PathVariable Long id){
        Tecnico tecnico = tecnicoSERVICE.findById(id);
        return ResponseEntity.ok().body(modelMapper.map(tecnico, TecnicoDTO.class));
    }


    @Operation(summary = "Save - Salvar Cliente")
    @PostMapping
    public ResponseEntity<TecnicoDTO> save(@Valid @RequestBody TecnicoDTO tecnicoDTO) {
        Tecnico tecnico = tecnicoSERVICE.save(tecnicoDTO);
        return ResponseEntity.ok().body(modelMapper.map(tecnico, TecnicoDTO.class));
    }

    @Operation(summary = "Update - Atualizar Cliente por ID")
    @PutMapping("/{id}")
    public ResponseEntity<TecnicoDTO> update(@PathVariable Long id, @RequestBody TecnicoDTO tecnicoDTO){
        tecnicoDTO.setId(id);
        return ResponseEntity.ok().body(modelMapper.map(tecnicoSERVICE.update(tecnicoDTO), TecnicoDTO.class));
    }

    @Operation(summary = "Delete - Exclusão de Tecnico por ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<TecnicoDTO> delete(@PathVariable Long id){
        tecnicoSERVICE.delete(id);
        return ResponseEntity.noContent().build();
    }

}
