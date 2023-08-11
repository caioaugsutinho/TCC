		
package com.caioaugustinho.entity;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class Aluno {
    @Id
    @GeneratedValue
    private int id;   

    private String nome;
    private String cpf; // TIPO PLANO -> CPF

    private String rg; // TELEFONE -> RG

    private String endereco; // COMENTARIO -> ENDEREÇO

    private int matricula;
    @OneToMany(mappedBy = "aluno",fetch = FetchType.EAGER,cascade = CascadeType.ALL)   
    private List<Presenca> listaPresencas = new ArrayList<>();

    public Aluno(){}

    public Aluno(int numero_matricula,String nome_aluno,String cpf,String rg,String endereco) {
	 this.matricula = numero_matricula;
	 this.nome = nome_aluno;
	 this.cpf = cpf;
	 this.rg = rg;
	 this.endereco = endereco;
    }
    @Override
    public String toString() {
	return " nome_aluno='" + this.nome + '\'' + 
		", matricula ='" + this.matricula + '\'' +
		", tipo do plano ='" + this.cpf + '\'' +
		", rg ='" + this.rg + '\'' +
		", endereco ='" + this.endereco + "\'";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome_aluno) {
        this.nome = nome_aluno;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int numero_matricula) {
        this.matricula = numero_matricula;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }   

    public List<Presenca> getListaPresencas() {
        return listaPresencas;
    }

    public void addPresenca(Presenca presenca) {
        this.listaPresencas.add(presenca);
    }

}

