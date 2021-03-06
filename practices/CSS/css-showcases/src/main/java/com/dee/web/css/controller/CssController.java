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
        return "basic/core-concept/main";
    }
    
    @RequestMapping(value = "/building-block", method = RequestMethod.GET)
    public String demoBuildingBlock() {
        return "basic/building-block/main";
    }
    
    @RequestMapping(value = "/text", method = RequestMethod.GET)
    public String demoTex() {
        return "basic/text/main";
    }
    
    @RequestMapping(value = "/color-bg-img", method = RequestMethod.GET)
    public String demoColorBackgroundImage() {
        return "basic/color-bg-img/main";
    }
    
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String demoList() {
        return "basic/list/main";
    }
    
    @RequestMapping(value = "/table", method = RequestMethod.GET)
    public String demoTables() {
        return "basic/table/main";
    }

}
