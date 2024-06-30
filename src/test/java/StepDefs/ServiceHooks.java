package StepDefs;

import BaseTest.BaseClass;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import java.io.IOException;

public class ServiceHooks {

    BaseClass baseClass;
    private static final Logger logger = LoggerFactory.getLogger(ServiceHooks.class);

    @Before
    public void initializeTest() throws IOException {
        baseClass = new BaseClass();
        baseClass.initializeDriver();
    }

    @After
    public void endTest(Scenario scenario) {
        if (scenario.isFailed()) {
            try {
                logger.info("{} is Failed", scenario.getName());
                final byte[] screenshot = ((TakesScreenshot) BaseClass.driver).getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot, "image/png", "Screenshot");
            } catch (WebDriverException e) {
                logger.error("An error occurred while taking screenshot: ", e);
            }
        } else {
            try {
                logger.info("{} is passed", scenario.getName());
                final byte[] screenshot = ((TakesScreenshot) BaseClass.driver).getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot, "image/png", "Screenshot");
            } catch (Exception e) {
                logger.error("An error occurred while taking screenshot: ", e);
            }
        }

        BaseClass.driver.quit();
    }
}
