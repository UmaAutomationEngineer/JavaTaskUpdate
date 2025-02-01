package epam.tasks.designpattern.decorator;

public class MapsWidget extends WidgetDecorator{
	 public MapsWidget(WebPage webPageDecorator) {
	        super(webPageDecorator);
	    }

	    @Override
	    public int getRank() {
	        int mapsWidgetRank = 10;
	        System.out.println("Adding Maps Widget rank "+ mapsWidgetRank +" to the rank of Web Page "+super.getRank());
	        return super.getRank() + mapsWidgetRank;
	    }


}
