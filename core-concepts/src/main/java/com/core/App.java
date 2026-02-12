package com.core;

import com.core.concepts.ConfigClass;
import com.core.concepts.beanLifeCycle.Truck;
import com.core.concepts.beanLifeCycle.UserDao;
import com.core.concepts.scopes.Samosa;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConfigClass.class);
//        Engine engine = context.getBean("engine", Engine.class);
//        engine.startEngine();
//        Car car = context.getBean("car", Car.class);
//        car.start();

//        UserController userController = context.getBean("userController", UserController.class);
//        userController.controllerMethod();

//        NotificationManager notificationManager = context.getBean("notificationManager", NotificationManager.class);
//        notificationManager.sendNotification("email");
//        notificationManager.sendNotification("sms");

//        Student student = context.getBean("student", Student.class);
//        student.show();
//        System.out.println(student);
//        Human human = context.getBean("human", Human.class);
//        human.tryColdDrink();

//        Truck truck = context.getBean("truck", Truck.class);
//        truck.run();
//        context.close();

//        UserDao userDao = context.getBean("userDao", UserDao.class);
//        userDao.saveUser();
//        context.close();

        Samosa samosa = context.getBean("samosa", Samosa.class);
        Samosa samosa1 = context.getBean("samosa", Samosa.class);
        System.out.println(samosa);
        System.out.println(samosa1);
    }
}
