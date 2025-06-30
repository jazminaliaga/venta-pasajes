package com.aliaga.venta_pasajes.service;

import com.aliaga.venta_pasajes.entities.Pago;
import com.aliaga.venta_pasajes.entities.Reserva;
import com.aliaga.venta_pasajes.entities.Vuelo;
import com.aliaga.venta_pasajes.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservaServiceImpl extends BaseServiceImpl<Reserva, Long> implements ReservaService {
    @Autowired
    private ReservaRepository reservaRepository;

    @Autowired
    private PagoRepository pagoRepository;

    @Autowired
    private VueloRepository vueloRepository;

    public ReservaServiceImpl(BaseRepository<Reserva, Long> baseRepository) {
        super(baseRepository);
    }

    @Override
    public Reserva crearReserva(Reserva reservaParcial) {
        Pago pago = pagoRepository.findById(reservaParcial.getPago().getNumeroPago())
                .orElseThrow(() -> new RuntimeException("Pago no encontrado"));

        Vuelo vuelo = vueloRepository.findById(reservaParcial.getVueloReservado().getNumeroVuelo())
                .orElseThrow(() -> new RuntimeException("Vuelo no encontrado"));

        Reserva nuevaReserva = new Reserva();
        nuevaReserva.setPago(pago);
        nuevaReserva.setVueloReservado(vuelo);

        return reservaRepository.save(nuevaReserva);
    }
}
