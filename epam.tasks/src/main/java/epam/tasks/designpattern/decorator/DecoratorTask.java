package epam.tasks.designpattern.decorator;

public class DecoratorTask {
	

	public static void main(String[] args) {
        WebPage desktopWebPage = new DesktopWebPage();
        System.out.println("Rank of Desktop WebPage is: " + desktopWebPage.getRank() + "\n");
        WebPage mapsWidgetDesktopWebPage = new MapsWidget(new DesktopWebPage());
        System.out.println("Rank of Desktop WebPage having Maps widget is: " + mapsWidgetDesktopWebPage.getRank() + "\n");
        WebPage clockWidgetDesktopWebPage = new ClockWidget(new DesktopWebPage());
        System.out.println("Rank of Desktop WebPage having Clock widget is: " + clockWidgetDesktopWebPage.getRank() + "\n");

        System.out.println();

        WebPage mobileWebPage = new MobileWebPage();
        System.out.println("Rank of Mobile WebPage is: " + mobileWebPage.getRank() + "\n");
        WebPage mapsWidgetMobileWebPage = new MapsWidget(new MobileWebPage());
        System.out.println("Rank of Mobile WebPage having Maps widget is: " + mapsWidgetMobileWebPage.getRank() + "\n");
        WebPage clockWidgetMobileWebPage = new ClockWidget(new MobileWebPage());
        System.out.println("Rank of Mobile WebPage having Clock widget is: " + clockWidgetMobileWebPage.getRank() + "\n");

	}

}
