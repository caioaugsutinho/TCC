package com.caioaugustinho.business.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caioaugustinho.entity.Aluno;
import com.caioaugustinho.entity.Presenca;
import com.caioaugustinho.repository.RepositoriodeAlunos;
import com.caioaugustinho.repository.RepositoriodePresenca;
import com.caioaugustinho.web.AjusteData;
@Service
public class ServicoPresenca {


	private RepositoriodePresenca repositorioDePresenca;
	private RepositoriodeAlunos repositoriodeAlunos;

	@Autowired
	public ServicoPresenca(RepositoriodePresenca repositorioDePresenca, RepositoriodeAlunos repositorioDeAlunos) {
		this.repositorioDePresenca = repositorioDePresenca;
		this.repositoriodeAlunos = repositorioDeAlunos;
		popularPresencasIniciais();
	}

	public void cadastrarPresencaNoBanco(Aluno aluno) {
		Presenca presencaX = new Presenca(aluno, AjusteData.createDateFromDateString("31-12-2020"));
		aluno.addPresenca(presencaX);
		this.repositorioDePresenca.save(presencaX);
	}

	public List<Presenca> recuperarListadePresencadoBanco() {
		return this.repositorioDePresenca.findAll();
	}
	
	public Map<String, Integer> recuperarEstatisticaPresenca(Aluno aluno) {
		Map<String, Integer> map = new HashMap<>();
		
		List<Presenca> listaPresencas = aluno.getListaPresencas();
		
		for (Presenca presenca : listaPresencas) {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(presenca.getDataPresenca());
			String ano = String.valueOf(calendar.get(Calendar.YEAR));
			if (map.containsKey(ano)) {
				Integer quantidade = map.get(ano);
				map.put(ano, quantidade+1);
			} else {
				map.put(ano, 1);
			}
		}
		
		return map;
	}


	public void popularPresencasIniciais() {
		List<Presenca> presencas = new ArrayList<>();
		int quantidadeAlunos = 10;
		int limiteDia = 28;
		int limiteMes = 12;
		int inicioAno = 2019;
		int fimAno = 2023;
		Random random = new Random();
		for (int idAluno = 1; idAluno <= quantidadeAlunos; idAluno++) {
			Aluno aluno = this.repositoriodeAlunos.findById(idAluno).get();
			for (int ano = inicioAno; ano <= fimAno; ano++) {
				for (int mes = 1; mes <= limiteMes; mes++) {
					for (int dia = 1; dia <= limiteDia; dia++) {
						if (random.nextBoolean()) {
							presencas.add(new Presenca(aluno, AjusteData
									.createDateFromDateString(String.format("%d-%d-%d %d:%d", dia, mes, ano, random.nextInt(24), random.nextInt(60)))));
						}
					}
				}
			}
		}
		this.repositorioDePresenca.saveAll(presencas);		
	}
}

