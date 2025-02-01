package epam.tasks.designpattern.strategy;

public class Message implements ShareStrategy {
	 @Override
	    public void share() {
	        System.out.println("Photos shared by Message");
	    }


}
