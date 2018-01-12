package org.java2.filip.melerski.Zadanie009_ogólne.Zadanie005;

import java.util.Scanner;

public class ScanIn {

    public String scanString() {

        System.out.println("Please input a calculation to perform.\nPlease use format like: 'x.x + y.y' . For exponentiation please use 'p', for example:  4.5p3");

        Scanner scanIn = new Scanner(System.in);

        String calculationAsString = scanIn.nextLine();

        return calculationAsString;
    }
}
