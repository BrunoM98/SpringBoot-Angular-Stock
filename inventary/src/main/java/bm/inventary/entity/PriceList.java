package bm.inventary.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class PriceList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true)
    private String name; // Ejemplo: "Mayorista", "Especial", "Público"

    private Double baseMarkup; // El porcentaje base de esta lista (ej: 20.0)
}
