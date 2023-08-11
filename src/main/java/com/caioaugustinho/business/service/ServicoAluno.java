package com.caioaugustinho.business.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caioaugustinho.entity.Aluno;
import com.caioaugustinho.repository.RepositoriodeAlunos;

@Service
public class ServicoAluno {

    private RepositoriodeAlunos repositoriodeAlunos;

    @Autowired
    public ServicoAluno(RepositoriodeAlunos repositoriodeAlunos) {
	this.repositoriodeAlunos = repositoriodeAlunos;
	cadastrarAlunosnoBancoInicial();
    }

    public void cadastrarAlunoNoBanco(Aluno aluno) {
 	this.repositoriodeAlunos.save(aluno);
    }

    public Aluno recuperarAlunodoBanco(Integer id) {
	Aluno aluno = this.repositoriodeAlunos.findById(id).get(); 
	return aluno;
    }

    public List<Aluno> recuperarListadeAlunosdoBanco() {
	List<Aluno> ListaAlunosRecuperados = this.repositoriodeAlunos.findAll(); 
	//Impressão de Aluno Recuperados para necessidade de Debug
	//ListaAlunosRecuperados.forEach(alunoRecuperado ->{System.out.println(alunoRecuperado.toString());});
	return ListaAlunosRecuperados;
    }
    
    //
    public void cadastrarAlunosnoBancoInicial() {
	this.repositoriodeAlunos.save(new Aluno(1,"Daniel Alfa","356.657.638.71","47.099.056-8", "Rua A"));
	this.repositoriodeAlunos.save(new Aluno(2,"Ricardo Amaral","356.657.638.72","47.099.057-8", "Rua B"));
	this.repositoriodeAlunos.save(new Aluno(3,"Bruna Bravo","356.657.638.73","47.099.058-8", "Rua C"));
	this.repositoriodeAlunos.save(new Aluno(4,"Samuel Lopes","356.657.638.74","47.099.059-8", "Rua D"));
	this.repositoriodeAlunos.save(new Aluno(5,"Sandra Gold","356.657.638.75","47.099.060-8", "Rua E"));
	this.repositoriodeAlunos.save(new Aluno(6,"kiko Nascimento","356.657.638.76","47.099.061-8", "Rua F"));
	this.repositoriodeAlunos.save(new Aluno(7,"Felipe Ferreira","356.657.638.77","47.099.062-8", "Rua G"));
	this.repositoriodeAlunos.save(new Aluno(8,"Rogerio Mendes","356.657.638.78","47.099.063-8", "Rua H"));
	this.repositoriodeAlunos.save(new Aluno(9,"Bruno Silva","356.657.638.79","47.099.064-8", "Rua I"));
	this.repositoriodeAlunos.save(new Aluno(10,"Anderson Silva","356.657.638.80","47.099.065-8", "Rua J"));
	this.repositoriodeAlunos.save(new Aluno(11,"Thiago Ricardo","356.657.638.81","47.099.066-8", "Rua K"));
	this.repositoriodeAlunos.save(new Aluno(12,"Leandro Ossuna","356.657.638.82","47.099.067-8", "Rua L"));
	this.repositoriodeAlunos.save(new Aluno(13,"Rogerio Renato","356.657.638.83","47.099.068-8", "Rua M"));
	this.repositoriodeAlunos.save(new Aluno(14,"Rodrigues Alfa","356.657.638.84","47.099.069-8", "Rua N"));
	this.repositoriodeAlunos.save(new Aluno(15,"Luiz Augusnto","356.657.638.85","47.099.070-8", "Rua O"));
	this.repositoriodeAlunos.save(new Aluno(16,"Juliano Luidg","356.657.638.86","47.099.071-8", "Rua P"));
	this.repositoriodeAlunos.save(new Aluno(17,"Aline Lins","356.657.638.87","47.099.072-8", "Rua Q"));
	this.repositoriodeAlunos.save(new Aluno(18,"Daniel Roberto","356.657.638.88","47.099.073-8", "Rua R"));
	this.repositoriodeAlunos.save(new Aluno(19,"Ferreira Augusto","356.657.638.89","47.099.074-8", "Rua S"));
	this.repositoriodeAlunos.save(new Aluno(20,"Gabriel Lins","356.657.638.90","47.099.075-8", "Rua U"));
	    }
}
