package com.desafiomvc.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class UnidadeDeMedida {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer xicara;

    private Integer colherDeSopa;

    private Integer colherDeCha;

    private Integer gramas;

    private Integer litros;

    @OneToMany(mappedBy = "unidadeDeMedida")
    private List<Receita> receitas;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getXicara() {
        return xicara;
    }

    public void setXicara(Integer xicara) {
        this.xicara = xicara;
    }

    public Integer getColherDeSopa() {
        return colherDeSopa;
    }

    public void setColherDeSopa(Integer colherDeSopa) {
        this.colherDeSopa = colherDeSopa;
    }

    public Integer getColherDeCha() {
        return colherDeCha;
    }

    public void setColherDeCha(Integer colherDeCha) {
        this.colherDeCha = colherDeCha;
    }

    public Integer getGramas() {
        return gramas;
    }

    public void setGramas(Integer gramas) {
        this.gramas = gramas;
    }

    public Integer getLitros() {
        return litros;
    }

    public void setLitros(Integer litros) {
        this.litros = litros;
    }

    public List<Receita> getReceitas() {
        return receitas;
    }

    public void setReceitas(List<Receita> receitas) {
        this.receitas = receitas;
    }
}
