package com.aliaga.venta_pasajes.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Table(name = "tarifa")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Tarifa implements Serializable {

    @Id
    private long numeroTarifa;

    private int impuestoTarifa;
    private int precioTarifa;
    private String claseTarifa;
}
