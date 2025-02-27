package com.example.student;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class CustomErrorController implements ErrorController {

    @RequestMapping("/error")
    public String handleError() {
        // Retourner une page d'erreur personnalisée (par exemple, une page HTML ou un message)
        return "error";  // Renvoie la vue error.html si tu utilises Thymeleaf ou un moteur de template
    }
}