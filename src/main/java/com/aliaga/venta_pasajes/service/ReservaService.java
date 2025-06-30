package com.aliaga.venta_pasajes.service;

import com.aliaga.venta_pasajes.entities.Reserva;
import com.aliaga.venta_pasajes.repository.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public interface ReservaService extends BaseService<Reserva, Long> {
    Reserva crearReserva(Reserva reservaParcial);
}
