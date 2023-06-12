package com.service.order.repository;

import com.service.order.models.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

    List<Pessoa> findAll();

    Optional<Pessoa> findById(Long id);
    Optional<Pessoa> findByCpf(String cpf);

}
