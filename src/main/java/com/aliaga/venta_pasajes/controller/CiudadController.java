package com.aliaga.venta_pasajes.controller;

import com.aliaga.venta_pasajes.entities.Ciudad;
import com.aliaga.venta_pasajes.service.CiudadService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/ciudades")
public class CiudadController extends BaseControllerImpl<Ciudad, String, CiudadService> {
}
