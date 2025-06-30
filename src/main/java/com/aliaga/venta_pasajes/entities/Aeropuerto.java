package com.aliaga.venta_pasajes.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "aeropuerto")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Aeropuerto implements Serializable {

    @Id
    private String nombreAeropuerto;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ciudad_id")
    private Ciudad ciudad;
}
