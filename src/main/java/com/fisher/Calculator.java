package com.fisher;

import com.fisher.common.NumberUtils;
import com.fisher.common.OperatorConstants;
import com.fisher.common.OperatorLoader;
import com.fisher.exception.EmptyExpressionException;
import com.fisher.exception.UnSupportedOperatorException;
import com.fisher.operator.Operator;
import com.google.common.base.Splitter;
import com.google.common.base.Strings;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * @author Yu.He
 */
public class Calculator {

    private static Map<String, Operator> operatorMap;

    private Stack<BigDecimal> operandStack;
    private Stack<BigDecimal> operandBufferStack;

    public Calculator() {
        init();
    }

    private void init() {
        OperatorLoader operatorLoader = new OperatorLoader();
        operatorMap = operatorLoader.load();
        operandStack = new Stack<>();
        operandBufferStack = new Stack<>();
    }

    public String execute(String inputText) {
        if (Strings.isNullOrEmpty(inputText)) {
            throw new EmptyExpressionException();
        }

        List<String> exprList = Splitter.on(" ").splitToList(inputText);
        for (int i = 0; i < exprList.size(); i++) {
            String expr = exprList.get(i);
            if (NumberUtils.isNumeric(expr)) {
                operandStack.push(NumberUtils.parse(expr));
                operandBufferStack.push(NumberUtils.parse(expr));
            } else {
                if (operatorMap.containsKey(expr)) {
                    Operator operator = operatorMap.get(expr);
                    operator.operate(operandStack, operandBufferStack, i + 1);
                } else {
                    throw new UnSupportedOperatorException(expr, i + 1);
                }
            }
        }
        return formatOperandStack();
    }

    private String formatOperandStack() {
        StringBuilder result = new StringBuilder();
        for (BigDecimal bigDecimal : operandStack) {
            BigDecimal value = bigDecimal
                .setScale(OperatorConstants.DEFAULT_FORMAT_PRECISION, BigDecimal.ROUND_HALF_UP);
            result.append(value);
            result.append(" ");
        }
        return result.length() > 0 ? result.deleteCharAt(result.length() - 1).toString()
            : result.toString();
    }

    public void reset() {
        if (!operandStack.isEmpty()) {
            operandStack.clear();
        }
        if (!operandBufferStack.isEmpty()) {
            operandBufferStack.clear();
        }
    }

}
