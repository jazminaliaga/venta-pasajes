package com.aliaga.venta_pasajes.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Table(name = "asiento")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Asiento implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private int filaAsiento;
    private String letraAsiento;

    @ManyToOne
    @JoinColumn(name = "avion_id")
    @JsonBackReference
    private Avion avion;
}
