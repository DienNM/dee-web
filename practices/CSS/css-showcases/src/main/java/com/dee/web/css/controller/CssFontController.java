package com.dee.web.css.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author dien.nguyen
 **/

@Controller
@RequestMapping("/fonts")
public class CssFontController {

    @RequestMapping(value = "/example1", method = RequestMethod.GET)
    public String demoCoreConcept() {
        return "fonts/main";
    }
}
