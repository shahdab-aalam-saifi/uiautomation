package com.saalamsaifi.uiautomation.util;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.remote.Command;
import org.openqa.selenium.remote.CommandExecutor;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.ImmutableMap;
import com.saalamsaifi.uiautomation.driver.UIWebDriver;
import com.saalamsaifi.uiautomation.js.Performance;

public final class Utils {
	private static ObjectMapper mapper;

	static {
		mapper = new ObjectMapper();
	}

	private Utils() {
		// private constructor
	}

	public static final String USER_DIR = System.getProperty("user.dir");

	/**
	 * @return
	 */
	public static Performance performance() {
		Object result = UIWebDriver.getInstance().getJSExecutor().executeScript("return performance");
		return mapper.convertValue(result, Performance.class);
	}

	/**
	 * @param offline
	 * @param latency
	 * @param downloadSpeed
	 * @param uploadSpeed
	 * @throws IOException
	 */
	public static void network(boolean offline, int latency, int downloadSpeed, int uploadSpeed) throws IOException {
		CommandExecutor commandExecutor = UIWebDriver.getInstance().getCommandExecutor();

		Map<String, Object> map = new HashMap<>();
		map.put("offline", offline);
		map.put("latency", latency);
		map.put("download_throughput", downloadSpeed);
		map.put("upload_throughput", uploadSpeed);

		commandExecutor.execute(new Command(UIWebDriver.getInstance().getRemoteWebDriver().getSessionId(),
				"setNetworkConditions", ImmutableMap.of("network_conditions", ImmutableMap.copyOf(map))));
	}
}
