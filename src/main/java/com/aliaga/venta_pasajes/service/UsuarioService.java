package com.aliaga.venta_pasajes.service;

import com.aliaga.venta_pasajes.entities.Usuario;
import com.aliaga.venta_pasajes.repository.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public interface UsuarioService extends BaseService<Usuario, Long> {
}
