package com.example.demo.controllers;

import com.example.demo.entities.Person;
import com.example.demo.services.PersonRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("person")
@Controller
public class PersonRestController {

    @Autowired
    PersonRestService service;

    @GetMapping("")
    public String index(Model model) {
        model.addAttribute("people", service.getAll());
        model.addAttribute("person", new Person());
        return "index";
    }

    @GetMapping("/all")
    public String getAll(Model model) {
        model.addAttribute("people", service.getAll());
        model.addAttribute("person", new Person());
        return "index";
    }

    @PostMapping("save")
    public String save(Person person) {
        service.save(person);
        return "redirect:/";
    }

    @GetMapping("/{id}")
    public String getById(Model model, @PathVariable("id") String id) {
        model.addAttribute("person", service.getById(id));
        model.addAttribute("people", service.getAll());
        return "index";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteById(@PathVariable("id") String Id){
        service.deleteById(Id);
        return "index";
    }  

    @GetMapping("/male")
    public String getMaleGender(Model model) {
        model.addAttribute("person", new Person());
        model.addAttribute("people", service.getMaleGender("Male"));
        return "index";
    }

    @GetMapping("/female")
    public String getFemaleGender(Model model) {
        model.addAttribute("person", new Person());
        model.addAttribute("people", service.getFemaleGender("Female"));
        return "index";
    }
}
