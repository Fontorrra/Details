package ru.sale.details.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.sale.details.models.Color;
import ru.sale.details.models.Detail;
import ru.sale.details.models.User;
import ru.sale.details.service.DetailService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

@RestController
public class DetailController {

    DetailService detailService;

    @Autowired
    public DetailController(DetailService detailService) {
        this.detailService = detailService;
    }

    @GetMapping("/details")
    public Collection<Detail> getDetails() {
        return detailService.getDetails();
    }

    @PostMapping("/admin/details")
    public Detail createDetail(@RequestBody Detail detail) {
        return detailService.createDetail(detail);
    }

    @PostMapping("/admin/color")
    public Color createColor(@RequestBody Color color) {
        return detailService.createColor(color);
    }

    @GetMapping("/admin/colors")
    public Collection<Color> getColors() {
        return detailService.getColors();
    }
}
