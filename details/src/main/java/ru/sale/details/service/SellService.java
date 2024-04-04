package ru.sale.details.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.LockModeType;
import jakarta.persistence.Query;
import lombok.AllArgsConstructor;
import lombok.Synchronized;
import org.hibernate.engine.spi.SessionDelegatorBaseImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import ru.sale.details.exceptions.AppError;
import ru.sale.details.models.Detail;
import ru.sale.details.models.Purchase;
import ru.sale.details.models.Sell;
import ru.sale.details.repository.DetailRepository;
import ru.sale.details.repository.SellRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Optional;

@Service
@AllArgsConstructor
public class SellService {
    SellRepository sellRepository;
    DetailRepository detailRepository;
    EntityManager entityManager;

    public ResponseEntity<?> createSell(Sell sell) {
        Optional<Detail> detailOptional = detailRepository.findById(sell.getDetail().getId());
        if (detailOptional.isEmpty()) {
            return new ResponseEntity<>(new AppError(HttpStatus.BAD_REQUEST.value(),
                    "Данной детали нет"), HttpStatus.BAD_REQUEST);
        }

        if (detailOptional.get().getCount() <= 0) {
            return new ResponseEntity<>(new AppError(HttpStatus.BAD_REQUEST.value(),
                    "Данной детали нет в наличии"), HttpStatus.BAD_REQUEST);
        }

        return ResponseEntity.ok(sellRepository.save(sell));
    }

    public Sell getSell(Long id) {
        return sellRepository.findById(id).get();
    }

    @Synchronized
    public Sell updateSell(Sell sell) {
        return sellRepository.save(sell);
    }

    public Collection<Sell> getSells() {
        Collection<Sell> collection = new ArrayList<>();
        sellRepository.findAll().forEach(collection::add);
        return collection;
    }

    public Boolean updateCount(Sell sell) {
        Detail detail = detailRepository.findById(sell.getDetail().getId()).get();
        detail.setCount(detail.getCount() - sell.getCount());
        detailRepository.save(detail);
        return true;
    }

    public Boolean deleteSell(Long id) {
        sellRepository.delete(sellRepository.findById(id).get());
        return true;
    }
}
