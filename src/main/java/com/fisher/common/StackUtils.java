package com.fisher.common;

import java.util.Stack;

/**
 * @author Yu.He
 */
public class StackUtils {

    public static <E> void copy(Stack<E> from, Stack<E> to) {
        if (!from.isEmpty() && to != null) {
            to.clear();
            for (E e : from) {
                to.push(e);
            }
        }
    }
}
