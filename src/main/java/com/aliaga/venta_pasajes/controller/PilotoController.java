package com.aliaga.venta_pasajes.controller;

import com.aliaga.venta_pasajes.entities.Piloto;
import com.aliaga.venta_pasajes.service.PilotoServiceImpl;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/pilotos")
public class PilotoController  extends BaseControllerImpl<Piloto, Long, PilotoServiceImpl> {
}
