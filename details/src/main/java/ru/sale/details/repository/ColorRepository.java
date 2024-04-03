package ru.sale.details.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.sale.details.models.Color;

@Repository
public interface ColorRepository extends CrudRepository<Color,Long> {
}
