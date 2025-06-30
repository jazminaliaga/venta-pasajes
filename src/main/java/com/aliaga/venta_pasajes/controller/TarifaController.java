package com.aliaga.venta_pasajes.controller;

import com.aliaga.venta_pasajes.entities.Tarifa;
import com.aliaga.venta_pasajes.service.TarifaServiceImpl;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/tarifas")
public class TarifaController  extends BaseControllerImpl<Tarifa, Long, TarifaServiceImpl> {
}
