package com.lucas.senac.rnval;

import com.lucas.senac.bean.Usuario;

public class UsuarioRNVAL {
    
    public void validarInserirUsuario(Usuario bean) {
        if (bean.getNome().isEmpty()) {
            throw new RuntimeException("Campo NOME não informado");
        }
        if (bean.getCpf().isEmpty()) {
            throw new RuntimeException("Campo CPF não informado");
        }
        if (bean.getRg().isEmpty()) {
            throw new RuntimeException("Campo RG Celular não informado");
        }
    }

    public void validarExcluirUsuario(Usuario bean) {
        validarConsultarUsuario(bean);
    }

    public void validarConsultarUsuario(Usuario bean) {
        if (bean.getIdUsuario() == 0) {
            throw new RuntimeException("Campo Código não informado");
        }
    }
    
    public void validarAlterarUsuario(Usuario bean) {
        validarConsultarUsuario(bean);
    }
    
}
