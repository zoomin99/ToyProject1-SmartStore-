package me.smartstore.project.menu;

import me.smartstore.project.customers.GroupType;
import me.smartstore.project.customers.Parameter;

import static me.smartstore.project.Main.scan;

public class ParameterMenu {
    private static ParameterMenu parameterMenu = new ParameterMenu();
    private Parameter parameter = Parameter.getInstance();

    private ParameterMenu() {
    }

    public static ParameterMenu getInstance() {
        if (parameterMenu == null)
            parameterMenu = new ParameterMenu();

        return parameterMenu;
    }

    public boolean run() {
        //여기도 동일하게 displayMenu하고 메뉴를 고르는데 위의 Menu.run에서 여기가 true면 무한루프 돌게 해놓음
        //그래서 3번 back을 선택하면 false반환하게 함
        displayMenu();
        if (choiceMenu(scan.nextInt()) == 3)
            return true;
        else
            return false;
    }

    public void displayMenu() {
        System.out.println();
        System.out.println("==============================");
        System.out.println(" 1. Update Parameter");
        System.out.println(" 2. View Parameter");
        System.out.println(" 3. Back");
        System.out.println("==============================");
        System.out.print("Choose One: ");
    }


    public int choiceMenu(int num) {
        if (num >= 1 && num <= 2) {
            switch (num) {
                case 1:
                    updateParameter();
                    break;

                case 2:
                    viewParameter();
                    break;
            }
        } else
            System.out.println("Wrong number");
        return num;
    }

    private void updateParameter() {
        System.out.print("Which group (VIP, VVIP)? ");
        String str = scan.next();
        str = str.toUpperCase();

        System.out.println("Input value of " + str + "'s minimum Purchase Count");
        int purchaseCount = scan.nextInt();
        System.out.println("Input value of " + str + "'s minimum Total Pay");
        int totalPay = scan.nextInt();

        if (str.equals(GroupType.VIP.name())) {
            parameter.setVIPMinPurchaseCount(purchaseCount);
            parameter.setVIPMinTotalPay(totalPay);
        } else if (str.equals(GroupType.VVIP.name())) {
            parameter.setVVIPMinPurchaseCount(purchaseCount);
            parameter.setVVIPMinTotalPay(totalPay);
        }
        else
            System.out.println("Choose VIP or VVIP");
    }

    private void viewParameter() {
        System.out.println("VIP STANDARD");
        System.out.println("Minimum Purchase Count: " + parameter.getVIPMinPurchaseCount() + "       Minimum Total Pay: " + parameter.getVIPMinTotalPay());
        System.out.println("\nVVIP STANDARD");
        System.out.println("Minimum Purchase Count: " + parameter.getVVIPMinPurchaseCount() + "       Minimum Total Pay: " + parameter.getVVIPMinTotalPay());
    }
}
