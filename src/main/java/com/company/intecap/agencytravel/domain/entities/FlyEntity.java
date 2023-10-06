package com.company.intecap.agencytravel.domain.entities;

import com.company.intecap.agencytravel.utils.AeroLine;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;

@Entity(name = "fly")//nombre de la tabla en la base de datos
@Data // para que se creen los getters y setters automaticamente
@NoArgsConstructor // para que no sea necesario crear un constructor vacio
@AllArgsConstructor // para que se cree un constructor con todos los atributos de la clase
@Builder // para que se cree un constructor con todos los atributos
public class FlyEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double originLat;
    private Double originLng;
    private Double destinyLat;
    private BigDecimal price;
    @Column(length = 20)
    private String originName;
    @Column(length = 20)
    private String destinyName;

    @Enumerated(EnumType.STRING)
    private AeroLine aeroLine;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(
            cascade = CascadeType.ALL, // si se elimina un vuelo se eliminan todos los tickets relacionados
            fetch = FetchType.EAGER, // para que se carguen todos los tickets relacionados con un vuelo
            orphanRemoval = true, // para que se eliminen los tickets que no esten relacionados con un vuelo
            mappedBy = "fly" // para indicar que el atributo fly de la clase TicketEntity es el que tiene la relacion
    )
    private Set<TicketEntity> tickets;
}



