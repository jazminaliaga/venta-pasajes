package com.aliaga.venta_pasajes.service;

import com.aliaga.venta_pasajes.entities.Vuelo;
import com.aliaga.venta_pasajes.repository.BaseRepository;
import com.aliaga.venta_pasajes.repository.VueloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VueloServiceImpl extends BaseServiceImpl<Vuelo, Long> implements VueloService {

    @Autowired
    private VueloRepository vueloRepository;

    public VueloServiceImpl(BaseRepository<Vuelo, Long> baseRepository) {
        super(baseRepository);
    }
}
