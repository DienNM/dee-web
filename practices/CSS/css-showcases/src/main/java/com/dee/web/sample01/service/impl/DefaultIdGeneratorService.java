package com.dee.web.sample01.service.impl;

import java.util.concurrent.atomic.AtomicLong;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.dee.web.sample01.service.IdGeneratorService;

/**
 * @author dien.nguyen
 **/

@Service
public class DefaultIdGeneratorService implements IdGeneratorService {
    
    private static AtomicLong currentValueId;

    @PostConstruct
    public void init() {
        currentValueId = new AtomicLong(1);
    }
    
    @Override
    public synchronized String generate() {
        return generate("");
    }

    @Override
    public synchronized String generate(String prefix) {
        long nextValue = currentValueId.addAndGet(1);
        return String.format("%s%05d", prefix, nextValue);
    }
    
}
