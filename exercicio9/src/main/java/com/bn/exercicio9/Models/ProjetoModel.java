package com.bn.exercicio9.Models;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity(name = "Projeto")
@Table(name = "TBL_PROJETO")
public class ProjetoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @Column (name = "nome_projeto")
    private String nome;

    @Column (name = "data_inicio_projeto")
    private LocalDate dataInicio;

    @Column (name = "data_fim_projeto")
    private LocalDate dataFim;

    public ProjetoModel(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataFim() {
        return dataFim;
    }

    public void setDataFim(LocalDate dataFim) {
        this.dataFim = dataFim;
    }
}
