package rmi.file.system.utils;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class Exceptions {
	
	public static void getException(Exception e) {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Erro Fatal");
		alert.setHeaderText("Não foi possivel inicializar!");
		alert.setContentText(e.getMessage());
		alert.showAndWait();		
	}

}
