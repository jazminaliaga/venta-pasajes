package com.aliaga.venta_pasajes.repository;

import com.aliaga.venta_pasajes.entities.Usuario;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends BaseRepository<Usuario, Long> {
}
