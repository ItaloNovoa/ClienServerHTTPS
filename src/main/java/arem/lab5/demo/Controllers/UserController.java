package arem.lab5.demo.Controllers;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import arem.lab5.demo.POJOS.Usuario;
import arem.lab5.demo.Repository.UserR;

@Controller
public class UserController {
    @Autowired
    UserR userR;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "index2";
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

    @PostMapping("/Ingresar")
    public String Logear(@ModelAttribute Usuario usuario) throws SQLException {
        Boolean b=userR.logear(usuario.getName(), usuario.getLastName());
        if(b){
            return "result";
        }else{
            return "repetido";
        }
        
    }    
}