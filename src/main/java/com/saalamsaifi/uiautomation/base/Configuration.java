package com.saalamsaifi.uiautomation.base;

import static com.saalamsaifi.uiautomation.property.WebDriverProperty.PROP_BROWSER;
import static com.saalamsaifi.uiautomation.property.WebDriverProperty.PROP_DRIVER_CONFIG;
import static com.saalamsaifi.uiautomation.property.WebDriverProperty.PROP_DRIVER_PATH_CHROME;
import static com.saalamsaifi.uiautomation.property.WebDriverProperty.PROP_DRIVER_PATH_FIREFOX;
import static com.saalamsaifi.uiautomation.property.WebDriverProperty.PROP_OS;
import static com.saalamsaifi.uiautomation.property.WebDriverProperty.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;
import java.util.Properties;

import org.apache.http.util.TextUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.saalamsaifi.uiautomation.util.Utils;

public class Configuration {
	private static final String APP_PROPERTIES_PATH = Utils.USER_DIR + "/src/main/resources/application.properties";
	private static final Logger LOGGER = LogManager.getLogger(Configuration.class);

	private static Configuration configuration;
	private Properties properties;

	private Configuration() {
		properties = new Properties();

		properties.setProperty(PROP_BROWSER, PROP_DEFAULT_BROWSER);
		properties.setProperty(PROP_OS, PROP_DEFAULT_OS);
		properties.setProperty(PROP_DEFAULT_REPORT_PATH, PROP_DEFAULT_REPORT_PATH);
		properties.setProperty(PROP_DEFAULT_REPORT_FILENAME, PROP_DEFAULT_REPORT_FILENAME);
		properties.setProperty(PROP_DRIVER_CONFIG, PROP_DEFAULT_DRIVER_CONFIG);
		properties.setProperty(PROP_DRIVER_PATH_CHROME, PROP_DEFAULT_DRIVER_PATH_CHROME);
		properties.setProperty(PROP_DRIVER_PATH_FIREFOX, PROP_DEFAULT_DRIVER_PATH_FIREFOX);
	}

	/**
	 * @return
	 */
	public static Configuration getConfiguration() {
		if (Objects.isNull(configuration)) {
			configuration = new Configuration();
		}
		return configuration;
	}

	private InputStream read() throws FileNotFoundException {
		return new FileInputStream(new File(APP_PROPERTIES_PATH));
	}

	/**
	 * 
	 */
	public void load() {
		Properties customProperties = new Properties();
		try {
			customProperties.load(read());
		} catch (IOException e) {
			LOGGER.error(e.getMessage(), e);
		}

		updateProperty(PROP_BROWSER, customProperties.get(PROP_BROWSER));
		updateProperty(PROP_OS, customProperties.get(PROP_OS));
		updateProperty(PROP_DRIVER_CONFIG, customProperties.get(PROP_DRIVER_CONFIG));
		updateProperty(PROP_DEFAULT_REPORT_PATH, customProperties.get(PROP_DEFAULT_REPORT_PATH));
		updateProperty(PROP_DEFAULT_REPORT_FILENAME, customProperties.get(PROP_DEFAULT_REPORT_FILENAME));

		if (properties.get(PROP_DRIVER_CONFIG) == "custom") {
			updateProperty(PROP_DRIVER_PATH_CHROME, customProperties.get(PROP_DRIVER_PATH_CHROME));
			updateProperty(PROP_DRIVER_PATH_FIREFOX, customProperties.get(PROP_DRIVER_PATH_FIREFOX));
		}

	}

	private void updateProperty(String key, Object value) {
		if (!TextUtils.isBlank((String) value)) {
			properties.setProperty(key, (String) value);
		}
	}

	/**
	 * @return
	 */
	public Properties getProperties() {
		return properties;
	}

	/**
	 * @param key
	 * @return
	 */
	public Object getProperty(Object key) {
		return properties.get(key);
	}

	/**
	 * @return
	 */
	public String getAppPropertiesPath() {
		return APP_PROPERTIES_PATH;
	}
}
