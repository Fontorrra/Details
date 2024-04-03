package ru.sale.details.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.sale.details.models.Sell;

@Repository
public interface SellRepository extends CrudRepository<Sell,Long> {
}
