package com.lucas.senac.bd;

import com.lucas.senac.infra.CrudBD;
import com.lucas.senac.bean.Estabelecimento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class EstabelecimetoBD extends CrudBD<Estabelecimento>{
    
    public void inserirEstabelecimento(Estabelecimento bean) {
        Connection conn = null;
        try {
            conn = abrirConexao();

            PreparedStatement pstm = conn.prepareStatement("INSERT INTO estabelecimento (idEstabelecimento, idUsuario, "
                                                         + "idTipoEstabelecimento, razaoSocial, cnpj, estado, bairro, "
                                                         + "logradouro, cep, numero, referencia, latitude, longitude) "
                                                         + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pstm.setInt(1, bean.getIdUsuario());
            pstm.setInt(2, bean.getIdTipoEstabelecimento());
            pstm.setString(3, bean.getRazaoSocial());
            pstm.setString(4, bean.getCnpj());
            pstm.setString(5, bean.getEstado());
            pstm.setString(6, bean.getMunicipio());
            pstm.setString(7, bean.getBairro());
            pstm.setString(8, bean.getLogradouro());
            pstm.setInt(9, bean.getCep());
            pstm.setInt(10, bean.getNumero());
            pstm.setString(11, bean.getReferencia());
            pstm.setDouble(12, bean.getLatitude());
            pstm.setDouble(13, bean.getLongitude());

            System.out.println("Salvando: " + bean);
            pstm.execute();
            commitTransacao(conn);
            System.out.println("Salvamento executado com sucesso");
        } catch (Exception e) {
            rollbackTransacao(conn);
            throw new RuntimeException(e);
        } finally {
            fecharConexao(conn);
        }
    }

    public void excluirEstabelecimento(Estabelecimento bean) {
        Connection conn = null;
        try {
            conn = abrirConexao();

            PreparedStatement pstm = conn.prepareStatement("DELETE FROM estabelecimento WHERE idEstabelecimento=?");
            pstm.setInt(1, bean.getIdEstacionamento());

            System.out.println("Excluindo: " + bean);
            pstm.execute();
            commitTransacao(conn);
            System.out.println("Exclusão executada com sucesso");
        } catch (Exception e) {
            rollbackTransacao(conn);
            throw new RuntimeException(e);
        } finally {
            fecharConexao(conn);
        }
    }

    public Estabelecimento consultarEstabelecimento(Estabelecimento bean) {
        Estabelecimento estabelecimentoRetorno = null;

        Connection conn = null;
        try {
            conn = abrirConexao();

            PreparedStatement pstm = conn.prepareStatement("SELECT * FROM estabelecimento WHERE idEstabelecimento=?");
            pstm.setInt(1, bean.getIdEstacionamento());

            System.out.println("Consultando: " + bean);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                System.out.println("Registro encontrado");
                estabelecimentoRetorno = new Estabelecimento();
                estabelecimentoRetorno.setIdEstacionamento(rs.getInt("idEstabelecimento"));
                estabelecimentoRetorno.setIdUsuario(rs.getInt("idUsuario"));
                estabelecimentoRetorno.setIdTipoEstabelecimento(rs.getInt("idTipoEstabelecimento"));
                estabelecimentoRetorno.setRazaoSocial(rs.getString("razaoSocial"));
                estabelecimentoRetorno.setCnpj(rs.getString("cnpj"));
                estabelecimentoRetorno.setEstado(rs.getString("estado"));
                estabelecimentoRetorno.setMunicipio(rs.getString("municipio"));
                estabelecimentoRetorno.setBairro(rs.getString("bairro"));
                estabelecimentoRetorno.setLogradouro(rs.getString("logradouro"));
                estabelecimentoRetorno.setCep(rs.getInt("cep"));
                estabelecimentoRetorno.setNumero(rs.getInt("numero"));
                estabelecimentoRetorno.setReferencia(rs.getString("referencia"));
                estabelecimentoRetorno.setLatitude(rs.getDouble("latitude"));
                estabelecimentoRetorno.setLongitude(rs.getDouble("longitude"));
            }
            System.out.println("Consulta executada com sucesso");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            fecharConexao(conn);
        }
        return estabelecimentoRetorno;
    }

    public void alterarEstabelecimento(Estabelecimento bean) {
        Connection conn = null;
        try {
            conn = abrirConexao();

            PreparedStatement pstm = conn.prepareStatement("UPDATE estabelecimento SET idUsuario = ?, "
                                                         + "idTipoEstabelecimento = ?, razaoSocial = ?, cnpj = ?, estado = ?, bairro = ?, "
                                                         + "logradouro = ?, cep, numero = ?, referencia = ?, latitude = ?, longitude = ?) "
                                                         + "WHERE idEstacionamento = ?");
            pstm.setInt(1, bean.getIdUsuario());
            pstm.setInt(2, bean.getIdTipoEstabelecimento());
            pstm.setString(3, bean.getRazaoSocial());
            pstm.setString(4, bean.getCnpj());
            pstm.setString(5, bean.getEstado());
            pstm.setString(6, bean.getMunicipio());
            pstm.setString(7, bean.getBairro());
            pstm.setString(8, bean.getLogradouro());
            pstm.setInt(9, bean.getCep());
            pstm.setInt(10, bean.getNumero());
            pstm.setString(11, bean.getReferencia());
            pstm.setDouble(12, bean.getLatitude());
            pstm.setDouble(13, bean.getLongitude());
            pstm.setInt(14, bean.getIdEstacionamento());

            System.out.println("Alterando: " + bean);
            pstm.execute();
            commitTransacao(conn);
            System.out.println("Alteração executada com sucesso");
            System.out.println(bean.toString());
        } catch (Exception e) {
            rollbackTransacao(conn);
            throw new RuntimeException(e);
        } finally {
            fecharConexao(conn);
        }
    }

    public ArrayList<Estabelecimento> pesquisarEstabelecimento(String pesquisa) {
        ArrayList<Estabelecimento> lista = new ArrayList<Estabelecimento>();
        
        Connection conn = null;
        try {
            conn = abrirConexao();

            PreparedStatement pstm = conn.prepareStatement("SELECT * FROM estabelecimento WHERE razaoSocial like ? OR cnpj like ?");
            pstm.setString(1, "%" + pesquisa + "%");
            pstm.setString(2, "%" + pesquisa + "%");

            System.out.println("Pesquisando: " + pesquisa);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                System.out.println("Registro encontrado");
                
                Estabelecimento estabelecimento = new Estabelecimento();
                estabelecimento.setIdEstacionamento(rs.getInt("idEstabelecimento"));
                estabelecimento.setIdUsuario(rs.getInt("idUsuario"));
                estabelecimento.setIdTipoEstabelecimento(rs.getInt("idTipoEstabelecimento"));
                estabelecimento.setRazaoSocial(rs.getString("razaoSocial"));
                estabelecimento.setCnpj(rs.getString("cnpj"));
                estabelecimento.setEstado(rs.getString("estado"));
                estabelecimento.setMunicipio(rs.getString("municipio"));
                estabelecimento.setBairro(rs.getString("bairro"));
                estabelecimento.setLogradouro(rs.getString("logradouro"));
                estabelecimento.setCep(rs.getInt("cep"));
                estabelecimento.setNumero(rs.getInt("numero"));
                estabelecimento.setReferencia(rs.getString("referencia"));
                estabelecimento.setLatitude(rs.getDouble("latitude"));
                estabelecimento.setLongitude(rs.getDouble("longitude"));
                
                lista.add(estabelecimento);
                System.out.println(estabelecimento.toString());
            }
            System.out.println("Pesquisa executada com sucesso");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            fecharConexao(conn);
        }
        return lista;
    }
    
    public ArrayList<Estabelecimento> buscarTodosEstabelecimento() {
        ArrayList<Estabelecimento> lista = new ArrayList<Estabelecimento>();
        
        Connection conn = null;
        try {
            conn = abrirConexao();

            PreparedStatement pstm = conn.prepareStatement("SELECT * FROM estabelecimento");

            System.out.println("Pesquisando: ");
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                System.out.println("Registro encontrado");
                
                Estabelecimento estabelecimento = new Estabelecimento();
                estabelecimento.setIdEstacionamento(rs.getInt("idEstabelecimento"));
                estabelecimento.setIdUsuario(rs.getInt("idUsuario"));
                estabelecimento.setIdTipoEstabelecimento(rs.getInt("idTipoEstabelecimento"));
                estabelecimento.setRazaoSocial(rs.getString("razaoSocial"));
                estabelecimento.setCnpj(rs.getString("cnpj"));
                estabelecimento.setEstado(rs.getString("estado"));
                estabelecimento.setMunicipio(rs.getString("municipio"));
                estabelecimento.setBairro(rs.getString("bairro"));
                estabelecimento.setLogradouro(rs.getString("logradouro"));
                estabelecimento.setCep(rs.getInt("cep"));
                estabelecimento.setNumero(rs.getInt("numero"));
                estabelecimento.setReferencia(rs.getString("referencia"));
                estabelecimento.setLatitude(rs.getDouble("latitude"));
                estabelecimento.setLongitude(rs.getDouble("longitude"));
                
                lista.add(estabelecimento);
                System.out.println(estabelecimento.toString());
            }
            System.out.println("Pesquisa executada com sucesso");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            fecharConexao(conn);
        }
        return lista;
    }
    
}
