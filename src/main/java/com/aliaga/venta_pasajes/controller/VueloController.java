package com.aliaga.venta_pasajes.controller;

import com.aliaga.venta_pasajes.entities.Vuelo;
import com.aliaga.venta_pasajes.repository.VueloRepository;
import com.aliaga.venta_pasajes.service.VueloServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/vuelos")
public class VueloController extends BaseControllerImpl<Vuelo, Long, VueloServiceImpl> {

    @Autowired
    private VueloRepository vueloRepository;

    @GetMapping("/buscar")
    public List<Vuelo> buscarVuelos(@RequestParam(required = false) String aerolinea) {
        if (aerolinea != null) {
            return vueloRepository.findByAerolineaWithAeropuertosAndCiudad(aerolinea);
        }
        return vueloRepository.findAllWithAeropuertosAndCiudad();
    }

}
