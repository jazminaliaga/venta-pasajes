package com.aliaga.venta_pasajes.service;

import com.aliaga.venta_pasajes.entities.Persona;
import com.aliaga.venta_pasajes.repository.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public interface PersonaService extends BaseService<Persona, Long> {
}
