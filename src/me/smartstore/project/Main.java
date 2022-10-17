package me.smartstore.project;

import me.smartstore.project.exception.InputEmptyException;
import me.smartstore.project.menu.SmartStoreApplication;

import java.util.Scanner;

public class Main {
    public static final Scanner scan = new Scanner(System.in);
    // Scanner를 사용할때마다 선언하기 귀찮아서 static으로 하나 선언하고 main 끝날때 close하는 방식인데 이게 옳은지는 모르겠다.

    public static void main(String[] args) {

        new SmartStoreApplication().run();

        scan.close();
    }
}
