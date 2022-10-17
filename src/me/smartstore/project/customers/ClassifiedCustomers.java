package me.smartstore.project.customers;

public class ClassifiedCustomers {
    private Customers[] classifiedCustomers = {new Customers(), new Customers(), new Customers()};

    public Customers[] getClassifiedCustomers() {
        return classifiedCustomers;
    }

    public ClassifiedCustomers(Customers customers) {
        for (int i = 0; i < customers.getCustomerCount(); i++) {
            if (customers.getCustomersArr()[i].getGroup().getGroupType().equals(GroupType.GENERAL))
                classifiedCustomers[0].addCustomer(customers.getCustomersArr()[i]);
            if (customers.getCustomersArr()[i].getGroup().getGroupType().equals(GroupType.VIP))
                classifiedCustomers[1].addCustomer(customers.getCustomersArr()[i]);
            if (customers.getCustomersArr()[i].getGroup().getGroupType().equals(GroupType.VVIP))
                classifiedCustomers[2].addCustomer(customers.getCustomersArr()[i]);
        }
    }

    public void displayCustomersInfo() {
        System.out.println();
        System.out.println("GENERAL Customer List");
        classifiedCustomers[0].displayCustomersInfo();
        System.out.println();

        System.out.println("VIP Customer List");
        classifiedCustomers[1].displayCustomersInfo();
        System.out.println();

        System.out.println("VVIP Customer List");
        classifiedCustomers[2].displayCustomersInfo();
        System.out.println();

    }
}
