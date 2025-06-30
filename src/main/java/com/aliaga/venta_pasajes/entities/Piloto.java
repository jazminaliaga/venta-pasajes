package com.aliaga.venta_pasajes.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "piloto")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Piloto extends Persona {

    private long numeroPiloto;

    public Piloto(long dniPersona, String nombrePersona, String apellidoPersona, long numeroPiloto) {
        super(dniPersona, nombrePersona, apellidoPersona);
        this.numeroPiloto = numeroPiloto;
    }
}
