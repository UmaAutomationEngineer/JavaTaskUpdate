package epam.tasks.designpattern.strategy;

public class Email implements ShareStrategy{
	@Override
    public void share() {
        System.out.println("Photos shared by Email");
    }


}
