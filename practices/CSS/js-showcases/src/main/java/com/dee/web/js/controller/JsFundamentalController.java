package com.dee.web.js.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author dien.nguyen
 **/

@Controller
@RequestMapping("/fundamental")
public class JsFundamentalController {

    @RequestMapping(value = "example1", method = RequestMethod.GET)
    public String getFundamental1() {
        return "fundamental/example1";
    }
    
    @RequestMapping(value = "example2", method = RequestMethod.GET)
    public String getFundamental2() {
        return "fundamental/example2";
    }
    
    @RequestMapping(value = "example3", method = RequestMethod.GET)
    public String getFundamental3() {
        return "fundamental/example3";
    }
    
    @RequestMapping(value = "example4", method = RequestMethod.GET)
    public String getFundamental4() {
        return "fundamental/example4";
    }
    
    @RequestMapping(value = "example5", method = RequestMethod.GET)
    public String getFundamental5() {
        return "fundamental/example5";
    }

}
