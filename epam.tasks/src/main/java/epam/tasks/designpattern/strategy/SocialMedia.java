package epam.tasks.designpattern.strategy;

public class SocialMedia implements ShareStrategy {
	@Override
    public void share() {
        System.out.println("Photos shared by Social Media");
    }


}
