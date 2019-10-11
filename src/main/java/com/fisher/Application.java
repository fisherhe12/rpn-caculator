package com.fisher;

import java.util.Scanner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Application {

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        log.info("----Welcome to the RPN calculator, please enter your expression.----");
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String text = in.nextLine();
            log.info("output buffer:" + text);
        }
    }

}
