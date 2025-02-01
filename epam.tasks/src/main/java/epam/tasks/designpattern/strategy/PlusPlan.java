package epam.tasks.designpattern.strategy;

public class PlusPlan implements CameraApp {
	@Override
    public void takePhoto() {
        System.out.println("Photo clicked by Camera Plus app");
    }

    @Override
    public void editPhoto() {
        System.out.println("Photo edited by Camera Plus app");
    }

    @Override
    public void savePhoto() {
        System.out.println("Photo saved by Camera Plus app");
    }

    @Override
    public void sharePhoto(ShareStrategy shareStrategy) {
        shareStrategy.share();
    }


}
