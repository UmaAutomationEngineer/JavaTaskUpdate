package epam.tasks.designpattern.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MyFirefoxDriver implements Driver {

	@Override
    public WebDriver getDriver() {
        return new FirefoxDriver();
    }

}
