package Thymeleaf.Thymeleafdemo.controller;

import Thymeleaf.Thymeleafdemo.entity.Employee;
import Thymeleaf.Thymeleafdemo.service.EmpService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private EmpService empService;

    @GetMapping("/")
    public String index(Model m)
    {
        List<Employee> list = empService.getAllEmp();
        m.addAttribute("empList",list);
        return "index";
    }

    @GetMapping("/loadEmpSave")
    public String loadEmpSave()
    {
        return "emp_save";
    }

    @GetMapping("/editEmp/{id}")
    public String editEmp(@PathVariable int id, Model m)
    {
        Employee emp = empService.getEmpById(id);
        m.addAttribute("emp",emp);
        return "edit_emp";
    }

    @PostMapping("/saveEmp")
    public String saveEmp(@ModelAttribute Employee emp, HttpSession session)
    {
        Employee newEmp = empService.saveEmp(emp);
        if (newEmp !=null)
        {
            //System.out.println("Employée enrégistré avec succes");
            session.setAttribute("msg","Employée enrégistré avec succes");
        }
        else
        {
            //System.out.println("Une erreur s'est produit ; Employé non enregistré");
            session.setAttribute("msg","Une erreur s'est produit ; Employé non enregistré");
        }
        //System.out.println(emp);
        return "redirect:/loadEmpSave";
    }


    @PostMapping("/updateEmpId")
    public String updateEmpId(@ModelAttribute Employee emp, HttpSession session)
    {
        Employee newEmp = empService.saveEmp(emp);
        if (newEmp !=null)
        {
            //System.out.println("Employée modifié avec succes");
            session.setAttribute("msg","Employée enrégistré avec succes");
        }
        else
        {
            //System.out.println("Une erreur s'est produit ; Employé non modifié");
            session.setAttribute("msg","Une erreur s'est produit ; Employé non modifié");
        }
        //System.out.println(emp);
        return "redirect:/";
    }

    @GetMapping("/deleteEmp/{id}")
    public String deleteEmp(@PathVariable int id,HttpSession session)
    {
        boolean d = empService.deleteEmp(id);
        if (d)
        {
            session.setAttribute("msg","Employée supprimer avec succes");
        } else
        {
            session.setAttribute("msg","Une erreur s'est produit ; Employé non supprimé");
        }
        return "redirect:/";
    }

}
