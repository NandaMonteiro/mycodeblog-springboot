package com.spring.codeblog.controller;

import com.spring.codeblog.model.Usuario;
import com.spring.codeblog.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String getPaginaLogin(){
        return "login";
    }

    @RequestMapping(value = "/usuarioForm", method = RequestMethod.GET)
    public String getLoginForm(){
        return "usuarioForm";
    }

    @RequestMapping(value = "/usuarioForm", method = RequestMethod.POST)
    public String saveUsuario(@Valid Usuario usuario, BindingResult result, RedirectAttributes redirectAttributes){
        if(result.hasErrors()){
            redirectAttributes.addFlashAttribute("mensagem", "Verifique se os campos obrigatórios foram preenchidos!");
            return "redirect:/usuarioForm";
        }

        if(!validaLoginUsuario(usuario)){
            redirectAttributes.addFlashAttribute("mensagem", "Já existe usuário cadastrado com esse login");
            return "redirect:/usuarioForm";
        }

        usuario.setSenha(new BCryptPasswordEncoder().encode(usuario.getSenha()));
        usuarioService.saveUsuario(usuario);
        return "redirect:/posts";
    }

    private boolean validaLoginUsuario(Usuario usuario){
        List<Usuario> usuarioList=usuarioService.usuarioList();
        boolean validacao = true;
        for(Usuario use:usuarioList){
            if(use.getLogin().equalsIgnoreCase(usuario.getLogin())){
                validacao = false;
            }
        }
        return validacao;
    }
}
