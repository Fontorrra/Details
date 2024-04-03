package ru.sale.details.service;

import org.hibernate.sql.ast.tree.expression.Collation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.sale.details.models.Color;
import ru.sale.details.models.Detail;
import ru.sale.details.repository.ColorRepository;
import ru.sale.details.repository.DetailRepository;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class DetailService {
    DetailRepository detailRepository;

    ColorRepository colorRepository;

    @Autowired
    public DetailService(DetailRepository detailRepository, ColorRepository colorRepository) {
        this.detailRepository = detailRepository;
        this.colorRepository = colorRepository;
    }

    public Collection<Detail> getDetails() {
        Collection<Detail> collection = new ArrayList<>();
        detailRepository.findAll().forEach(collection::add);
        return collection;
    }

    public Detail createDetail(Detail detail) {
        return detailRepository.save(detail);
    }

    public Color createColor(Color color) {
        return colorRepository.save(color);
    }

    public Collection<Color> getColors() {
        Collection<Color> collection = new ArrayList<>();
        colorRepository.findAll().forEach(collection::add);
        return collection;
    }
}
