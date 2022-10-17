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

    public Customer(String name, String userID, String purchaseCount, String totalPay) {
        serialNoGenerator++;
        this.serialNO = String.format("%05d", serialNoGenerator);
        try {
            setName(name);
            setUserID(userID);
            setPurchaseCount(purchaseCount);
            setTotalPay(totalPay);
        } catch (InputEmptyException e) {
            System.out.println(e.getMessage());
        } catch (InputFormatException e) {
            System.out.println(e.getMessage());
        }
        group.setGroupType(this.purchaseCount, this.totalPay);
    }

    public Customer(Customer customer) {
        this.serialNO = customer.serialNO;
        this.name = customer.name;
        this.userID = customer.userID;
        this.purchaseCount = customer.purchaseCount;
        this.totalPay = customer.totalPay;
        group.setGroupType(customer.purchaseCount, customer.totalPay);
    }

    public String getSerialNO() {
        return serialNO;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws InputEmptyException, InputFormatException {
        if (name == null)
            throw new InputEmptyException("Name must not be null");

        if (!(name.matches("^[a-zA-Z]{3,}$")))
            throw new InputFormatException("Name must be more than 3 letters and alphabets only");
        else
            this.name = name;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) throws InputEmptyException, InputFormatException {
        if (userID == null)
            throw new InputEmptyException("User ID must not be null");

        if (!(userID.matches("^[a-zA-Z][a-zA-Z0-9_]{4,11}$")))
            throw new InputFormatException("User ID format error");
        this.userID = userID;
    }

    public int getPurchaseCount() {
        return purchaseCount;
    }

    public void setPurchaseCount(String purchaseCount) throws InputFormatException {
        if (!(purchaseCount.matches("^[1-9][0-9]*|0$"))) {
            this.purchaseCount = -1;
            throw new InputFormatException("Purchase Count format error");
        } else
            this.purchaseCount = Integer.parseInt(purchaseCount);
    }

    public int getTotalPay() {
        return totalPay;
    }

    public void setTotalPay(String totalPay) throws InputFormatException {
        if (!(totalPay.matches("^[1-9][0-9]*|0$"))) {
            this.totalPay = -1;
            throw new InputFormatException("Total Payment format error");
        } else
            this.totalPay = Integer.parseInt(totalPay);
    }

    public Group getGroup() {
        group.setGroupType(getPurchaseCount(), getTotalPay());
        return group;
    }
}
