package com.aliaga.venta_pasajes.controller;

import com.aliaga.venta_pasajes.entities.Reserva;
import com.aliaga.venta_pasajes.service.ReservaServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/reservas")
public class ReservaController  extends BaseControllerImpl<Reserva, Long, ReservaServiceImpl> {
    @Override
    @PostMapping
    public ResponseEntity<?> save(@RequestBody Reserva reserva) {
        try {
            Reserva nueva = servicio.crearReserva(reserva);
            return ResponseEntity.ok(nueva);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
