package com.aliaga.venta_pasajes.controller;

import com.aliaga.venta_pasajes.entities.Consulta;
import com.aliaga.venta_pasajes.service.ConsultaServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/consultas")
public class ConsultaController extends BaseControllerImpl<Consulta, Long, ConsultaServiceImpl> {

    @Override
    @PostMapping
    public ResponseEntity<?> save(@RequestBody Consulta consulta) {
        try {
            Consulta nueva = servicio.crearConsulta(consulta);
            return ResponseEntity.ok(nueva);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
