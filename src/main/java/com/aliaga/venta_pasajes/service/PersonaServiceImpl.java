package com.aliaga.venta_pasajes.service;

import com.aliaga.venta_pasajes.entities.Persona;
import com.aliaga.venta_pasajes.repository.BaseRepository;
import com.aliaga.venta_pasajes.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaServiceImpl extends BaseServiceImpl<Persona, Long> implements PersonaService {
    @Autowired
    private PersonaRepository personaRepository;

    public PersonaServiceImpl(BaseRepository<Persona, Long> baseRepository) {
        super(baseRepository);
    }
}
