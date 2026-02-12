package com.core.concepts.scopes;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Samosa {
    static int samosaCounter = 0;
    public Samosa() {
        System.out.println("New samosa is created: " + ++Samosa.samosaCounter);
    }
}
