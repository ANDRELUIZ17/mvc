package com.desafiomvc.entities;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
public class Receita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Nome não pode ser vazio.")
    private String nome;

    @NotEmpty(message = "Descrição não pode ser vazio.")
    @NotNull @Size(min = 10, max = 2200, message = "Descrição deve ter entre 10 e 100 caracteres.")
    private String descricao;

    private String categoria;

    private String ingredientes;

    private String modoDePreparo;

    private String rendimento;

    private String tempoDePreparo;

    @ManyToOne
    @JoinColumn(name = "unidade_de_medida_id")
    private UnidadeDeMedida unidadeDeMedida;

    public UnidadeDeMedida getUnidadeDeMedida() {
        return unidadeDeMedida;
    }

    public void setUnidadeDeMedida(UnidadeDeMedida unidadeDeMedida) {
        this.unidadeDeMedida = unidadeDeMedida;
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(String ingredientes) {
        this.ingredientes = ingredientes;
    }

    public String getModoDePreparo() {
        return modoDePreparo;
    }

    public void setModoDePreparo(String modoDePreparo) {
        this.modoDePreparo = modoDePreparo;
    }

    public String getRendimento() {
        return rendimento;
    }

    public void setRendimento(String rendimento) {
        this.rendimento = rendimento;
    }

    public String getTempoDePreparo() {
        return tempoDePreparo;
    }

    public void setTempoDePreparo(String tempoDePreparo) {
        this.tempoDePreparo = tempoDePreparo;
    }
}
