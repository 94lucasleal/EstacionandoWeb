package com.lucas.senac.rn;

import java.net.MalformedURLException;
import javax.xml.ws.Endpoint;
import javax.xml.ws.WebServiceFeature;

/**
 *
 * @author douglasgabriel
 * @version 0.1
 */
public class Loader {

    public static void main(String[] args) throws MalformedURLException {
        String port = System.getenv("PORT");
        String host = "http://0.0.0.0:";
        String uri = "/service";
        SimpleService service = new SimpleService();
        Endpoint.publish(host + port + uri,service);
        
        /*
        String uri1 = "/"+CartaoRN.class.getSimpleName();
        CartaoRN cartaoRN = new CartaoRN();
        Endpoint.publish(host + port + uri1,cartaoRN);
        
        String uri2 = "/"+UsuarioRN.class.getSimpleName();
        UsuarioRN usuarioRN = new UsuarioRN();
        Endpoint.publish(host + port + uri2,usuarioRN);
        
        String uri3 = "/"+EstabelecimentoRN.class.getSimpleName();
        EstabelecimentoRN estabelecimentoRN = new EstabelecimentoRN();
        Endpoint.publish(host + port + uri3,estabelecimentoRN); 
        */
        
    }
}
