package me.smartstore.project.menu;

import me.smartstore.project.customers.ClassifiedCustomers;
import me.smartstore.project.customers.Customer;
import me.smartstore.project.customers.Customers;

import java.util.Arrays;
import java.util.Comparator;

import static me.smartstore.project.Main.scan;

public class SummaryMenu {
    private static SummaryMenu summaryMenu = new SummaryMenu();

    private SummaryMenu(){}

    public static SummaryMenu getInstance(){
        if(summaryMenu==null)
            summaryMenu=new SummaryMenu();

        return summaryMenu;
    }
    public boolean run() {
        displayMenu();
        if (choiceMenu(scan.nextInt()) == 4)
            return true;
        else
            return false;
    }

    public void displayMenu() {
        System.out.println();
        System.out.println("==============================");
        System.out.println(" 1. Summary (Sorted By Name)");
        System.out.println(" 2. Summary (Sorted By Purchase Count)");
        System.out.println(" 3. Summary (Sorted By Total Payment)");
        System.out.println(" 4. Back");
        System.out.println("==============================");
        System.out.print("Choose One: ");
    }


    public int choiceMenu(int num) {
        ClassifiedCustomers classifiedCustomers = new ClassifiedCustomers(SmartStoreApplication.getAllCustomers());
        switch (num) {
            case 1:
                summaryByName(classifiedCustomers);
                break;

            case 2:
                summaryByPurchaseCount(classifiedCustomers);
                break;

            case 3:
                summaryByTotalPay(classifiedCustomers);
                break;



        }
        return num;
    }

    public String choiceOrderType(){
        System.out.print("Which order (ASCENDING, DESCENDING)? ");
        String str = scan.next();
        str = str.toUpperCase();

        return str;
    }
    public void summaryByName(ClassifiedCustomers classifiedCustomers){
        String str = choiceOrderType();

        for (Customers customers : classifiedCustomers.getClassifiedCustomers()) {
            Arrays.sort(customers.getCustomersArr(), new Comparator<Customer>() {
                @Override
                public int compare(Customer o1, Customer o2) {
                    if (o1 != null && o2 != null) {
                        if (str.equals("ASCENDING"))
                            return o1.getName().compareTo(o2.getName());
                        else if (str.equals("DESCENDING"))
                            return o2.getName().compareTo(o1.getName());
                    }
                    return 0;
                }
            });
        }
        classifiedCustomers.displayCustomersInfo();
    }

    public void summaryByPurchaseCount(ClassifiedCustomers classifiedCustomers){
        String str = choiceOrderType();

        for (Customers customers : classifiedCustomers.getClassifiedCustomers()) {
            Arrays.sort(customers.getCustomersArr(), new Comparator<Customer>() {
                @Override
                public int compare(Customer o1, Customer o2) {
                    if (o1 != null && o2 != null) {
                        if (str.equals("ASCENDING"))
                            return o1.getPurchaseCount() - o2.getPurchaseCount();
                        else if (str.equals("DESCENDING"))
                            return o2.getPurchaseCount() - o1.getPurchaseCount();
                    }
                    return 0;
                }
            });
        }
        classifiedCustomers.displayCustomersInfo();
    }

    public void summaryByTotalPay(ClassifiedCustomers classifiedCustomers){
        String str = choiceOrderType();

        for (Customers customers : classifiedCustomers.getClassifiedCustomers()) {
            Arrays.sort(customers.getCustomersArr(), new Comparator<Customer>() {
                @Override
                public int compare(Customer o1, Customer o2) {
                    if (o1 != null && o2 != null) {
                        if (str.equals("ASCENDING"))
                            return o1.getTotalPay() - o2.getTotalPay();
                        else if (str.equals("DESCENDING"))
                            return o2.getTotalPay() - o1.getTotalPay();
                    }
                    return 0;
                }
            });
        }
        classifiedCustomers.displayCustomersInfo();
    }

}
