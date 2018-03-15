package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.File;
import java.io.PrintStream;
import java.util.ArrayList;

@Controller
public class HomeController {
    private ArrayList<VentelisteBørn> vBoern = new ArrayList();
  //  private ArrayList<Boern> boern = new ArrayList();
 //   private ArrayList<Ansat> ansat = new ArrayList();
    int barnID = 0;
    @GetMapping("/")
    public String index(Model model){
        læsFraFil();
        //model.addAttribute("vBoern", vBoern);
        //model.addAttribute("boern", boern);
        //model.addAttribute("ansat", ansat);
        //vBoern.add(new VentelisteBørn("Emil Fenger", "Lygten 37", 12345678, "Micheal Jensen", "Lasse Kjær", 1, true));
        return "venteliste";
    }
    @GetMapping("/venteliste")
    public String venteliste(Model model){
        model.addAttribute("vBoern", vBoern);
        return "venteliste";
    }
    @GetMapping("/Telefonliste")
    public String Telefonliste(Model model){
        model.addAttribute("vBoern", vBoern);
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
    public String edit(@ModelAttribute VentelisteBørn boern) {
        boern.setId(barnID);
        vBoern.set(barnID - 1,boern);
        return "redirect:/venteliste";
    }


    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("VentelisteBørn", new VentelisteBørn());
        return "create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute VentelisteBørn barn)throws Exception{
        int  id   =   vBoern.size() + 1;
        barn.setId(id);
        vBoern.add(barn);
        gemMedlem(vBoern);
        return   "redirect:/venteliste";
    }
    public static void gemMedlem(ArrayList<VentelisteBørn> vBoern) throws Exception{
        String s = "";
        for(VentelisteBørn vb : vBoern){

            s += vb.getId()+ "," + vb.getNavn() + "," + vb.getTelefonnummer() + "," + vb.getAdresse() + "," + vb.getKontaktperson() + "," + vb.getKontaktperson2() + "," + vb.isStatus() + "\r\n";
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

}
