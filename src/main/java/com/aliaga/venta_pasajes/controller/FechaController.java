package com.aliaga.venta_pasajes.controller;

import com.aliaga.venta_pasajes.entities.Fecha;
import com.aliaga.venta_pasajes.service.FechaServiceImpl;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/fechas")
public class FechaController  extends BaseControllerImpl<Fecha, Long, FechaServiceImpl> {
}
