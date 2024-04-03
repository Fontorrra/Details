package ru.sale.details.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "details")
@Data
public class Detail {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "color_id")
    private Color color;

    @Column(nullable = false, name = "sell_price")
    private int sellPrice;

    @Column(nullable = false)
    private int count;

    @OneToMany(mappedBy = "detail")
    @JsonIgnore
    private List<Purchase> purchases;

    @OneToMany(mappedBy = "detail")
    @JsonIgnore
    private List<Sell> sells;
}
