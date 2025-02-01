package epam.tasks.designpattern.strategy;

public interface CameraApp {
	
	void takePhoto();
    void editPhoto();
    void savePhoto();
    void sharePhoto(ShareStrategy shareStrategy);


}
