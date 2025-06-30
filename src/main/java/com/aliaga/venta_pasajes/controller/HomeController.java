package com.aliaga.venta_pasajes.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "index"; // templates/index.html
    }

    @GetMapping("/reserva")
    public String reservar() {
        return "reserva"; // templates/reserva.html
    }
}