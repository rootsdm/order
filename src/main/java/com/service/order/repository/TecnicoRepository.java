package com.service.order.repository;

import com.service.order.models.Tecnico;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TecnicoRepository extends JpaRepository<Tecnico, Long> {
    List<Tecnico> findAll();

    Optional<Tecnico> findById(Long id);

    Optional<Tecnico> findByCpf(String cpf);

}
