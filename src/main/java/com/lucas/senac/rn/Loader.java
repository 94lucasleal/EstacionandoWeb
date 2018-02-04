package com.lucas.senac.rn;

import com.sun.grizzly.http.SelectorThread;
import com.sun.jersey.api.container.grizzly.GrizzlyWebContainerFactory;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import javax.ws.rs.core.UriBuilder;
import javax.xml.ws.Endpoint;
import javax.xml.ws.WebServiceFeature;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

public class Loader {

    public static void main(String[] args) throws MalformedURLException, IOException, Exception {
        String port = System.getenv("PORT");
        if (port == null) port = "9998";
        //URI BASE_URI = UriBuilder.fromUri("https://0.0.0.0/").port(Integer.parseInt(port)).build(); 
        /*
        String port = "9998";
        String host = "http://0.0.0.0:";
        String uri = "/service";
        SimpleService service = new SimpleService();
        Endpoint.publish(host + port + uri,service);
        
        //final String baseUri = "http://localhost:"+(System.getenv("PORT")!=null?System.getenv("PORT"):"9998")+"/";
        //final String baseUri = "https://0.0.0.0:"+port+"/";
        final String baseUri = String.valueOf(BASE_URI);
        final Map<String, String> initParams = new HashMap<String, String>();
        initParams.put("com.sun.jersey.config.property.packages","com.lucas.senac.rn");
        
        System.out.println("Iniciando o grizzly...");
        SelectorThread threadSelector = GrizzlyWebContainerFactory.create(baseUri, initParams);
        System.out.println(String.format("Serviço iniciado acesse: %sapplication.wadl.",baseUri, baseUri));
        */
        String webappDirLocation = "src/main/webapp/";

        // The port that we should run on can be set into an environment variable
        // Look for that variable and default to 8080 if it isn't there.
        String webPort = System.getenv("PORT");
        if (webPort == null || webPort.isEmpty()) {
            webPort = "9998";
        }
 System.out.println("1");
        Server server = new Server(Integer.valueOf(webPort));
        WebAppContext root = new WebAppContext();
 System.out.println("2");
        root.setContextPath("/");
        root.setDescriptor(webappDirLocation + "/WEB-INF/web.xml");
        root.setResourceBase(webappDirLocation);
 System.out.println("3");
        // Parent loader priority is a class loader setting that Jetty accepts.
        // By default Jetty will behave like most web containers in that it will
        // allow your application to replace non-server libraries that are part of the
        // container. Setting parent loader priority to true changes this behavior.
        // Read more here: http://wiki.eclipse.org/Jetty/Reference/Jetty_Classloading
        root.setParentLoaderPriority(true);
 System.out.println("4");
        server.setHandler(root);
 System.out.println("5");
        server.start();
         System.out.println("6");
        server.join(); 
         System.out.println("7");
        
    }
}
