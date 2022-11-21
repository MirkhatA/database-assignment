package com.example.databaseassignment.disease;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DiseaseController {
    private DiseaseService diseaseService;

    public DiseaseController(DiseaseService diseaseService) {
        this.diseaseService = diseaseService;
    }

    // handler method to handle list students and return mode and view
    @GetMapping("/diseases")
    public String listDiseases(Model model) {
        model.addAttribute("diseases", diseaseService.getAllDiseases());
        return "disease";
    }
    @GetMapping("/diseases/new")
    public String createDiseaseForm(Model model) {
        Disease disease=new Disease();
        model.addAttribute("disease",disease);
        return "create_disease";
    }
    //this method redirects to the first getmapping method above
    @PostMapping("/diseases")
    public String saveDisease(@ModelAttribute("disease") Disease disease) {
        diseaseService.saveDisease(disease);
        System.out.println("Disease" + disease.toString());
        return "redirect:/diseases";

    }

    @GetMapping("/diseases/edit/{cname}")
    public String editDiseaseForm(@PathVariable String cname, Model model) {
        model.addAttribute("disease",diseaseService.getDiseaseById(cname));
        return "edit_disease";
    }

    @PostMapping("/diseases/{cname}")
    public String updateDisease(@PathVariable String cname,@ModelAttribute("disease") Disease disease, Model model){
        Disease exisitngDisease=diseaseService.getDiseaseById(cname);
        exisitngDisease.setDiseaseCode(disease.getDiseaseCode());
        exisitngDisease.setPathogen(disease.getPathogen());
        exisitngDisease.setDescription(disease.getDescription());
        exisitngDisease.setId(disease.getId());

        diseaseService.updateDisease(exisitngDisease);
        return "redirect:/diseases";
    }

    @GetMapping("/diseases/{cname}")
    public String deleteDisease(@PathVariable String cname) {
        diseaseService.deleteDiseaseById(cname);
        return "redirect:/diseases";
    }
}
