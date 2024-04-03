package ru.sale.details.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.sale.details.models.Detail;


@Repository
public interface DetailRepository extends CrudRepository<Detail,Long> {
}