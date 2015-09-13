package com.dee.webdee.dmc.web.controller.common;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author dien.nguyen
 */

@Controller
@RequestMapping(value = "/countries")
public class CountryController {
    
    @RequestMapping(method = RequestMethod.GET)
    public String getAllCountries() {
        return "common/country_list";
    }
    
}
