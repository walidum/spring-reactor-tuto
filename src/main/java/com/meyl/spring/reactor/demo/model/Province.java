package com.meyl.spring.reactor.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Province {
    private int id;
    private String name;

    public static Province _new() {
        return new Province();
    }

    public static Province _new(int id, String name) {
        return new Province(id, name);
    }
}
