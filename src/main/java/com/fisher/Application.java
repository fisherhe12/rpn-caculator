package com.fisher;

import java.util.Scanner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Application {

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {

        log.info("----Welcome to the RPN calculator, please enter your expression.----");
        Calculator calculator = new Calculator();

        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String text = in.nextLine();
            try {
                String result = calculator.execute(text);
                //Use log print instead of system.out
                log.info("output buffer:" + result);
            } catch (Exception e) {
                log.warn(e.getMessage());
            }
        }
    }
}
