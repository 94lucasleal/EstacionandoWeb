package com.senac.lucas.teste1;

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
        String uri = "/service";
        SimpleService service = new SimpleService();
        Endpoint.publish(host + port + uri, service);
        
    }
}
