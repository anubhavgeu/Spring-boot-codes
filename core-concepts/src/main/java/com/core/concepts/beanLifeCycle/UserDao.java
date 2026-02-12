package com.core.concepts.beanLifeCycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
public class UserDao implements InitializingBean, DisposableBean {

    UserDao() {
        System.out.println("Instantiating userDao");
    }

    String connection = null;
    public void saveUser() {
        System.out.println("---------------");
        System.out.println("Using db connection :");
        System.out.println(connection.length());
        System.out.println("Saving user");
        System.out.println("Done");
        System.out.println("---------------");
    }

    public void printAllUser() {
        System.out.println("---------------");
        System.out.println("Using db connection");
        System.out.println(connection.length());
        System.out.println("---------------");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        connection = "connection to db1";
    }

    @Override
    public void destroy() throws Exception {
        connection = null;
        System.out.println("Destroying connection");
    }
}
