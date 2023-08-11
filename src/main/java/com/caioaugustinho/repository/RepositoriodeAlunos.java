package com.caioaugustinho.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.caioaugustinho.entity.Aluno;


/**
* Interface referente ao repositório de alunos no banco de dados.  
*     	  
* @author            Caio Augustinho
*/
@Repository
public interface RepositoriodeAlunos extends JpaRepository<Aluno, Integer> {

}
