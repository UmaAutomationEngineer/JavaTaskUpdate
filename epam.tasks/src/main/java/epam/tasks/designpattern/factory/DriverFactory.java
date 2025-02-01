package epam.tasks.designpattern.factory;

public class DriverFactory {
	
	private DriverFactory(){}
    public static Driver getDriver(BrowserType browserType){
        Driver driver = null;
        if (browserType.name().equalsIgnoreCase("Chrome")){
            driver = new MyChromeDriver();
        } else if (browserType.name().equalsIgnoreCase("IE")){
            driver = new MyIEDriver();
        } else if (browserType.name().equalsIgnoreCase("Firefox")) {
            driver = new MyFirefoxDriver();
        }
        return driver;
    }


}
