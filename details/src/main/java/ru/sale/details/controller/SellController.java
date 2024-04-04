package ru.sale.details.controller;
;
import lombok.AllArgsConstructor;
import lombok.Synchronized;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.sale.details.dto.SellDto;
import ru.sale.details.exceptions.AppError;
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
    @Synchronized
    public ResponseEntity<?> setIsPaidValue(@PathVariable Long id,
                               @PathVariable boolean isPaid) {

        Sell sell = sellService.getSell(id);
        if (sell.isPaid()) return new ResponseEntity<>(new AppError(HttpStatus.BAD_REQUEST.value(),
                "Продажа уже была оплачена"), HttpStatus.BAD_REQUEST);
        sell.setPaid(isPaid);
        sellService.updateCount(sell);
        return new ResponseEntity<>(sellService.updateSell(sell), HttpStatus.OK);
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
