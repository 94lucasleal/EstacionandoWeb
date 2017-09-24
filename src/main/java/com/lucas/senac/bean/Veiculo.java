package com.lucas.senac.bean;

public class Veiculo {
    
    private Integer idVeiculo;
    private String placa;
    private Integer idTipoVeiculo;

    public Veiculo() {
    }

    public Veiculo(Integer idVeiculo, String placa, Integer idTipoVeiculo) {
        this.idVeiculo = idVeiculo;
        this.placa = placa;
        this.idTipoVeiculo = idTipoVeiculo;
    }

    public Integer getIdVeiculo() {
        return idVeiculo;
    }

    public void setIdVeiculo(Integer idVeiculo) {
        this.idVeiculo = idVeiculo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public Integer getIdTipoVeiculo() {
        return idTipoVeiculo;
    }

    public void setIdTipoVeiculo(Integer idTipoVeiculo) {
        this.idTipoVeiculo = idTipoVeiculo;
    }

    @Override
    public String toString() {
        return "Veiculo{" + "idVeiculo=" + idVeiculo + ", placa=" + placa + ", idTipoVeiculo=" + idTipoVeiculo + '}';
    }
     
}
