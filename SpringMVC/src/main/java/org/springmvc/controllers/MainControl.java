package org.springmvc.controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/first")
public class MainControl {
    @GetMapping("/hello")
    public String sayHello(HttpServletRequest params) {
        String name = params.getParameter("name");
        String surname = params.getParameter("surname");

        System.out.println("Hello " + name + " " + surname + "!");

        return "first/hello";
    }

    @GetMapping("/goodbye")
    public String sayGoodBye(HttpServletRequest params) {
        String name = params.getParameter("name");
        String surname = params.getParameter("surname");

        System.out.println("GoodBye " + name + " " + surname + "!");

        return "first/goodbye";
    }
}