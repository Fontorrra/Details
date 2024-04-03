package ru.sale.details.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.sale.details.models.Purchase;

@Repository
public interface PurchaseRepository extends CrudRepository<Purchase,Long> {
}
