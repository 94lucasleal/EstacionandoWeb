package com.lucas.senac.rn;

import java.net.MalformedURLException;
import javax.xml.ws.Endpoint;

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
        Endpoint.publish(host + port + uri,service);
              
        /*uri = "/"+CartaoRN.class.getSimpleName();
        CartaoRN cartaoRN = new CartaoRN();
        Endpoint.publish(host + port + uri,cartaoRN);
        
        uri = "/"+UsuarioRN.class.getSimpleName();
        UsuarioRN usuarioRN = new UsuarioRN();
        Endpoint.publish(host + port + uri,usuarioRN);
        
        uri = "/"+EstabelecimentoRN.class.getSimpleName();
        EstabelecimentoRN estabelecimentoRN = new EstabelecimentoRN();
        Endpoint.publish(host + port + uri,estabelecimentoRN); 
*/
    }
}