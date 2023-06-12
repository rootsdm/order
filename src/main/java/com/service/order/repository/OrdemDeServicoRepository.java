package com.service.order.repository;

import com.service.order.models.OrdemDeServico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrdemDeServicoRepository extends JpaRepository<OrdemDeServico, Long> {

    List<OrdemDeServico> findAll();

    Optional<OrdemDeServico> findById(Long id);




}



