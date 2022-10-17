package me.smartstore.project.customers;

import me.smartstore.project.exception.InputEmptyException;
import me.smartstore.project.exception.InputFormatException;

import java.util.Arrays;

import static me.smartstore.project.Main.scan;

public class Customers {
    private final int DEFAULT_MAX_CUSTOMER_COUNT = 10;
    private Customer[] customers = new Customer[DEFAULT_MAX_CUSTOMER_COUNT];
    //디폴트 최대 크기를 일단 10으로 해둔다
    private int customerCount = 0;
    //배열의 경우 .length를 하면 무조건 배열의 크기 (null이 있어도 포함)하므로 실제 고객의 수를 기록하는 변수 필요

    public Customer[] getCustomersArr() {
        return customers;
    }
    //Customers를 반환 즉 Customer 배열 customers를 반환하는 함수 getCusomers를 좀더 직관적으로 알수있게 이름 수정

    public int getCustomerCount() {
        return customerCount;
    }

    public void addCustomer(String name, String userID, String purchaseCount, String totalPay) {
        Customer temp = new Customer(name, userID, purchaseCount, totalPay);
        if (temp.getName() != null && temp.getUserID() != null && temp.getPurchaseCount() >= 0 && temp.getTotalPay() >= 0) {
            if (customerCount >= customers.length) {
                Customer[] newCustomers = new Customer[customers.length * 2];
                for (int i = 0; i < customers.length; i++)
                    newCustomers[i] = customers[i];

                customers = newCustomers;
            }
            customers[customerCount] = temp;
            customerCount++;
        }
    }

    public void addCustomer(Customer customer) {
        if (customerCount < customers.length) {
            customers[customerCount] = new Customer(customer);
            customerCount++;
        } else {
            Customer[] newCustomers = new Customer[customers.length * 2];
            for (int i = 0; i < customers.length; i++)
                newCustomers[i] = customers[i];

            customers = newCustomers;
            customers[customerCount] = new Customer(customer);
            customerCount++;
        }
    }

    public void addTesters() {
        addCustomer("Doo", "jjwmm", "17", "17000");
        addCustomer("Boo", "jjwmm", "6", "6000");
        addCustomer("Aoo", "jjwmm", "39", "39000");
        addCustomer("Coo", "jjwmm", "3", "3000");
        addCustomer("Koo", "jjwmm", "8", "8000");
        addCustomer("Ioo", "jjwmm", "16", "16000");
        addCustomer("Loo", "jjwmm", "23", "23000");
        addCustomer("Joo", "jjwmm", "15", "15000");
        addCustomer("Boo", "jjwmm", "20", "20000");
        addCustomer("Qoo", "jjwmm", "12", "12000");
    }


    public void updateCustomer(String serialNum) {
        int index = -1;
        for (int i = 0; i < customerCount; i++) {
            if (customers[i].getSerialNO().equals(serialNum)) {
                index = i;
                break;
            }
        }
        if (index >= 0) {
            System.out.println("Input number that you want to update");
            System.out.println("1. Name   2. User ID   3. Purchase Count   4. Total Pay");
            int attribute = scan.nextInt();

            if (attribute >= 1 && attribute <= 4) {
                switch (attribute) {
                    case 1:
                        System.out.println("Input Name");
                        String name = scan.next();
                        try {
                            customers[index].setName(name);
                        } catch (InputEmptyException e) {
                            System.out.println(e.getMessage());
                        } catch (InputFormatException e) {
                            System.out.println(e.getMessage());
                        }
                        break;

                    case 2:
                        System.out.println("Input User ID");
                        String userID = scan.next();
                        try {
                            customers[index].setUserID(userID);
                        } catch (InputEmptyException e) {
                            System.out.println(e.getMessage());
                        } catch (InputFormatException e) {
                            System.out.println(e.getMessage());
                        }
                        break;

                    case 3:
                        System.out.println("Input Purchase Count");
                        String purchaseCount = scan.next();
                        try {
                            customers[index].setPurchaseCount(purchaseCount);
                        } catch (InputFormatException e) {
                            System.out.println(e.getMessage());
                        }
                        customers[index].getGroup();
                        break;

                    case 4:
                        System.out.println("Input Total Pay");
                        String totalPay = scan.next();
                        try {
                            customers[index].setTotalPay(totalPay);
                        } catch (InputFormatException e) {
                            System.out.println(e.getMessage());
                        }
                        customers[index].getGroup();
                        break;
                }
            } else
                System.out.println("Wrong Number");
        } else
            System.out.println("Wrong Serial Number Cannot found customer");
    }

    public void deleteCustomer(String delSerialNum) {
        int index = -1;
        for (int i = 0; i < customerCount; i++) {
            if (customers[i].getSerialNO().equals(delSerialNum)) {
                index = i;
                break;
            }
        }

        if (index >= 0) {
            Customer[] newCustomers = new Customer[--customerCount];
            for (int i = 0, j = 0; i < customerCount + 1; i++) {
                if (i != index) {
                    newCustomers[j] = customers[i];
                    j++;
                }
            }
            customers = newCustomers;
        }
        System.out.println("Wrong Serial Number Cannot found customer");
    }


    public void displayCustomersInfo() {
        System.out.printf("%s\n", "=".repeat(130));
        for (int i = 0; i < customerCount; i++) {
            System.out.printf("%03d. %7s Customer |\tSerial No: %s |\tName: %5s |", (i + 1), customers[i].getGroup().getGroupType(), customers[i].getSerialNO(), customers[i].getName());
            System.out.printf("\tUser ID: %6s |\tPurchase Count: %5d |\tTotal Payment: %10d |\n", customers[i].getUserID(), customers[i].getPurchaseCount(), customers[i].getTotalPay());
        }
        System.out.printf("%s\n", "=".repeat(130));
    }

    @Override
    public String toString() {
        return "Customers{" +
                "customers=" + Arrays.toString(customers) +
                ", customerCount=" + customerCount +
                '}';
    }
}
