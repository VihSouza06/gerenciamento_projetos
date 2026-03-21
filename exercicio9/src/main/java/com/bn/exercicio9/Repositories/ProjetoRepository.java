package com.bn.exercicio9.Repositories;

import com.bn.exercicio9.Models.ProjetoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjetoRepository extends JpaRepository<ProjetoModel, Long> {
}
