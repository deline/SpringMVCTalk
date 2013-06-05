package com.delineneo.service;

import org.springframework.stereotype.Service;

/**
 * User: deline
 * Date: 5/06/13
 * Time: 6:40 PM
 */
@Service("simpleService")
public class SimpleServiceImpl implements SimpleService {

    @Override
    public String getText() {
        return "This is the actual implementation value";
    }
}
