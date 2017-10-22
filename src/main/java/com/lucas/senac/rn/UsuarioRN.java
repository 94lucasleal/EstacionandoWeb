package com.lucas.senac.rn;

import com.lucas.senac.bd.UsuarioBD;
import com.lucas.senac.bean.Usuario;
import com.lucas.senac.rnval.UsuarioRNVAL;
import java.util.List;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(endpointInterface = "com.lucas.senac.rn.UsuarioRN", serviceName = "UsuarioRN")
public class UsuarioRN {

    private final UsuarioBD usuarioBD;
    private final UsuarioRNVAL usuarioRNVal;

    public UsuarioRN() {
        usuarioBD = new UsuarioBD();
        usuarioRNVal = new UsuarioRNVAL();
    }

    public void inserirUsuario(@WebParam(name = "idUsuario") Integer idUsuario,
            @WebParam(name = "nome") String nome,
            @WebParam(name = "cpf") String cpf,
            @WebParam(name = "rg") String rg,
            @WebParam(name = "email") String email,
            @WebParam(name = "senha") String senha,
            @WebParam(name = "idTipoAcesso") Integer idTipoAcesso,
            @WebParam(name = "telefone") Integer telefone) {

        Usuario usuario = new Usuario(idUsuario, nome, cpf, rg, email, senha, idTipoAcesso, telefone);
        usuarioRNVal.validarInserirUsuario(usuario);
        usuarioBD.inserirUsuario(usuario);
    }

    public void excluirUsuario(@WebParam(name = "idUsuario") Integer idUsuario) {
        Usuario usuario = new Usuario(idUsuario, null, null, null, null, null, null, null);
        usuarioRNVal.validarExcluirUsuario(usuario);
        usuarioBD.excluirUsuario(usuario);
    }

    public Usuario consultarUsuario(@WebParam(name = "email") String email,
            @WebParam(name = "senha") String senha) {
        Usuario usuario = new Usuario(null, null, null, null, email, senha, null, null);
        usuarioRNVal.validarConsultarUsuario(usuario);
        return usuarioBD.consultarUsuario(usuario);
    }

    public void alterarUsuario(@WebParam(name = "idUsuario") Integer idUsuario,
            @WebParam(name = "nome") String nome,
            @WebParam(name = "cpf") String cpf,
            @WebParam(name = "rg") String rg,
            @WebParam(name = "email") String email,
            @WebParam(name = "senha") String senha,
            @WebParam(name = "idTipoAcesso") Integer idTipoAcesso,
            @WebParam(name = "telefone") Integer telefone) {
        Usuario usuario = new Usuario(idUsuario, nome, cpf, rg, email, senha, idTipoAcesso, telefone);
        usuarioRNVal.validarAlterarUsuario(usuario);
        usuarioBD.alterarUsuario(usuario);
    }

    public List<Usuario> pesquisarUsuario(@WebParam(name = "pesquisa") String pesquisa) {
        System.out.println(pesquisa);
        return usuarioBD.pesquisarUsuario(pesquisa);
    }

    public List<Usuario> buscarTodosUsuario() {
        return usuarioBD.buscarTodosUsuario();
    }

}
