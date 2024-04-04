package ru.sale.details.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "sells")
@Data
public class Sell {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "detail_id", nullable = false)
    private Detail detail;

    @Column(nullable = false, name = "total_price")
    private int totalPrice;

    @Column(nullable = false)
    private int count;

    @Column(name = "is_paid", nullable = false)
    private boolean isPaid;
}