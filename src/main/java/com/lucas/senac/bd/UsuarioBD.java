package com.lucas.senac.bd;

import com.lucas.senac.bean.Usuario;
import com.lucas.senac.infra.CrudBD;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UsuarioBD extends CrudBD<Usuario>{
    
    public void inserirUsuario(Usuario usuario) {
        Connection conn = null;
        try {
            conn = abrirConexao();

            PreparedStatement pstm = conn.prepareStatement("INSERT INTO usuario(nome, cpf, rg, idTipoAcesso) VALUES (?,?,?,?)");
            pstm.setString(1, usuario.getNome());
            pstm.setString(2, usuario.getCpf());
            pstm.setString(3, usuario.getRg());
            pstm.setInt(4, usuario.getIdTipoAcesso());

            System.out.println("Salvando: " + usuario);
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

    public void excluirUsuario(Usuario bean) {
        Connection conn = null;
        try {
            conn = abrirConexao();

            PreparedStatement pstm = conn.prepareStatement("DELETE FROM usuario WHERE idUsuario=?");
            pstm.setInt(1, bean.getIdUsuario());

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

    public Usuario consultarUsuario(Usuario bean) {
        Usuario usuarioRetorno = null;

        Connection conn = null;
        try {
            conn = abrirConexao();

            PreparedStatement pstm = conn.prepareStatement("SELECT * FROM usuario WHERE idUsuario=?");
            pstm.setInt(1, bean.getIdUsuario());

            System.out.println("Consultando: " + bean);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                System.out.println("Registro encontrado");
                usuarioRetorno = new Usuario();
                usuarioRetorno.setIdUsuario(rs.getInt("idUsuario"));
                usuarioRetorno.setNome(rs.getString("nome"));
                usuarioRetorno.setCpf(rs.getString("cpf"));
                usuarioRetorno.setRg(rs.getString("rg"));
                usuarioRetorno.setIdTipoAcesso(rs.getInt("idTipoAcesso"));
            }
            System.out.println("Consulta executada com sucesso");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            fecharConexao(conn);
        }

        return usuarioRetorno;
    }

    public void alterarUsuario(Usuario bean) {
        Connection conn = null;
        try {
            conn = abrirConexao();

            PreparedStatement pstm = conn.prepareStatement("UPDATE usuario SET nome = ?, cpf = ?, rg = ?, idTipoAcesso = ? WHERE idUsuario = ?");
            pstm.setString(1, bean.getNome());
            pstm.setString(2, bean.getCpf());
            pstm.setString(3, bean.getRg());
            pstm.setInt(4, bean.getIdTipoAcesso());
            pstm.setInt(5, bean.getIdUsuario());

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

    public ArrayList<Usuario> pesquisarUsuario(String pesquisa) {
        ArrayList<Usuario> lista = new ArrayList<Usuario>();
        
        Connection conn = null;
        try {
            conn = abrirConexao();

            PreparedStatement pstm = conn.prepareStatement("SELECT * FROM usuario WHERE nome like ? OR cpf like ? OR rg like ?");
            pstm.setString(1, "%" + pesquisa + "%");
            pstm.setString(2, "%" + pesquisa + "%");
            pstm.setString(3, "%" + pesquisa + "%");

            System.out.println("Pesquisando: " + pesquisa);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                System.out.println("Registro encontrado");
                
                Usuario usuario = new Usuario();
                usuario.setIdUsuario(rs.getInt("idUsuario"));
                usuario.setNome(rs.getString("nome"));
                usuario.setCpf(rs.getString("cpf"));
                usuario.setRg(rs.getString("rg"));
                usuario.setIdTipoAcesso(rs.getInt("idTipoAcesso"));
                
                lista.add(usuario);
                System.out.println(usuario.toString());
            }
            System.out.println("Pesquisa executada com sucesso");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            fecharConexao(conn);
        }
        return lista;
    }
    
    public ArrayList<Usuario> buscarTodosUsuario() {
        ArrayList<Usuario> lista = new ArrayList<Usuario>();
        
        Connection conn = null;
        try {
            conn = abrirConexao();

            PreparedStatement pstm = conn.prepareStatement("SELECT * FROM usuario");

            System.out.println("Pesquisando: ");
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                System.out.println("Registro encontrado");
                
                Usuario usuario = new Usuario();
                usuario.setIdUsuario(rs.getInt("idUsuario"));
                usuario.setNome(rs.getString("nome"));
                usuario.setCpf(rs.getString("cpf"));
                usuario.setRg(rs.getString("rg"));
                usuario.setIdTipoAcesso(rs.getInt("idTipoAcesso"));
                
                lista.add(usuario);
                System.out.println(usuario.toString());
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


