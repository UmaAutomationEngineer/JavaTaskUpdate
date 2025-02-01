package epam.tasks.designpattern.strategy;

public class BasicPlan implements CameraApp {
	@Override
    public void takePhoto() {
        System.out.println("Photo clicked by Basic Camera app");
    }

    @Override
    public void editPhoto() {
        System.out.println("Photo edited by Basic Camera app");
    }

    @Override
    public void savePhoto() {
        System.out.println("Photo saved by Basic Camera app");
    }

    @Override
    public void sharePhoto(ShareStrategy shareStrategy) {
        shareStrategy.share();
    }


}
