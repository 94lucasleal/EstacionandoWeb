package com.lucas.senac.rn;

import javax.jws.WebService;

/**
 *
 * @author douglasgabriel
 * @version 0.1
 */
@WebService(endpointInterface = "com.lucas.senac.rn.SimpleService", serviceName = "SimpleService")
public class SimpleService {

    public String hello (String name){
        return "Hello, "+name+"!";
    }
    
}
