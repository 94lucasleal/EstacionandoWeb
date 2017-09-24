package com.lucas.senac.rn;

import javax.jws.WebService;

/**
 *
 * @author douglasgabriel
 * @version 0.1
 */
@WebService()
public class SimpleService{

    public String hello (String name){
        return "Hello, "+name+"!";
    }
    
}
