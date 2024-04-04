package ru.sale.details.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;
import ru.sale.details.models.Color;
import ru.sale.details.models.Detail;
import ru.sale.details.models.Purchase;
import ru.sale.details.repository.DetailRepository;
import ru.sale.details.repository.PurchaseRepository;

import java.util.ArrayList;
import java.util.Collection;

@Service
@AllArgsConstructor
public class PurchaseService {

    PurchaseRepository purchaseRepository;
    DetailService detailService;

    public Collection<Purchase> getPurchases() {
        Collection<Purchase> collection = new ArrayList<>();
        purchaseRepository.findAll().forEach(collection::add);
        return collection;
    }

    public Purchase createPurchase(Purchase purchase) {
        Detail detail = detailService.getDetailById(purchase.getDetail().getId());
        detail.setCount(detail.getCount() + purchase.getCount());
        detailService.updateDetail(detail);
        return purchaseRepository.save(purchase);
    }

}
