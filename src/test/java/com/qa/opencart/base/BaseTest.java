package com.qa.opencart.base;


import org.testng.annotations.*;

import com.microsoft.playwright.Page;
import com.qa.opencart.factory.PlaywrightFactory;
import com.qa.opencart.pages.HomePage;
import com.qa.opencart.pages.LoginPage;

import java.util.Properties;


public class BaseTest {

	PlaywrightFactory pf;
	Page page;
	protected Properties prop;

	protected HomePage homePage;
	protected LoginPage loginPage;

	@Parameters({"browser"})
	@BeforeClass
	public void setup(String browserName) {
		pf = new PlaywrightFactory();

		prop = pf.init_prop();

		if(browserName != null){
			prop.setProperty("browser", browserName);
		}

		page = pf.initBrowser(prop);
		homePage = new HomePage(page);
	}

	@AfterClass
	public void tearDown() {
		page.context().browser().close();
	}
}
