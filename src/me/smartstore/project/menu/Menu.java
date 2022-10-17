package me.smartstore.project.menu;

import me.smartstore.project.exception.InputEmptyException;

import static me.smartstore.project.Main.scan;

public class Menu {

    private static Menu menu = new Menu();

    private CustomerMenu customerMenu = CustomerMenu.getInstance();
    private ParameterMenu parameterMenu = ParameterMenu.getInstance();
    private SummaryMenu summaryMenu = SummaryMenu.getInstance();

    private Menu() {
    }

    public static Menu getInstance() {
        if (menu == null)
            menu = new Menu();

        return menu;
    }

    public boolean run() {
        //메뉴를 보여주고 choiceMenu를 하는데 4번이면 Quit이므로 false반환해줘서 프로그램 종료
        displayMenu();
        if (choiceMenu(scan.nextInt()) == 4)
            return true;
        else
            return false;
    }

    private void displayMenu() {
        System.out.println();
        System.out.println("==============================");
        System.out.println(" 1. Classification Parameter");
        System.out.println(" 2. Customer Data");
        System.out.println(" 3. Summary");
        System.out.println(" 4. Quit");
        System.out.println("==============================");
        System.out.print("Choose One: ");
    }

    private int choiceMenu(int num) {
        //1번이면 parameter, 2번이면 customer, 3번이면 summary 실행
        if (num >= 1 && num <= 3) {
            switch (num) {
                case 1:
                    for (; ; ) {
                        if (parameterMenu.run())
                            break;
                    }
                    break;

                case 2:
                    for (; ; ) {
                        if (customerMenu.run())
                            break;
                    }
                    break;

                case 3:
                    for (; ; ) {
                        if (summaryMenu.run())
                            break;
                    }
            }
        }
        else
            System.out.println("Wrong number");
        return num;
    }
}
