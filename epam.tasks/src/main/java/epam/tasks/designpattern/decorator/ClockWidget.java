package epam.tasks.designpattern.decorator;

public class ClockWidget extends WidgetDecorator {
	public ClockWidget(WebPage webPageDecorator) {
        super(webPageDecorator);
    }

    @Override
    public int getRank() {
        int clocksWidgetRank = 5;
        System.out.println("Adding Clock Widget rank "+ clocksWidgetRank +" to the Web Page rank"+super.getRank());
        return super.getRank() + clocksWidgetRank;
    }


}
