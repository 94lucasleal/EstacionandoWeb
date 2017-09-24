package com.senac.lucas.teste1;

import com.senac.lucas.teste1.SimpleService;
import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Endpoint;
import javax.xml.ws.Service;

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
        
        ServiceInterface service1;
            URL url = new URL("https://estacionandoteste1.herokuapp.com/service?wsdl");
            QName qname = new QName("https://estacionandoteste1.herokuapp.com/", "SimpleService");
            Service serviceLookup = Service.create(url, qname);
            service1 = serviceLookup.getPort(ServiceInterface.class);
            System.out.println(service.hello("Lucas"));
    }
}
