package Thymeleaf.Thymeleafdemo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloWorldController {
    @GetMapping("/hello")
    public String hello(Model model)
    {
        model.addAttribute("message","Hello World");
        return "helloworld";
    }

    @GetMapping("/index")
    public String style()
    {
     return "index";
    }

    @GetMapping("/accueil")
    public String accueil()
    {
        return "accueil";
    }

}
