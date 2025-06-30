package com.aliaga.venta_pasajes.controller;

import com.aliaga.venta_pasajes.entities.Aeropuerto;
import com.aliaga.venta_pasajes.repository.AeropuertoRepository;
import com.aliaga.venta_pasajes.service.AeropuertoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/aeropuertos")
public class AeropuertoController extends BaseControllerImpl<Aeropuerto, String, AeropuertoService> {

    @Autowired
    private AeropuertoRepository aeropuertoRepository;

    @GetMapping("/por-ciudad")
    public List<Aeropuerto> obtenerAeropuertosPorCiudad(@RequestParam String ciudad) {
        return aeropuertoRepository.findByCiudad(ciudad);
    }

}
