package com.core.concepts.qualifier;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Human {
    ColdDrink coldDrink, coldDrink1;
    public Human(@Qualifier("cocaCola")ColdDrink coldDrink, @Qualifier("pepsi")ColdDrink coldDrink1) {
        this.coldDrink = coldDrink;
        this.coldDrink1 = coldDrink1;
    }
    public  void tryColdDrink() {
        coldDrink.drink();
        coldDrink1.drink();
    }
}
