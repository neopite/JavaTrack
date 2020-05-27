package com.company.lab3.view;

import java.util.Scanner;

public class RetrievView {

    private Scanner scanner;

    public RetrievView() {
        this.scanner = new Scanner(System.in);
    }

    public String getNumberOfFuction() {
        return scanner.next();
    }

    public  String getArgument() {
        return scanner.next();
    }

}
