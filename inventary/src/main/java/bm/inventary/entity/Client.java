package bm.inventary.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; // ID técnico oculto

    @Column(unique = true)
    private Integer clientCode; // El que el usuario puede reutilizar

    private String nameClient;
    private Integer dniClient;
    private Integer numberClient;
    private String ubiClient;

    // EL PORCENTAJE INDIVIDUAL (puede ser positivo o negativo)
    private Double individualMarkup;

    // VÍNCULO CON LA LISTA DE PRECIOS
    @ManyToOne
    @JoinColumn(name = "price_list_id") // Esta es la columna que los une en la DB
    private PriceList priceList;
}
