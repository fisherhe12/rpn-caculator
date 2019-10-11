package com.fisher;

import com.fisher.common.NumberUtils;
import com.fisher.common.OperatorRegistry;
import com.fisher.exception.UnSupportedOperatorException;
import com.fisher.operator.Operator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Stack;

/**
 * com.fisher.rpncaculator
 *
 * @author Yu.He
 */
public class Calculator {
	private static final Logger LOG = LoggerFactory.getLogger(Calculator.class);
	private static Map<String, Operator> operatorMap;

	private Stack<BigDecimal> operandStack;
	private Stack<BigDecimal> operandBufferStack;

	public Calculator() {
		init();
	}

	public static void main(String[] args) {

	}

	private void init() {
		OperatorRegistry operatorRegistry = new OperatorRegistry();
		operatorMap = operatorRegistry.register();
		operandStack = new Stack<>();
		operandBufferStack = new Stack<>();
	}

	public String execute(String inputText) {
		//todo empty
		String[] exprArray = inputText.split("\\s+");
		for (int i = 0; i < exprArray.length; i++) {
			String expr = exprArray[i];
			if (NumberUtils.isNumberic(expr)) {
				operandStack.push(NumberUtils.parse(expr));
				operandBufferStack.push(NumberUtils.parse(expr));

			} else {
				if (operatorMap.containsKey(expr)) {
					Operator operator = operatorMap.get(expr);

				} else {
					throw new UnSupportedOperatorException(expr, i);
				}
			}
		}

		operandBufferStack.clear();
		return operandStack.pop().setScale(10, BigDecimal.ROUND_HALF_UP).toString();
	}

}
