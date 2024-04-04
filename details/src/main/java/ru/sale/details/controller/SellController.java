package ru.sale.details.controller;
;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.sale.details.dto.SellDto;
import ru.sale.details.models.Sell;
import ru.sale.details.service.DetailService;
import ru.sale.details.service.SellService;
import ru.sale.details.service.UserService;

import java.util.ArrayList;
import java.util.Collection;

@RestController
@AllArgsConstructor
public class SellController {

    SellService sellService;
    UserService userService;

    @PostMapping("/user/sell")
    public ResponseEntity<?> createNotPaidSell(@RequestBody SellDto sellDto) {
        Sell sell = new Sell();
        sell.setPaid(false);
        sell.setUser(userService.findByUsername(sellDto.getUsername()).get());
        sell.setDetail(sellDto.getDetail());
        sell.setCount(sellDto.getCount());
        sell.setTotalPrice(sellDto.getTotalPrice());
        return sellService.createSell(sell);
    }

    @PutMapping("/admin/sell/{id}/{isPaid}")
    public Sell setIsPaidValue(@PathVariable Long id,
                               @PathVariable boolean isPaid) {
        Sell sell = sellService.getSell(id);
        sell.setPaid(isPaid);
        sellService.updateCount(sell);
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
