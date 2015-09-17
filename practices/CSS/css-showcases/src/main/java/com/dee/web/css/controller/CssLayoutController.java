package com.dee.web.css.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author dien.nguyen
 **/

@Controller
@RequestMapping("/layout")
public class CssLayoutController {

    @RequestMapping(value = "/basic", method = RequestMethod.GET)
    public String demoLayoutBasic() {
        return "layout/basic/main";
    }
    
    @RequestMapping(value = "/basic1", method = RequestMethod.GET)
    public String demoLayoutBasic1() {
        return "layout/basic/main1";
    }
    
    @RequestMapping(value = "/classic", method = RequestMethod.GET)
    public String demoLayoutClassic() {
        return "layout/classic/main";
    }
    
}
