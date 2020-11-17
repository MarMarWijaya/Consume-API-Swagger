/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.controllers;

import com.example.demo.entities.res.LoginInput;
import com.example.demo.services.LoginRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author Mario Wijaya
 */
@Controller
public class LoginRestController {
    @Autowired 
    LoginRestService service;
    
    @GetMapping("")
    public String index(Model model){
        model.addAttribute("logininput",new LoginInput());
        return "login";
    }
    
    @PostMapping("home")
    public String login(LoginInput input) {
        System.out.println(input);
        System.out.println(service.login(input));
        getId.id = service.getId(service.login(input));
        return "redirect:/basic";
    }
}
