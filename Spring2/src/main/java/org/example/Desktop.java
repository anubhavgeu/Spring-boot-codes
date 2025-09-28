package org.example;


import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Primary
@Scope("prototype")
public class Desktop implements Computer{
    public Desktop() {
        System.out.println("Desktop is created....");
    }
    public void compile() {
        System.out.println("It is desktop");
    }
}
