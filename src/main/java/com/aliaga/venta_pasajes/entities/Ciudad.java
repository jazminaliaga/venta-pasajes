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
@Table(name = "ciudad")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Ciudad implements Serializable {

    @Id
    private String nombreCiudad;
}
