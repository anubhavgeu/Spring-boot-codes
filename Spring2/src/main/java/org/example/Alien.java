package org.example;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
public class Alien {

    @Value("21")
    private int age;


//    @Qualifier("laptop")

    private Computer com;
    public Alien() {
        System.out.println("Object creation...");
    }

//    public Alien (int age) {
//        System.out.println("This is called");
//        this.age = age;
//    }

//    public Alien (int age, Computer computer) {
//        System.out.println("This is called");
//        this.age = age;
//        this.computer = computer;
//    }

//    public Laptop getLaptop() {
//        return laptop;
//    }
//
//    public void setLaptop(Laptop laptop) {
//        System.out.println("Setted reference of laptop");
//        this.laptop = laptop;
//    }


    public Computer getComputer() {
        return this.com;
    }


    @Autowired
    public void setComputer(Computer computer) {
        this.com= computer;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        System.out.println("In Setter");
        this.age = age;
    }

    public void code() {
        System.out.println("I'm coding");
        if (com != null) com.compile();
    }
}
