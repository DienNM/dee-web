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
    
    @RequestMapping(value = "/building-block", method = RequestMethod.GET)
    public String demoBuildingBlock() {
        return "building-block/main";
    }
    
    @RequestMapping(value = "/text", method = RequestMethod.GET)
    public String demoTex() {
        return "text/main";
    }
    
    @RequestMapping(value = "/color-bg-img", method = RequestMethod.GET)
    public String demoColorBackgroundImage() {
        return "color-bg-img/main";
    }
    
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String demoList() {
        return "list/main";
    }
    
    @RequestMapping(value = "/link", method = RequestMethod.GET)
    public String demoLink() {
        return "link/main";
    }

}
