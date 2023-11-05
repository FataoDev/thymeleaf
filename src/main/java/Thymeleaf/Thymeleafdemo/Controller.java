package Thymeleaf.Thymeleafdemo;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;


@org.springframework.stereotype.Controller
public class Controller {
    @GetMapping("/hello")
    public String hello()
    {
        return "helloworld";
    }

    @GetMapping("/index")
    public String style()
    {
     return "index";
    }

    @GetMapping("/accueil")
    public String accueil(Model model)
    {
        List<User> users= new ArrayList<>();
        users.add(new User("Fatao","fatao@gmail.com","ADMIN"));
        users.add(new User("Ibrahime","ibrahim@gmail.com","USER"));
        users.add(new User("Mahamadi","mahamadi@gmail.com","USER"));
        model.addAttribute("users", users);
        return "accueil";
    }

}
