package com.fisher;

import com.fisher.exception.EmptyExpressionException;
import com.fisher.operator.Operator;
import com.google.common.base.Strings;
import com.google.common.collect.Maps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.Scanner;

public class Application {

	private static final Logger log = LoggerFactory.getLogger(Application.class);
	private static Map<String, Operator> operatorMap = Maps.newHashMap();


	public static void main(String[] args) {

		log.info("----Welcome to the RPN calculator, please enter your expression.----");

		Scanner in = new Scanner(System.in);
		while (in.hasNextLine()) {
			String text = in.nextLine();

			if (Strings.isNullOrEmpty(text)) {
				throw new EmptyExpressionException();
			}

			log.info("output buffer:" + text);
		}
	}

}
