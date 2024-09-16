package org.example;

import lombok.*;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
@Entity
@Table(name = "Factura")
@Audited
public class Factura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fecha;
    private int numero;
    private float total;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn (name = "fk_cliente")
    private Cliente cliente;

    @Builder.Default
    @OneToMany (mappedBy = "factura",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DetalleFactura> detalle = new ArrayList<DetalleFactura>();

}

