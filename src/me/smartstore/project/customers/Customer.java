package me.smartstore.project.customers;

import me.smartstore.project.exception.InputEmptyException;
import me.smartstore.project.exception.InputFormatException;

public class Customer {
    private static int serialNoGenerator = 0;
    private String serialNO;
    private String name;
    private String userID;
    private int purchaseCount;
    private int totalPay;

    private Group group = new Group();

    public Customer(String name, String userID, int purchaseCount, int totalPay) {
        serialNoGenerator++;
        this.serialNO = String.format("%05d", serialNoGenerator);
        try{
            setName(name);
        }
        catch (InputEmptyException e) {
            System.out.println(e.getMessage());
        }
        catch (InputFormatException e){
            System.out.println(e.getMessage());
        }
        this.userID = userID;
        this.purchaseCount = purchaseCount;
        this.totalPay = totalPay;
        group.setGroupType(purchaseCount, totalPay);
    }

    public Customer(Customer customer) {
        this.serialNO = customer.serialNO;
        try{
            setName(customer.name);
        }
        catch (InputEmptyException e) {
            System.out.println(e.getMessage());
        }
        catch (InputFormatException e){
            System.out.println(e.getMessage());
        }

        this.userID = customer.userID;
        this.purchaseCount = customer.purchaseCount;
        this.totalPay = customer.totalPay;
        group.setGroupType(customer.purchaseCount, customer.totalPay);
    }

    public String getSerialNO() {
        return serialNO;
    }

    public void setSerialNO(String serialNO) {
        this.serialNO = serialNO;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws InputEmptyException, InputFormatException {
        if (name == null)
            throw new InputEmptyException("Name must not be null");

        if(!(name.matches("^[a-zA-Z]{3,}$")))
            throw new InputFormatException("Name must be more than 3 letters and alphabets only");
        else
            this.name = name;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public int getPurchaseCount() {
        return purchaseCount;
    }

    public void setPurchaseCount(int purchaseCount) {
        this.purchaseCount = purchaseCount;
    }

    public int getTotalPay() {
        return totalPay;
    }

    public void setTotalPay(int totalPay) {
        this.totalPay = totalPay;
    }

    public Group getGroup() {
        group.setGroupType(getPurchaseCount(), getTotalPay());
        return group;
    }
}
