package com.example.databaseassignment.country;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CountryController {

    private CountryService countryService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    // handler method to handle list students and return mode and view
    @GetMapping("/countrys")
    public String listCountries(Model model) {
        model.addAttribute("countrys", countryService.getAllCountries());
        return "country";
    }
    @GetMapping("/countrys/new")
    public String createCountryForm(Model model) {
        Country country=new Country();
        model.addAttribute("country",country);
        return "create_country";
    }
    //this method redirects to the first getmapping method above
    @PostMapping("/countrys")
    public String saveCountry(@ModelAttribute("country") Country country) {
        countryService.saveCountry(country);
        System.out.println("COUNTRY" + country.toString());
        return "redirect:/countrys";

    }

    @GetMapping("/countrys/edit/{disease_code}")
    public String editCountryForm(@PathVariable String disease_code, Model model) {
        model.addAttribute("country",countryService.getCountryById(disease_code));
        return "edit_country";
    }

    @PostMapping("/countrys/{disease_code}")
    public String updateCountry(@PathVariable String disease_code,@ModelAttribute("country") Country country, Model model){
        Country exisitngCountry=countryService.getCountryById(disease_code);
        exisitngCountry.setCname(country.getCname());
        exisitngCountry.setPopulation(country.getPopulation());

        countryService.updateCountry(exisitngCountry);
        return "redirect:/countrys";
    }

    @GetMapping("/countrys/{disease_code}")
    public String deleteCountry(@PathVariable String disease_code) {
        countryService.deleteCountryById(disease_code);
        return "redirect:/countrys";
    }

}
