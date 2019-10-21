package arem.lab5.demo.Controllers;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    @Autowired
    UserR userR;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "index";
    }

    @PostMapping("/")
    public String userSubmit(@ModelAttribute Usuario usuario) throws SQLException {
        Boolean b=userR.añadirUsuario(usuario.getName(), usuario.getLastName());
        if(b){
            return "result";
        }else{
            return "repetido";
        }
        
    }
    
}