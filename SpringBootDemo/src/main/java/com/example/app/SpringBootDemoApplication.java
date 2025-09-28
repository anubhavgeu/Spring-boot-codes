package com.example.app;

import com.example.app.model.Alien;
import com.example.app.model.Laptop;
import com.example.app.service.LaptopService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


@SpringBootApplication
public class SpringBootDemoApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringBootDemoApplication.class, args);
        Laptop lap = context.getBean(Laptop.class);

        LaptopService service = context.getBean(LaptopService.class);
        service.addLaptop(lap);
//        Alien obj = context.getBean(Alien.class);
//        obj.code();
        // Controller -> Just accept the request
        // Service -> Perform all the processing
        // Repository -> Connect with database and gives back data to Service;
//        Alien obj1 = context.getBean(Alien.class);
//        obj1.code();

//        System.out.println(obj == obj1);
	}

}
