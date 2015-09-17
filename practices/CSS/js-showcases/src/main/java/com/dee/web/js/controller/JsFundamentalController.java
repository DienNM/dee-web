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

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String getFundamental() {
        return "fundamental/main";
    }

}
