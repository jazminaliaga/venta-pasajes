package com.aliaga.venta_pasajes.config;

import com.aliaga.venta_pasajes.entities.*;
import com.aliaga.venta_pasajes.repository.*;
import jakarta.transaction.Transactional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class DataInitializer implements CommandLineRunner {

    private final CiudadRepository ciudadRepository;
    private final AeropuertoRepository aeropuertoRepository;
    private final AerolineaRepository aerolineaRepository;
    private final AvionRepository avionRepository;
    private final FechaRepository fechaRepository;
    private final PilotoRepository pilotoRepository;
    private final UsuarioRepository usuarioRepository;
    private final VueloRepository vueloRepository;
    private final TarifaRepository tarifaRepository;

    public DataInitializer(CiudadRepository ciudadRepository, AeropuertoRepository aeropuertoRepository,
                           AerolineaRepository aerolineaRepository, AvionRepository avionRepository, FechaRepository fechaRepository,
                           PilotoRepository pilotoRepository, UsuarioRepository usuarioRepository,
                           VueloRepository vueloRepository, TarifaRepository tarifaRepository) {
        this.ciudadRepository = ciudadRepository;
        this.aeropuertoRepository = aeropuertoRepository;
        this.aerolineaRepository = aerolineaRepository;
        this.avionRepository = avionRepository;
        this.fechaRepository = fechaRepository;
        this.pilotoRepository = pilotoRepository;
        this.usuarioRepository = usuarioRepository;
        this.vueloRepository = vueloRepository;
        this.tarifaRepository = tarifaRepository;
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {

        if (ciudadRepository.count() == 0) {
            // --- Ciudades ---
            Ciudad mendoza = ciudadRepository.save(new Ciudad("Mendoza"));
            Ciudad cordoba = ciudadRepository.save(new Ciudad("Cordoba"));
            Ciudad bsas = ciudadRepository.save(new Ciudad("Buenos Aires"));

            // --- Aeropuertos ---
            Aeropuerto a1 = aeropuertoRepository.save(new Aeropuerto("Aeropuerto Internacional El Plumerillo", mendoza));
            Aeropuerto a2 = aeropuertoRepository.save(new Aeropuerto("Aeropuerto Internacional Ingeniero Aeronáutico Ambrosio Taravella", cordoba));
            Aeropuerto a3 = aeropuertoRepository.save(new Aeropuerto("Aeropuerto Internacional Ezeiza", bsas));
            Aeropuerto a4 = aeropuertoRepository.save(new Aeropuerto("Aeroparque Internacional Jorge Newbery", bsas));

            // --- Aerolíneas ---
            Aerolinea ar = aerolineaRepository.save(new Aerolinea("Aerolineas Argentinas"));
            Aerolinea fb = aerolineaRepository.save(new Aerolinea("FlyBondi"));

            // --- Aviones y Asientos ---
            Avion avion1 = new Avion(131);
            configurarAsientosGenerico(avion1, 3, 'A', 'C', 6);
            avionRepository.save(avion1);

            Avion avion2 = new Avion(626);
            configurarAsientosGenerico(avion2, 2, 'D', 'F', 4);
            avionRepository.save(avion2);

            // --- Fecha ---
            Fecha fecha = new Fecha();
            fecha.setFecha(new Date());
            fecha = fechaRepository.save(fecha);

            // --- Pilotos ---
            Piloto p1 = pilotoRepository.save(new Piloto(12345678, "Lucas", "Alvarez", 111));
            Piloto p2 = pilotoRepository.save(new Piloto(23456789, "Pedro", "Coria", 222));
            Piloto p3 = pilotoRepository.save(new Piloto(34567891, "Nicolas", "Juarez", 333));
            Piloto p4 = pilotoRepository.save(new Piloto(45678912, "Juan", "Perez", 444));

            // --- Usuario ---
            usuarioRepository.save(new Usuario(56789123, "Pedro", "Martinez", 555));

            // Crear tarifa única
            if (tarifaRepository.count() == 0) {
                Tarifa tarifaUnica = new Tarifa();
                tarifaUnica.setPrecioTarifa(50000);
                tarifaUnica.setImpuestoTarifa(5000);
                tarifaUnica.setClaseTarifa("GENERAL");
                tarifaRepository.save(tarifaUnica);
            }
        }
    }

    private void configurarAsientosGenerico(Avion avion, int filas, char filaInicial, char filaFinal, int columnas) {
        for (char fila = filaInicial; fila <= filaFinal; fila++) {
            for (int col = 1; col <= columnas; col++) {
                avion.addAsiento(new Asiento(0, col, String.valueOf(fila), null));
            }
        }
    }


}
