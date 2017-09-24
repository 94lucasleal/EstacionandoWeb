package com.lucas.senac.bean;

public class TipoDeVeiculo {
    
    private Integer idTipoVeiculo;
    private String descricao;

    public TipoDeVeiculo() {
    }

    public TipoDeVeiculo(Integer idTipoVeiculo, String descricao) {
        this.idTipoVeiculo = idTipoVeiculo;
        this.descricao = descricao;
    }

    public Integer getIdTipoVeiculo() {
        return idTipoVeiculo;
    }

    public void setIdTipoVeiculo(Integer idTipoVeiculo) {
        this.idTipoVeiculo = idTipoVeiculo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "TipoDeVeiculo{" + "idTipoVeiculo=" + idTipoVeiculo + ", descricao=" + descricao + '}';
    }
        
}
