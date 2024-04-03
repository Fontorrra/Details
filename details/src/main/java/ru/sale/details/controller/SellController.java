package ru.sale.details.controller;
;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.sale.details.models.Sell;
import ru.sale.details.service.SellService;

import java.util.ArrayList;
import java.util.Collection;

@RestController
public class SellController {

    SellService sellService;

    @Autowired
    public SellController(SellService sellService) {
        this.sellService = sellService;
    }

    @PostMapping("/user/sell")
    public Sell createNotPaidSell(@RequestBody Sell sell) {
        sell.setPaid(false);
        return sellService.createSell(sell);
    }


    @PostMapping("/admin/sell")
    public Sell createSell(@RequestBody Sell sell) {
        return sellService.createSell(sell);
    }

    @PutMapping("/admin/sell/{id}/{isPaid}")
    public Sell setIsPaidValue(@PathVariable Long id,
                               @PathVariable boolean isPaid) {
        Sell sell = sellService.getSell(id);
        sell.setPaid(isPaid);
        return sellService.updateSell(sell);
    }

    @GetMapping("/admin/sells")
    public Collection<Sell> getSells() {
        return sellService.getSells();
    }

    @DeleteMapping("/admin/sell/{id}")
    public Boolean deleteSell(@PathVariable Long id) {
        return sellService.deleteSell(id);
    }
}
