package com.ran.springbootmysqlrediscache;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class MyController {

    @Autowired
    private ICityService cityService;

    @GetMapping("/cities")
    public String findCities(Model model) {

        var cities = (List<City>) cityService.findAll();

        model.addAttribute("cities", cities);

        return "showCities";
    }

    @GetMapping("/cities/{id}")
    public String findCity(@PathVariable Long id, Model model) {

        City city = cityService.findById(id, ""+id);

        model.addAttribute("city", city);

        return "city";
    }
}