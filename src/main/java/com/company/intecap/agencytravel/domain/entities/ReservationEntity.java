package com.company.intecap.agencytravel.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.UUID;

@Entity(name = "reservation")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReservationEntity implements Serializable {
    @Id
    @GeneratedValue
    @Column(length = 200) //tamaño maximo de la columna
    private UUID id;

    private LocalDateTime dateReservation;
    private LocalDateTime dateStart;//fecha de inicio
    private LocalDateTime dateEnd;//fecha de finalizacion
    private Integer totalDays;
    private BigDecimal price;

    @ManyToOne // para que se cree una relacion de muchos a uno
    @JoinColumn(name = "hotel_id")
    private HotelEntity hotel;


    //reservation a tour(Muchos a uno)
    @ManyToOne
    @JoinColumn(name = "tour_id")
    private TourEntity tour;

    //reservation a customer(Muchos a uno)
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private CustomerEntity customer;

}
