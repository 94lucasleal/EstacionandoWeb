package com.lucas.senac.rn;

import com.lucas.senac.bd.CartaoBD;
import com.lucas.senac.bean.Cartao;
import com.lucas.senac.rnval.CartaoRNVAL;
import java.util.List;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(endpointInterface = "com.senac.lucas.teste1.CartaoRN", serviceName = "CartaoRN")
public class CartaoRN {
    
    private final CartaoBD cartaoBD;
    private final CartaoRNVAL cartaoRNVal;

    public CartaoRN() {
        cartaoBD = new CartaoBD();
        cartaoRNVal = new CartaoRNVAL();
    }
    
    public void inserirCartao(@WebParam(name = "idCartao") Integer idCartao,
                        @WebParam(name = "nomeTitular") String nomeTitular,
                        @WebParam(name = "cpfTitular") String cpfTitular,
                        @WebParam(name = "numeroCartao") String numeroCartao,
                        @WebParam(name = "codSeguranca") Integer codSeguranca) {

        Cartao cartao = new Cartao(idCartao,nomeTitular,cpfTitular,numeroCartao,codSeguranca);
        System.out.println("Teste1");
        //cartaoRNVal.validarInserirCartao(cartao);
        //cartaoBD.inserirCartao(cartao);
    }

    public void excluirCartao(@WebParam(name = "idCartao") Integer idCartao) {
        System.out.println("Teste2");
        Cartao cartao = new Cartao(idCartao,null,null,null,null);
        //cartaoRNVal.validarExcluirCartao(cartao);
        //cartaoBD.excluirCartao(cartao);
    }

    public Cartao consultarCartao(@WebParam(name = "idCartao") Integer idCartao) {
        System.out.println("Teste3");
        Cartao cartao = new Cartao(idCartao,null,null,null,null);
        cartaoRNVal.validarConsultarCartao(cartao);
        return cartaoBD.consultarCartao(cartao);
    }

    public void alterarCartao(@WebParam(name = "idCartao") Integer idCartao,
                        @WebParam(name = "nomeTitular") String nomeTitular,
                        @WebParam(name = "cpfTitular") String cpfTitular,
                        @WebParam(name = "numeroCartao") String numeroCartao,
                        @WebParam(name = "codSeguranca") Integer codSeguranca) {
        Cartao cartao = new Cartao(idCartao,nomeTitular,cpfTitular,numeroCartao,codSeguranca);
        cartaoRNVal.validarAlterarCartao(cartao);
        cartaoBD.alterarCartao(cartao);
    }

    public List<Cartao> pesquisarCartao(@WebParam(name = "pesquisa") String pesquisa) {
        System.out.println(pesquisa);
        return cartaoBD.pesquisarCartao(pesquisa);
    }
    
    public List<Cartao> buscarTodosCartao() {
        return cartaoBD.buscarTodosCartao();
    }

}