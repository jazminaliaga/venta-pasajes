package com.aliaga.venta_pasajes.controller;

import com.aliaga.venta_pasajes.entities.Tarjeta;
import com.aliaga.venta_pasajes.service.TarjetaServiceImpl;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/tarjetas")
public class TarjetaController  extends BaseControllerImpl<Tarjeta, Long, TarjetaServiceImpl> {
}
