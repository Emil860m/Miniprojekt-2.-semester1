package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

@Controller
public class HomeController {
    private ArrayList<VentelisteBørn> vBoern = new ArrayList();
    private ArrayList<Boern> boern = new ArrayList();
    private ArrayList<Ansat> ansat = new ArrayList();

    @GetMapping("/")
    public String index(Model model){

        model.addAttribute("vBoern", vBoern);
        model.addAttribute("boern", boern);
        model.addAttribute("ansat", ansat);
        return "Menu";
    }


}
