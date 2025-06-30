package com.aliaga.venta_pasajes.controller;

import com.aliaga.venta_pasajes.entities.Pago;
import com.aliaga.venta_pasajes.service.PagoServiceImpl;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/pagos")
public class PagoController extends BaseControllerImpl<Pago, Long, PagoServiceImpl> {
}
