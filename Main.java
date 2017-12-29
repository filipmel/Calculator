package org.java2.filip.melerski.Zadanie009_ogólne.Zadanie005;

import java.util.Calendar;

public class Main {

    public static void main(String[] args) {

        ScanIn MyScanner = new ScanIn();
        String scannedCalc = MyScanner.scanString();

        Calculator MyCalc = new Calculator();
        double result = MyCalc.calculate(scannedCalc);
        System.out.println("The result is :" + result);

    }
}
