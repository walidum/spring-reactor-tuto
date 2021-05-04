package com.meyl.spring.reactor.demo.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Item {
    private String msg;

    public Item(String msg) {
        this.msg = msg;
    }
}
