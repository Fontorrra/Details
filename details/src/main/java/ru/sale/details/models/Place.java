package ru.sale.details.models;

import jakarta.persistence.Column;
import jakarta.persistence.Table;
import lombok.Data;

@Table(name = "Places")
@Data
public class Place {
    @Column(nullable = false)
    private Long id;

    @Column(nullable = false)
    private String address;
}
