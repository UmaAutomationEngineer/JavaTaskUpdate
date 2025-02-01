package epam.tasks.designpattern.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyChromeDriver implements Driver {
	@Override
	public WebDriver getDriver() {
        return new ChromeDriver();
    }


}
