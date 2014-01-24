package com.springapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class NameController {
    @RequestMapping("/name")
    public String printMyName(ModelMap model) {
        model.addAttribute("name", getMyName());
        return "name";
    }

    public String getMyName() {
        return "RUAN Chonghe";
    }
}
