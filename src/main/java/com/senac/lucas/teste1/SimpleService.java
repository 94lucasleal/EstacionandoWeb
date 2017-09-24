package com.senac.lucas.teste1;

import javax.jws.WebService;

/**
 *
 * @author douglasgabriel
 * @version 0.1
 */
@WebService(endpointInterface = "com.senac.lucas.teste1.SimpleService", serviceName = "SimpleService")
public class SimpleService {

    public String hello (String name){
        return "Hello, "+name+"!";
    }
    
}
