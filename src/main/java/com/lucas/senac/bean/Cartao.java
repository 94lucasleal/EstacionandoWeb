package com.lucas.senac.bean;

public class Cartao {
    
    private Integer idCartao;
    private String nomeTitular;
    private String cpfTitular;
    private String numeroCartao;
    private Integer codSeguranca;

    public Cartao() {
    }

    public Cartao(Integer idCartao, String nomeTitular, String cpfTitular, String numeroCartao, Integer codSeguranca) {
        this.idCartao = idCartao;
        this.nomeTitular = nomeTitular;
        this.cpfTitular = cpfTitular;
        this.numeroCartao = numeroCartao;
        this.codSeguranca = codSeguranca;
    }

    public Integer getIdCartao() {
        return idCartao;
    }

    public void setIdCartao(Integer idCartao) {
        this.idCartao = idCartao;
    }

    public String getNomeTitular() {
        return nomeTitular;
    }

    public void setNomeTitular(String nomeTitular) {
        this.nomeTitular = nomeTitular;
    }

    public String getCpfTitular() {
        return cpfTitular;
    }

    public void setCpfTitular(String cpfTitular) {
        this.cpfTitular = cpfTitular;
    }

    public String getNumeroCartao() {
        return numeroCartao;
    }

    public void setNumeroCartao(String numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    public Integer getCodSeguranca() {
        return codSeguranca;
    }

    public void setCodSeguranca(Integer codSeguranca) {
        this.codSeguranca = codSeguranca;
    }

    @Override
    public String toString() {
        return "Cartao{" + "idCartao=" + idCartao + ", nomeTitular=" + nomeTitular + ", cpfTitular=" + cpfTitular + ", numeroCartao=" + numeroCartao + ", codSeguranca=" + codSeguranca + '}';
    }
    
}
