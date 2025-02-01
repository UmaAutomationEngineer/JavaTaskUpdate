package epam.tasks.designpattern.strategy;

public class StrategyTask {

	public static void main(String[] args) {
		CameraApp cameraAppBasic = new BasicPlan();

        cameraAppBasic.takePhoto();
        cameraAppBasic.editPhoto();
        cameraAppBasic.savePhoto();
        cameraAppBasic.sharePhoto(new Email());

        System.out.println();

        CameraApp cameraAppPlus = new PlusPlan();

        cameraAppPlus.takePhoto();
        cameraAppPlus.editPhoto();
        cameraAppPlus.savePhoto();
        cameraAppPlus.sharePhoto(new SocialMedia());
        cameraAppPlus.sharePhoto(new Message());



	}

}
