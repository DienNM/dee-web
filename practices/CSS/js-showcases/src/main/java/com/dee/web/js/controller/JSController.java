package com.dee.web.js.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author dien.nguyen
 **/

@Controller
@RequestMapping("/sample01")
public class JSController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getStudentDetail() {
        return "student_detail";
    }

}
