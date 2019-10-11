package com.fisher.common;

import com.fisher.exception.NotFoundOperatorException;
import com.fisher.operator.Action;
import com.fisher.operator.Operator;
import com.google.common.base.Splitter;
import com.google.common.base.Strings;
import com.google.common.io.Closeables;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * com.fisher.common
 *
 * @author fisher
 * @date 2019-10-11
 */
public class OperatorRegistry {

	private static final String OPERATOR_RESOURCE_LOCATION = "operator.properties";
	private static final String OPERATOR_KEY = "operators";
	private static final Logger LOG = LoggerFactory.getLogger(OperatorRegistry.class);
	private static final String SEPARATOR = ",";


	public Map<String, Operator> register() {
		Map<String, Operator> operatorMap = new HashMap<>();
		Properties properties = loadProperties(OPERATOR_RESOURCE_LOCATION);

		if (properties != null) {
			String operatorsClassName = properties.getProperty(OPERATOR_KEY);

			if (Strings.isNullOrEmpty(operatorsClassName)) {
				throw new NotFoundOperatorException("Can not found any operator class in operator.properties.");
			}

			List<String> operatorClassNameList = Splitter.on(SEPARATOR).splitToList(operatorsClassName);
			for (String operatorClassName : operatorClassNameList) {
				try {
					Class<Operator> clazz = (Class<Operator>) Class
							.forName(operatorClassName, true, ClassLoader.getSystemClassLoader());

					Action operatorAction = clazz.getAnnotation(Action.class);
					if (operatorAction != null) {
						operatorMap.put(operatorAction.value(), clazz.newInstance());
					}
				} catch (Exception e) {
					LOG.warn("Operator:" + operatorClassName + " load failed");
				}
			}
		}
		return operatorMap;
	}

	private Properties loadProperties(String location) {
		InputStream in = this.getClass().getClassLoader().getResourceAsStream(location);
		Properties props = new Properties();
		try {
			props.load(in);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			Closeables.closeQuietly(in);
		}
		return props;
	}

}
