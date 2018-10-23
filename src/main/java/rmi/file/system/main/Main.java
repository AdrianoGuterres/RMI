package rmi.file.system.main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import rmi.file.system.utils.Exceptions;

public class Main extends Application {

	private static Stage stage;
	private static Scene mainScene;
	private static Scene mainServerScene;
	private static Scene mainClientScene;
	
	private static Scene fileSistem;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		stage = primaryStage;
		stage.initStyle(StageStyle.UTILITY);
		try {
			Parent mainSceneLoad = FXMLLoader.load(getClass().getResource("/rmi/file/system/ressources/MainUI.fxml"));
			mainScene = new Scene(mainSceneLoad);	

			Parent mainClientSceneLoad = FXMLLoader.load(getClass().getResource("/rmi/file/system/ressources/ClientMainUI.fxml"));
			mainClientScene = new Scene(mainClientSceneLoad);
			
			Parent mainServerSceneLoad = FXMLLoader.load(getClass().getResource("/rmi/file/system/ressources/ServerMainUI.fxml"));
			mainServerScene = new Scene(mainServerSceneLoad);
			
			Parent fileSistemp = FXMLLoader.load(getClass().getResource("/rmi/file/system/ressources/ClientFileManagerUI.fxml"));
			fileSistem = new Scene(fileSistemp);
			
			

		} catch (Exception e) {
			Exceptions.getException(e);			
		}
		setScene("Adriano Guterres", mainScene);
	}	

	public static void changeScreen(String screen) {		
		switch (screen) {
		case "server":			
			setScene("File System", mainServerScene);
			break;		
		case "client":			
			setScene("File System", mainClientScene);
			break;
			
		case "file":			
			setScene("File System", fileSistem);
			break;
		default:
			break;
		}
	}

	public static void setScene(String title, Scene scene) {
		stage.setTitle(title);		
		stage.setResizable(false);
		stage.setScene(scene);		
		stage.show();		
	}
	
	public static void fileSystem() {
		
	}
}
