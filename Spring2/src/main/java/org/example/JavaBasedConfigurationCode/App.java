package org.example.JavaBasedConfigurationCode;

import org.example.Alien;
import org.example.Desktop;
import org.example.configurationJavaBased.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

//        Desktop desktop1 = context.getBean(Desktop.class);
//        Desktop desktop2 = context.getBean(Desktop.class);
//        System.out.println(desktop2==desktop1);
//        desktop1.compile();

        Alien obj1 = context.getBean(Alien.class);
        System.out.println(obj1.getAge());
        obj1.code();
    }
}
