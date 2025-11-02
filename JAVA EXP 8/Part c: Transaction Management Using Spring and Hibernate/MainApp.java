package com.example.bank;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        AccountService service = context.getBean(AccountService.class);

        service.transferMoney(1, 2, 5000);

        System.out.println("Transaction Successful!");
    }
}
