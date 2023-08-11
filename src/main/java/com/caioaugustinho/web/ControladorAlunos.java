package com.caioaugustinho.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.caioaugustinho.business.service.ServicoAluno;
import com.caioaugustinho.entity.Aluno;

@Controller
public class ControladorAlunos {

    private final ServicoAluno servicoAluno;

    @Autowired
    public ControladorAlunos(ServicoAluno servicoAluno) {
	this.servicoAluno = servicoAluno;
    }
    

    @GetMapping("/areaDoEmpregado")
    public String axibirAreaEmpregados(Model model) {
//	List<Aluno> listaDeAlunos = this.servicoAluno.recuperarListadeAlunosdoBanco();
//	model.addAttribute("listadeAlunos", listaDeAlunos);
	return "menuAreaEmpregados";
    }

    @GetMapping("/FormulariodeCadastroAluno")
    public String ExibirFormulario(Model model) {
	model.addAttribute("aluno", new Aluno());
	return "cadastroaluno";
    }

    @PostMapping("/cadastrarAluno")
    public String cadastrar(@ModelAttribute Aluno aluno) {
	this.servicoAluno.cadastrarAlunoNoBanco(aluno);
	return "redirect:/listarAlunos";
    }

    @GetMapping("/listarAlunos")
    public String listarAlunos(Model model) {
	List<Aluno> listaDeAlunos = this.servicoAluno.recuperarListadeAlunosdoBanco();
	model.addAttribute("listadeAlunos", listaDeAlunos);
	return "listaalunos";
    }
}