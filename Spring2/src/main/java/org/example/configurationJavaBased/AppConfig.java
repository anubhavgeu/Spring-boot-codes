package org.example.configurationJavaBased;


import org.example.Alien;
import org.example.Computer;
import org.example.Desktop;
import org.example.Laptop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan("org.example")
public class AppConfig {
//    @Scope("prototype")
//    @Bean(name = {"desktopBean", "com1", "anubhav"})
//    public Desktop desktop() {
//        return new Desktop();
//    }
//
//    @Bean
//    public Alien alien(@Qualifier("com1") Computer com) {
//        Alien obj = new Alien();
//        obj.setAge(21);
//        obj.setComputer(com);
//        return new Alien();
//    }
//
//    @Bean
//    @Primary
//    public Laptop laptop() {
//        return new Laptop();
//    }
}
