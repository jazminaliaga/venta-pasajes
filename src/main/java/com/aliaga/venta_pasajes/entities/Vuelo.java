package com.aliaga.venta_pasajes.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "vuelo")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Vuelo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long numeroVuelo;

    @ManyToOne
    private Avion avion;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "vuelo_aeropuertos",
            joinColumns = @JoinColumn(name = "vuelo_id"),
            inverseJoinColumns = @JoinColumn(name = "aeropuerto_id")
    )
    private List<Aeropuerto> aeropuertos = new ArrayList<>();

    @ManyToOne
    private Piloto piloto;

    @ManyToOne(cascade = CascadeType.ALL)
    private Fecha fecha;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "vuelo_tarifas",
            joinColumns = @JoinColumn(name = "vuelo_id"),
            inverseJoinColumns = @JoinColumn(name = "tarifa_id")
    )
    private List<Tarifa> tarifas;

    @ManyToOne
    private Aerolinea aerolinea;

    public Vuelo(long numeroVuelo, Avion avion, Piloto piloto, Fecha fecha) {
        this.numeroVuelo = numeroVuelo;
        this.avion = avion;
        this.piloto = piloto;
        this.fecha = fecha;
        this.aeropuertos = new ArrayList<>();
        this.tarifas = new ArrayList<>();
    }

    public void addAeropuerto(Aeropuerto aeropuerto) {
        if (this.aeropuertos == null) {
            this.aeropuertos = new ArrayList<>();
        }
        if (!this.aeropuertos.contains(aeropuerto)) {
            this.aeropuertos.add(aeropuerto);
        }
    }

}
