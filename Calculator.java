package org.java2.filip.melerski.Zadanie009_ogólne.Zadanie005;

import org.apache.log4j.*;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

    public double calculate(String scannedCalc) {

        Layout myLayout = new PatternLayout("[%p] %c ( %m ) Date: %d %n");

        Appender myAppender = null;

        try {
            myAppender = new FileAppender(myLayout,"C:\\Users\\Filip&Aga\\Desktop\\log.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }

        BasicConfigurator.configure(myAppender);
        Logger logger = Logger.getLogger("Result of calculation: ");

        String divider = "(\\+|\\-|\\/|\\*|p)";
        String[] figsArr = scannedCalc.split(divider);
        double result = 0;
        double[] realFigsArr = new double[figsArr.length];
        for (int i = 0; i < figsArr.length; i++) {
            realFigsArr[i] = Double.valueOf(figsArr[i]);
        }

        String add = "((\\d+\\.\\d+)|\\d+)\\+((\\d+\\.\\d+)|\\d+)";
        String sub = "((\\d+\\.\\d+)|\\d+)\\-((\\d+\\.\\d+)|\\d+)";
        String mul = "((\\d+\\.\\d+)|\\d+)\\*((\\d+\\.\\d+)|\\d+)";
        String div = "((\\d+\\.\\d+)|\\d+)\\/((\\d+\\.\\d+)|\\d+)";
        String pow = "((\\d+\\.\\d+)|\\d+)p((\\d+\\.\\d+)|\\d+)";

        boolean adding = scannedCalc.matches(add);
        boolean subtracting = scannedCalc.matches(sub);
        boolean multiplying = scannedCalc.matches(mul);
        boolean dividing = scannedCalc.matches(div);
        boolean power = scannedCalc.matches(pow);

        if (adding) {
            result = realFigsArr[0] + realFigsArr[1];
            logger.info(realFigsArr[0] + " + " + realFigsArr[1] + "=" + result);
        } else if (subtracting) {
            result = realFigsArr[0] - realFigsArr[1];
            logger.info(realFigsArr[0] + " - " + realFigsArr[1] + "=" + result);
        } else if (multiplying) {
            result = realFigsArr[0] * realFigsArr[1];
            logger.info(realFigsArr[0] + " * " + realFigsArr[1] + "=" + result);
        } else if (dividing) {
            result = realFigsArr[0] / realFigsArr[1];
            logger.info(realFigsArr[0] + " / " + realFigsArr[1] + "=" + result);
        } else if (power) {
            result =Math.pow(realFigsArr[0],realFigsArr[1]);
            logger.info(realFigsArr[0] + " raised to the power of  " + realFigsArr[1] + "=" + result);
        }
        logger.info("Calculation finished");

        return result;
    }
}
