
package com.example.demo.controllers;

import com.example.demo.entities.res.LoginInput;
import com.example.demo.entities.res.RegisterUser;
import com.example.demo.services.RegistrationRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author Mario Wijaya
 */
@Controller
public class RegistrationRestController {
    @Autowired
    RegistrationRestService service;
    
    @GetMapping("register")
    public String regris(Model model){
        model.addAttribute("registrasi",new RegisterUser());
        return "account";
    }
    
    @PostMapping("save")
    public String register(RegisterUser input){
         System.out.println(input);
         System.out.println(service.register(input));
         return "redirect:/";
    }
}
