package com.aliaga.venta_pasajes.controller;

import com.aliaga.venta_pasajes.entities.Aerolinea;
import com.aliaga.venta_pasajes.repository.AerolineaRepository;
import com.aliaga.venta_pasajes.service.AerolineaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/aerolineas")
public class AerolineaController extends BaseControllerImpl<Aerolinea, String, AerolineaService> {

    @Autowired
    private AerolineaRepository aerolineaRepository;

    @GetMapping("/por-aeropuerto")
    public List<Aerolinea> obtenerAerolíneas(
            @RequestParam(required = false) String operanEnAeropuerto) {

        if (operanEnAeropuerto != null) {
            return aerolineaRepository.findAerolíneasPorAeropuerto(operanEnAeropuerto);
        }

        return aerolineaRepository.findAll();
    }
}