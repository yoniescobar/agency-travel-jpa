package com.company.intecap.agencytravel.domain.entities;


import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Set;

@Entity(name = "customer")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class CustomerEntity implements Serializable {

    @Id
    private String dni;
    @Column(length = 50)
    private String fullName;
    @Column(length = 50)
    private String creditCard;
    @Column(length = 12)
    private String phoneNumber;
    private Integer totalFlights; // total de vuelos
    private Integer totalLodgings; // total de alojamientos
    private Integer totalTours; // total de tours

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    //customer a tour (1 a muchos)
    @OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            orphanRemoval = true,
            mappedBy = "customer" // el nombre del atributo en la clase ReservationEntity
    )
    private Set<TourEntity> tours;


    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    //customer a ticket (1 a muchos)
    @OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            orphanRemoval = true,
            mappedBy = "customer" // el nombre del atributo en la clase ReservationEntity
    )
    private Set<TicketEntity> tickets;


    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    //customer a reservation (1 a muchos)
    @OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            orphanRemoval = true,
            mappedBy = "customer" // el nombre del atributo en la clase ReservationEntity
    )
    private Set<ReservationEntity> reservations;

}

