package epam.tasks.designpattern.decorator;

public class WidgetDecorator implements WebPage {
	protected WebPage webPageDecorator;
    public WidgetDecorator(WebPage webPageDecorator) {
        this.webPageDecorator = webPageDecorator;
    }

    @Override
    public int getRank() {
        return webPageDecorator.getRank();
    }


}
