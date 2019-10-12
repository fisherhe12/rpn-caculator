package com.fisher;

import com.fisher.common.OperatorLoader;
import com.fisher.operator.Operator;
import java.util.Map;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Yu.He
 */
public class OperatorLoaderTest {

    private static final String ADD = "+";
    private static final String DIVIDE = "/";
    private static final String MULTIPLY = "*";
    private static final String SUBTRACT = "-";
    private OperatorLoader operatorLoader;


    @Before
    public void init() {
        operatorLoader = new OperatorLoader();
    }

    @Test
    public void testOperatorLoad() {
        Map<String, Operator> operatorMap = operatorLoader.load("operator-test.properties");
        Assert.assertNotNull(operatorMap);
        Assert.assertEquals(4, operatorMap.size());
        Assert.assertTrue(operatorMap.containsKey(ADD));
        Assert.assertTrue(operatorMap.containsKey(DIVIDE));
        Assert.assertTrue(operatorMap.containsKey(MULTIPLY));
        Assert.assertTrue(operatorMap.containsKey(SUBTRACT));

    }

}
