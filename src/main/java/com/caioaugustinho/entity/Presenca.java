package com.caioaugustinho.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;



/**
* Classe referente as datas em que o aluno compareceu a academia.  
*     	  
* @author            Caio Augustinho
*/
@Entity
public class Presenca {

    @Id
    @GeneratedValue
    private int id;

    private Date dataPresenca;

    @ManyToOne
    @JoinColumn
    private Aluno aluno;

    public Presenca() {}

    public Presenca(Aluno aluno, Date dataPresenca) {
	this.aluno = aluno;
	this.dataPresenca = dataPresenca;
    }

    @Override
    public String toString() {
	return " Id_Presença='" + this.id + '\'' + 
		", Nome Aluno ='" + this.aluno.getNome() + '\'' +
		", Data da Presenca ='" + this.dataPresenca + "\'";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDataPresenca() {
        return dataPresenca;
    }

    public void setDataPresenca(Date dataPresenca) {
        this.dataPresenca = dataPresenca;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }
    
}
