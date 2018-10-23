package rmi.file.system.controller;

import java.net.URL;
import java.nio.file.Files;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import rmi.file.system.client.Client;
import rmi.file.system.utils.Exceptions;

public class ClientFileManagerController implements Initializable{
	
	private Client client;
	
	
	
	@FXML
	private  TextArea area;
	
	@FXML
	public void handleSelectOneFileAction(ActionEvent event) {		
		
	}
	
	@FXML
	public void handleSelectMultipleFilesButtonAction(ActionEvent event) {
		
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		this.client = new Client();
		try {
			this.client.startClient();
		} catch (Exception e) {
			Exceptions.getException(e);
		}
		
	 String[] aux = client.getLs();
	 
	 for(String x:aux) {
		 area.appendText(x);		 
	 }
		
	}

	

}
