package ru.alexxip59.final_task.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.alexxip59.final_task.model.User;
import ru.alexxip59.final_task.service.UserService;

import javax.validation.Valid;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String listUsers(Model model) {
        model.addAttribute("users", userService.listUsers());
        return "index";
    }

    @GetMapping("/{id}")
    public String showUser(@PathVariable("id") Long id, Model model) {
        model.addAttribute("user", userService.showUser(id));
        return "user";
    }

    //    @GetMapping("/add")
//    public String addUser(Model model) {
//        model.addAttribute("user", new User());
//        return "add";
//    }
    @GetMapping("/add")
    public String addUser(@ModelAttribute("user") User user) {
        return "add";
    }

    @PostMapping()
    public String create(@ModelAttribute("user") @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "add";

        userService.addUser(user);
        return "redirect:/";
    }

    @GetMapping("/{id}/edit")
    public String updateUser(@PathVariable("id") Long id, Model model) {
        model.addAttribute("user", userService.showUser(id));
        return "update";
    }

    @PatchMapping("/{id}")
    public String update(@PathVariable("id") Long id, @ModelAttribute("user") @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "update";
        userService.updateUser(id, user);
        return "redirect:/";
    }

    @DeleteMapping("/{id}")
    public String remove(@PathVariable("id") Long id) {
        userService.removeUser(id);
        return "redirect:/";
    }

}
