package epam.tasks.designpattern.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class MyIEDriver implements Driver {
	
	 @Override
	    public WebDriver getDriver() {
	        return new InternetExplorerDriver();
	    }


}
