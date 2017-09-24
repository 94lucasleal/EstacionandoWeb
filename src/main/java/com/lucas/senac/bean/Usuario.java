package com.lucas.senac.bean;

public class Usuario {
    
    private Integer idUsuario;
    private String nome;
    private String cpf;
    private String rg;
    private Integer idTipoAcesso;

    public Usuario() {
    }

    public Usuario(Integer idUsuario, String nome, String cpf, String rg, Integer idTipoAcesso) {
        this.idUsuario = idUsuario;
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        this.idTipoAcesso = idTipoAcesso;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public Integer getIdTipoAcesso() {
        return idTipoAcesso;
    }

    public void setIdTipoAcesso(Integer idTipoAcesso) {
        this.idTipoAcesso = idTipoAcesso;
    }

    @Override
    public String toString() {
        return "Usuario{" + "idUsuario=" + idUsuario + ", nome=" + nome + ", cpf=" + cpf + ", rg=" + rg + ", idTipoAcesso=" + idTipoAcesso + '}';
    }
    
}
