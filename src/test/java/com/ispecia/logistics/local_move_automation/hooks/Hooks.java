package com.ispecia.logistics.local_move_automation.hooks;

import com.ispecia.logistics.local_move_automation.utils.DriverFactory;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

	@Before
	public void setup() {

		DriverFactory.initializeDriver();
	}
//
//	@After
//	public void tearDown() {
//
//		DriverFactory.quitDriver();
//	}
}
