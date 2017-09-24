package com.senac.lucas.teste1;

import javax.jws.WebService;

/**
 *
 * @author douglasgabriel
 * @version 0.1
 */
@WebService(name = "SimpleService"
        , targetNamespace = "https://estacionandoteste1.herokuapp.com/")
public interface ServiceInterface {

    public String hello (String name);
    
}
