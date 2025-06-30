package com.aliaga.venta_pasajes.controller;

import com.aliaga.venta_pasajes.entities.Asiento;
import com.aliaga.venta_pasajes.service.AsientoServiceImpl;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/asientos")
public class AsientoController extends BaseControllerImpl<Asiento, Long, AsientoServiceImpl> {
}
