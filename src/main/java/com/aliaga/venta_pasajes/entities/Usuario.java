package com.aliaga.venta_pasajes.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "usuario")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Usuario extends Persona {

    private long numeroUsuario;
    private String contrasenaUsuario;
    private String correoUsuario;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "usuario_tarifas",
            joinColumns = @JoinColumn(name = "usuario_id"),
            inverseJoinColumns = @JoinColumn(name = "tarifa_id")
    )
    private List<Tarjeta> tarjetas;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "usuario_consulta",
            joinColumns = @JoinColumn(name = "usuario_id"),
            inverseJoinColumns = @JoinColumn(name = "consulta_id")
    )
    private List<Consulta> consultas;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "usuario_reserva",
            joinColumns = @JoinColumn(name = "usuario_id"),
            inverseJoinColumns = @JoinColumn(name = "reserva_id")
    )
    private List<Reserva> reservas;

    public Usuario(long dniPersona, String nombrePersona, String apellidoPersona, long numeroUsuario) {
        super(dniPersona, nombrePersona, apellidoPersona);
        this.numeroUsuario = numeroUsuario;
    }
}
