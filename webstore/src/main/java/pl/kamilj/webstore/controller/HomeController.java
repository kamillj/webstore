package pl.kamilj.webstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("greeting", "Welcome in our webstore!");
        model.addAttribute("tagline", "Hava a nice shopping!");

        return "index";
    }

    //test  forward i redirect
    @RequestMapping("/welcome/greeting")
    public String greeting(){
        return "index";
    }
}