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
        String uri = "/"+SimpleService.class.getSimpleName();
        SimpleService service = new SimpleService();
        Endpoint.publish(host + "1234" + uri,service);
              
        port = System.getenv("PORT");
        uri = "/"+CartaoRN.class.getSimpleName();
        CartaoRN cartaoRN = new CartaoRN();
        Endpoint.publish(host + "1235" + uri,cartaoRN);
        
        port = System.getenv("PORT");
        uri = "/"+UsuarioRN.class.getSimpleName();
        UsuarioRN usuarioRN = new UsuarioRN();
        Endpoint.publish(host + "1236" + uri,usuarioRN);
        
        port = System.getenv("PORT");
        uri = "/"+EstabelecimentoRN.class.getSimpleName();
        EstabelecimentoRN estabelecimentoRN = new EstabelecimentoRN();
        Endpoint.publish(host + "1237" + uri,estabelecimentoRN); 
        
    }
}
