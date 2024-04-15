package org.springmvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/second")
public class SecondController {
    @GetMapping("/calculate")
    public String calculateNumbers(@RequestParam("a") double a, @RequestParam("b") double b,
                                   @RequestParam("action") String action,  Model model) {

        double result;

        switch(action) {
            case "addition":
                result = a + b;
                break;
            case "subtraction":
                result = a - b;
                break;
            case "multiplication":
                result = a * b;
                break;
            case "division":
                result = a / b;
                break;
            default:
                System.out.println("Вы ввели некорректный параметр!");
                throw new IllegalArgumentException();
        }

        model.addAttribute("resultMessage", "Calculation result: " + result);

        return "second/calculate";
    }

    @GetMapping("/exit")
    public String exit() { return "second/exit"; }


}
