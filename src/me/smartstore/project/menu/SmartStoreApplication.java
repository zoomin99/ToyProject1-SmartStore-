package me.smartstore.project.menu;

import me.smartstore.project.customers.Customers;
import me.smartstore.project.exception.InputEmptyException;

import java.util.Scanner;

public class SmartStoreApplication {

    protected static Customers allCustomers = new Customers();
    //모든 고객들이 들어있는 allCustomers는 하나만 존재하여야하고 같은 패키지에 있는 Menu에서도 사용해야하므로 protected로 선언 이것도 맞는건지 말 모르겠다.

    public static Customers getAllCustomers() {
        return allCustomers;
    }

    private Menu menu = Menu.getInstance();

    public void details() {
        System.out.println("===========================================");
        System.out.println(" Title : SmartStore Customer Classification");
        System.out.println(" Release Date : 22.10.15");
        System.out.println(" Copyright 2022 Woomin All rights reserved.");
        System.out.println("===========================================");
    }


    /*
     * this is method for running application.
     * */
    public void run() {
        details();
        for (; ; ) {
            boolean menuBreakButton = menu.run();
            //menu.rum을 하는데 menu에서 quit을 받으면 true로 변해서 밑에서 break되는 방식으로 설계 이부분도 이게 맞는건지는 모르겠다.
            if (menuBreakButton)
                break;
        }
    }
}
