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
    
    @RequestMapping(value = "/classic1", method = RequestMethod.GET)
    public String demoLayoutClassic() {
        return "layout/classic/main_1";
    }
    
    @RequestMapping(value = "/classic2", method = RequestMethod.GET)
    public String demoLayoutClassic2() {
        return "layout/classic/main_2";
    }
    
    @RequestMapping(value = "/classic3", method = RequestMethod.GET)
    public String demoLayoutClassic3() {
        return "layout/classic/main_3";
    }
    
    @RequestMapping(value = "/classic4", method = RequestMethod.GET)
    public String demoLayoutClassic4() {
        return "layout/classic/main_4";
    }
    
    @RequestMapping(value = "/classic5", method = RequestMethod.GET)
    public String demoLayoutClassic5() {
        return "layout/classic/main_5";
    }
    
    
    @RequestMapping(value = "/classic6", method = RequestMethod.GET)
    public String demoLayoutClassic6() {
        return "layout/classic/main_6";
    }
    
    @RequestMapping(value = "/classic7", method = RequestMethod.GET)
    public String demoLayoutClassic7() {
        return "layout/classic/main_7";
    }
    
    @RequestMapping(value = "/classic8", method = RequestMethod.GET)
    public String demoLayoutClassic8() {
        return "layout/classic/main_8";
    }
}
