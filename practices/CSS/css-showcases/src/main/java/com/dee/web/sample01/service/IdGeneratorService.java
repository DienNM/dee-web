package com.dee.web.sample01.service;

/**
 * @author dien.nguyen
 **/

public interface IdGeneratorService {

    String generate();
    
    String generate(String prefix);
    
}
