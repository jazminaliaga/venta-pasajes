package com.aliaga.venta_pasajes.controller;

import com.aliaga.venta_pasajes.entities.Avion;
import com.aliaga.venta_pasajes.service.AvionServiceImpl;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/aviones")
public class AvionController extends BaseControllerImpl<Avion, Long, AvionServiceImpl> {
}
