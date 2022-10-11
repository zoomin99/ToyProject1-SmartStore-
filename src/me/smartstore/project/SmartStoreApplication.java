package me.smartstore.project;

import me.smartstore.project.customers.Customers;
import me.smartstore.project.groups.Groups;
import me.smartstore.project.menu.CustomerMenu;
import me.smartstore.project.menu.GroupMenu;
import me.smartstore.project.menu.Menu;
import me.smartstore.project.menu.SummaryMenu;

import java.util.Scanner;

public class SmartStoreApplication {

    public static SmartStoreApplication smartStoreApp;

    /* customers object */
    public Customers allCustomers;

    /* groups object */
    public Groups allGroups;


    /* menu object */
    public Menu menu;
    public GroupMenu groupMenu;
    public CustomerMenu customerMenu;
    public SummaryMenu summaryMenu;

    /* scanner object */
    public Scanner scanner  = new Scanner(System.in);

    @Override
    public String toString() {
        return "SmartStoreApplication{" +
                "allCustomers=" + allCustomers +
                ", allGroups=" + allGroups +
                ", menu=" + menu +
                ", groupMenu=" + groupMenu +
                ", customerMenu=" + customerMenu +
                ", summaryMenu=" + summaryMenu +
                ", scanner=" + scanner +
                '}';
    }


    public void details() {
        System.out.println("===========================================");
        System.out.println(" Title : SmartStore Customer Classification");
        System.out.println("===========================================\n");
    }


    /*
     * this is method for running application.
     * */
    public void run() {

        details();

        // TODO: Write the code.

        scanner.close();
    }
}
