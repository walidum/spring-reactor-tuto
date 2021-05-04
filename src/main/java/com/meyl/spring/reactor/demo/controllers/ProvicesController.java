package com.meyl.spring.reactor.demo.controllers;

import com.meyl.spring.reactor.demo.model.Province;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProvicesController {
    private static List<Province> provinces = new ArrayList<>();

    static {
        provinces.add(Province._new(16, "Algiers"));
        provinces.add(Province._new(19, "Setif"));
        provinces.add(Province._new(9, "Blida"));
        provinces.add(Province._new(23, "Annaba"));
        provinces.add(Province._new(31, "Oran"));
        provinces.add(Province._new(39, "El Oued"));
    }

    @GetMapping("/province/{id}")
    public Province getState(@PathVariable final int id) throws InterruptedException {
        Thread.sleep(2 * 1000);
        return provinces.stream()
                .filter((p) -> p.getId() == id)
                .findFirst()
                .orElse(Province._new());
    }
}

