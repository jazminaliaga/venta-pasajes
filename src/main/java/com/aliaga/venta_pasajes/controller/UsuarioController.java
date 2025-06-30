package com.aliaga.venta_pasajes.controller;

import com.aliaga.venta_pasajes.entities.Usuario;
import com.aliaga.venta_pasajes.service.UsuarioServiceImpl;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/usuarios")
public class UsuarioController  extends BaseControllerImpl<Usuario, Long, UsuarioServiceImpl> {
}
