package com.aliaga.venta_pasajes.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "avion")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Avion implements Serializable {

    @Id
    private long numeroAvion;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "avion_asientos",
            joinColumns = @JoinColumn(name = "avion_id"),
            inverseJoinColumns = @JoinColumn(name = "asiento_id")
    )
    @JsonManagedReference
    private List<Asiento> asientos = new ArrayList<>();

    public Avion(long numeroAvion) {
        this.numeroAvion = numeroAvion;
        this.asientos = new ArrayList<>();
    }

    public void addAsiento(Asiento asiento) {
        asiento.setAvion(this);
        this.asientos.add(asiento);
    }
}
