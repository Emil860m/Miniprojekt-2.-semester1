package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

@Controller
public class HomeController {
    private static ArrayList<VentelisteBørn> vBoern = new ArrayList();
    private static ArrayList<VentelisteBørn> mBoern = new ArrayList();
    private static ArrayList<VentelisteBørn> veBoern = new ArrayList();
    int barnID = 0;

    @GetMapping("/")
    public String index(Model model) {
        if(veBoern.size()<1||mBoern.size()<1) {
            læsFraFil();
        }
        //model.addAttribute("vBoern", vBoern);
        //model.addAttribute("boern", boern);
        //model.addAttribute("ansat", ansat);
        //vBoern.add(new VentelisteBørn("Emil Fenger", "Lygten 37", 12345678, "Micheal Jensen", "Lasse Kjær", 1, true));
        return "Menu";
    }

    @GetMapping("/Menu")
    public String Menu(Model model) {
        //model.addAttribute("vBoern", vBoern);
        return "Menu";
    }

    @GetMapping("/venteliste")
    public String venteliste(Model model) {
        model.addAttribute("veBoern", veBoern);
        return "venteliste";
    }

    @GetMapping("/Telefonliste")
    public String Telefonliste(Model model) {
        model.addAttribute("mBoern", mBoern);
        return "Telefonliste";
    }

    @GetMapping("/edit")
    public String edit(@RequestParam(value = "id", defaultValue = "1") int id, Model model) {
        if (model != null) {
            model.addAttribute("vBoern", vBoern.get(id - 1));
        }
        barnID = id;
        return "edit";
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute VentelisteBørn boern) throws Exception {
        boern.setId(barnID);
        vBoern.set(barnID - 1, boern);
        gemMedlem();

        return "redirect:/venteliste";
    }


    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("VentelisteBørn", new VentelisteBørn());
        return "create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute VentelisteBørn barn) throws Exception {
        int id = vBoern.size() + 1;
        barn.setId(id);
        vBoern.add(barn);
        gemMedlem();
        addToList();
        return "redirect:/venteliste";
    }

    public static void gemMedlem() throws Exception {
        String s = "";
        for (VentelisteBørn vb : vBoern) {

            s += vb.getId() + "," + vb.getNavn() + "," + vb.getTelefonnummer() + "," + vb.getAdresse() + "," + vb.getKontaktperson() + "," + vb.getKontaktperson2() + "," + vb.isStatus() + "\r\n";
        }
        PrintStream output = new PrintStream(new File("src/main/java/com/example/demo/Boern.txt"));
        output.print(s);
        output.close();
    }

    public static void læsFraFil() {
        try {
            Scanner sc = new Scanner(new File("src/main/java/com/example/demo/Boern.txt"));

            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                Scanner readline = new Scanner(line).useDelimiter(",");
                int id = readline.nextInt();
                String navn = readline.next();
                int telefonnummer = readline.nextInt();
                String adresse = readline.next();
                String kontaktperson = readline.next();
                String kontaktperson2 = readline.next();
                boolean status = readline.nextBoolean();
                vBoern.add(new VentelisteBørn(navn, adresse, telefonnummer, kontaktperson, kontaktperson2, id, status));
            }

            sc.close();
        } catch (FileNotFoundException e) {
        }
    loadLister();
    }
    public static void loadLister(){
        for (VentelisteBørn boern : vBoern){
            if(boern.isStatus()){
                mBoern.add(boern);
            }else{
                veBoern.add(boern);
            }
            
        }
    }
    public static void addToList(){
        if(vBoern.get(vBoern.size()-1).isStatus()){
            mBoern.add(vBoern.get(vBoern.size()-1));
        }else{
            veBoern.add(vBoern.get(vBoern.size()-1));
        }
    }
}
