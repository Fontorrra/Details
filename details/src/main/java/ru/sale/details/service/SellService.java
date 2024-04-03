package ru.sale.details.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.sale.details.models.Purchase;
import ru.sale.details.models.Sell;
import ru.sale.details.repository.SellRepository;

import java.util.ArrayList;
import java.util.Collection;

@Service
@AllArgsConstructor
public class SellService {
    SellRepository sellRepository;

    public Sell createSell(Sell sell) {
        return sellRepository.save(sell);
    }

    public Sell getSell(Long id) {
        return sellRepository.findById(id).get();
    }

    public Sell updateSell(Sell sell) {
        return sellRepository.save(sell);
    }

    public Collection<Sell> getSells() {
        Collection<Sell> collection = new ArrayList<>();
        sellRepository.findAll().forEach(collection::add);
        return collection;
    }

    public Boolean deleteSell(Long id) {
        sellRepository.delete(sellRepository.findById(id).get());
        return true;
    }
}
