package com.caioaugustinho.web;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.caioaugustinho.business.service.ServicoAluno;
import com.caioaugustinho.business.service.ServicoPresenca;
import com.caioaugustinho.entity.Aluno;
@Controller
public class ControladorPresencas {
    private ServicoPresenca servicoPresenca;

    private ServicoAluno servicoAluno;

    @Autowired
    public ControladorPresencas(ServicoAluno servicoAluno,ServicoPresenca servicoPresenca) {
	this.servicoPresenca = servicoPresenca;
	this.servicoAluno = servicoAluno;
    }

    @GetMapping("/listarPresencasAluno") // Jogar para Controlador de Alunos
    public String ListarPresencas(Integer id, Model model) {
	Aluno alunoX = this.servicoAluno.recuperarAlunodoBanco(id);
		
	model.addAttribute("alunoX", alunoX);
    
	Map<String, Integer> graphData = this.servicoPresenca.recuperarEstatisticaPresenca(alunoX);
    
    model.addAttribute("chartData", graphData);
	
	return "listapresencasaluno";
    };

    @GetMapping("/cadastrarPresencaAluno")
    public String cadastratPresenca(Integer id, Model model) throws InterruptedException {
	Aluno alunoX = this.servicoAluno.recuperarAlunodoBanco(id);
	this.servicoPresenca.cadastrarPresencaNoBanco(alunoX);
	model.addAttribute("alunoX", alunoX);
	return "listapresencasaluno";
    };   
        
}
