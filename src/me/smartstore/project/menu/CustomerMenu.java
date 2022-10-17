package me.smartstore.project.menu;

import static me.smartstore.project.Main.scan;

public class CustomerMenu {

    private static CustomerMenu customerMenu = new CustomerMenu();

    private CustomerMenu() {
    }

    public static CustomerMenu getInstance() {
        if (customerMenu == null)
            customerMenu = new CustomerMenu();

        return customerMenu;
    }

    public boolean run() {
        displayMenu();
        if (choiceMenu(scan.nextInt()) == 5)
            return true;
        else
            return false;
    }


    public void displayMenu() {
        System.out.println();
        System.out.println("==============================");
        System.out.println(" 1. Add Customer Data");
        System.out.println(" 2. View Customer Data");
        System.out.println(" 3. Update Customer Data");
        System.out.println(" 4. Delete Customer Data");
        System.out.println(" 5. Back");
        System.out.println("==============================");
        System.out.print("Choose One: ");
    }


    public int choiceMenu(int num) {
        System.out.println();
        if (num >= 1 && num <= 4) {
            switch (num) {
                case 1:
                    addCustomerData();
                    break;

                case 2:
                    SmartStoreApplication.allCustomers.displayCustomersInfo();
                    break;

                case 3:
                    updateCustomerData();
                    break;

                case 4:
                    deleteCustomerData();
                    break;

                case 6:
                    SmartStoreApplication.allCustomers.addTesters();
            }
        }
        else
            System.out.println("Wrong number");
        return num;
    }

    private void addCustomerData() {
        String name, UserID, purchaseCount, totalPay;

        System.out.println("Input customer's Name");
        name = scan.next();
        System.out.println("Input customer's User ID");
        UserID = scan.next();
        System.out.println("Input customer's Purchase Count");
        purchaseCount = scan.next();
        System.out.println("Input customer's Total Pay");
        totalPay = scan.next();

        SmartStoreApplication.allCustomers.addCustomer(name, UserID, purchaseCount, totalPay);
    }

    private void updateCustomerData() {
        SmartStoreApplication.allCustomers.displayCustomersInfo();
        System.out.println("\nInput serial number of customer that you want to update");
        String serialNum = scan.next();
        SmartStoreApplication.allCustomers.updateCustomer(serialNum);
    }

    private void deleteCustomerData() {
        SmartStoreApplication.allCustomers.displayCustomersInfo();
        System.out.println("\nInput serial number of customer that you want to delete");
        String delSerialNum = scan.next();
        SmartStoreApplication.allCustomers.deleteCustomer(delSerialNum);
    }

}
