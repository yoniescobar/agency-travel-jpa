package com.company.intecap.agencytravel.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Entity(name = "ticket")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TicketEntity implements Serializable {

    @Id
    @GeneratedValue
    @Column(length = 200) //tamaño maximo de la columna
    private UUID id;

    private LocalDate departureDate; //formato: 2021-09-01 fecha de salida
    private LocalDate arrivalDate; // fecha de llegada
    private LocalDate purchaseDate; // fecha de compra
    private BigDecimal price;

    //ticket a fly(Muchos a uno)
    //Muchos tickets pueden pertenecer a un solo vuelo
    @ManyToOne // para que se cree una relacion de muchos a uno
    @JoinColumn(name = "fly_id") // para que se cree una columna en la tabla ticket con el nombre fly_id
    private FlyEntity fly;


    //ticket a tour(Muchos a uno)
    @ManyToOne
    @JoinColumn(name = "tour_id")
    private TourEntity tour;

    //ticket a customer(Muchos a uno)
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private CustomerEntity customer;

}
