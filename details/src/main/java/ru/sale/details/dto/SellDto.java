package ru.sale.details.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import ru.sale.details.models.Detail;
import ru.sale.details.models.User;

@Data
@AllArgsConstructor
public class SellDto {
    private String username;
    private Detail detail;
    private int count;
}
