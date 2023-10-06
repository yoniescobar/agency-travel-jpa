package com.company.intecap.agencytravel.domain.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Set;

@Entity(name = "tour")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class TourEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    //tour a tiket (1 a muchos)
    @OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            orphanRemoval = true,
            mappedBy = "tour"
    )
    private Set<TicketEntity> tickets;


    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    //tour a reservation (1 a muchos)
    @OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            orphanRemoval = true,
            mappedBy = "tour"
    )
    private Set<ReservationEntity> reservations;

    //tour a Customer (muchos a 1)
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private CustomerEntity customer;

}
