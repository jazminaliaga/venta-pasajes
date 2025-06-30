package com.aliaga.venta_pasajes.service;

import com.aliaga.venta_pasajes.entities.Consulta;
import com.aliaga.venta_pasajes.entities.Vuelo;
import com.aliaga.venta_pasajes.repository.BaseRepository;
import com.aliaga.venta_pasajes.repository.ConsultaRepository;
import com.aliaga.venta_pasajes.repository.VueloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsultaServiceImpl extends BaseServiceImpl<Consulta, Long> implements ConsultaService {

    @Autowired
    private ConsultaRepository consultaRepository;

    @Autowired
    private VueloRepository vueloRepository;

    public ConsultaServiceImpl(BaseRepository<Consulta, Long> baseRepository) {
        super(baseRepository);
    }

    public Consulta crearConsulta(Consulta consultaParcial) {
        Vuelo vuelo = vueloRepository.findById(consultaParcial.getVuelo().getNumeroVuelo())
                .orElseThrow(() -> new RuntimeException("Vuelo no encontrado"));

        Consulta nuevaConsulta = new Consulta();
        nuevaConsulta.setVuelo(vuelo);

        return consultaRepository.save(nuevaConsulta);
    }
}
