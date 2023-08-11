package com.caioaugustinho.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.caioaugustinho.entity.Presenca;

/**
* Interface referente ao repositório de presencas do aluno no banco de dados.  
*     	  
* @author            Caio Augustinho
*/
@Repository
public interface RepositoriodePresenca extends JpaRepository<Presenca, Integer>{

}
