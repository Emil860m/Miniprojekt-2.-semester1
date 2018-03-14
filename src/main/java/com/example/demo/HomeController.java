package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class HomeController {
    private ArrayList<VentelisteBørn> vBoern = new ArrayList();
    private ArrayList<Boern> boern = new ArrayList();
    private ArrayList<Ansat> ansat = new ArrayList();

    @GetMapping("/")
    public String index(Model model){

        model.addAttribute("vBoern", vBoern);
        //model.addAttribute("boern", boern);
        //model.addAttribute("ansat", ansat);
        vBoern.add(new VentelisteBørn("Emil Fenger", "Lygten 37", 12345678, "Micheal Jensen", "Lasse Kjær", 1, true));
        return "venteliste";
    }
    /*
    @GetMapping("/rediger")
    public String edit(@RequestParam(value = "id", defaultValue = "1") int id, Model model) {
        int selectedStudentID = 0;
        for (int i = 0; i < vBoern.size(); i++) {
            if (vBoern.get(i).getId() == id) {
                selectedStudentID = i;
            }
        }

        model.addAttribute("boern", vBoern.get(selectedStudentID));
        return "rediger";
    }

    @PostMapping("/rediger")
    public String rediger(@ModelAttribute VentelisteBørn boern) {
        for (int i = 0; i < vBoern.size(); i++) {
            if (boern.getId() == vBoern.get(i).getId()) {
                // DEBUG -- Print the id of student to delete System.out.println(students.get(i).getStudentID());
                vBoern.set(i,boern);
                break;
            } else {
                //DEBUG -- Print while not finding the correct ID System.out.println("Could not find it::");
            }
        }
       /* int index = student.getStudentID();
        student.setStudentID(index);
        students.set(index - 1, student);
        return "redirect:/";
    }*/

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("VentelisteBørn", new VentelisteBørn());
        return "create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute VentelisteBørn barn)   {
        int  id   =   vBoern.size() + 1;
        barn.setId(id);
        vBoern.add(barn);
        return   "redirect:/";
    }

}
