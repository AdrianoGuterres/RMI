package rmi.file.system.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import rmi.file.system.client.Client;
import rmi.file.system.main.Main;
import rmi.file.system.server.Server;
import rmi.file.system.utils.Exceptions;

public class MainController implements Initializable {
	
	
	
	
	@FXML
	private AnchorPane anchorPane;
	

	@FXML
	private void handleServerSideButton(ActionEvent event) throws IOException {
		Main.changeScreen("server");
		
	}

	@FXML
	private void handleClientSideButton(ActionEvent event) throws IOException {
		Main.changeScreen("client");		
	}

	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}

}
