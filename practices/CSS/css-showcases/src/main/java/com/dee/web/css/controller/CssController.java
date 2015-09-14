package com.dee.web.css.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author dien.nguyen
 **/

@Controller
@RequestMapping("/get2know")
public class CssController {

    @RequestMapping(value = "/core-concept", method = RequestMethod.GET)
    public String demoCoreConcept() {
        return "core-concept/main";
    }

}
