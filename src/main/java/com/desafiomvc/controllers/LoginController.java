package com.desafiomvc.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.desafiomvc.entities.User;
import com.desafiomvc.services.IUserService;
import com.desafiomvc.web.UserRegistrationDto;

import org.springframework.ui.Model;

@Controller
public class LoginController {


    @Autowired
    private IUserService userService;


    @GetMapping("/login")
    public String login(Model model) {

        return "admin/auth/login";
    }

    @GetMapping("/register")
    public String register(Model model) {
        UserRegistrationDto userRegistrationDto = new UserRegistrationDto();
        model.addAttribute("userRegistrationDto", userRegistrationDto);

        return "admin/auth/register";
    }
    @PostMapping("/register")
    public String registerUserAccount(@Valid @ModelAttribute("userRegistrationDto") UserRegistrationDto userRegistrationDto, BindingResult result, Model model) {
        model.addAttribute("userRegistrationDto", userRegistrationDto);

        User userExists = userService.findByUsername(userRegistrationDto.getUserName());

        //System.out.println("user-->"+userRegistrationDto.getUserName());
        //System.out.println("userExists-->"+userExists);

        if (userExists != null) {
            return "redirect:/register?username";
        }
        if(result.hasErrors()){
            return "admin/auth/register";
        }
        userService.save(userRegistrationDto);
        return "redirect:/register?success";
    }

}