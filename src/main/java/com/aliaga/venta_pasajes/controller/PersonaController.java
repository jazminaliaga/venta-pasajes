package com.aliaga.venta_pasajes.controller;

import com.aliaga.venta_pasajes.entities.Persona;
import com.aliaga.venta_pasajes.service.PersonaServiceImpl;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/personas")
public class PersonaController  extends BaseControllerImpl<Persona, Long, PersonaServiceImpl> {
}
