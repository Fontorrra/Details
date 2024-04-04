package ru.sale.details.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "purchases")
@Data
public class Purchase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "detail_id")
    private Detail detail;

    @Column(nullable = false)
    int count;

    @Column(nullable = false, name = "total_price")
    Integer totalPrice;
}
