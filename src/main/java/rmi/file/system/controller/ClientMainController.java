package rmi.file.system.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.text.Text;
import rmi.file.system.client.Client;
import rmi.file.system.main.Main;
import rmi.file.system.utils.Exceptions;

public class ClientMainController implements Initializable {
	
	private Client client; 	
	
	
	@FXML
	private Text ipField;
	
	@FXML
	private Text doorField;
	
	@FXML
	private Button connectButton;
	
	@FXML
	private ListView listView;
	
	
	@FXML
	private void buttonAction(ActionEvent connectButton ) {
		Main.changeScreen("file");
		
	}
	
	@FXML
	private void ipMask() {
		
	}
	
	@FXML
	private void doorMask() {
		
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
					
	}
	
}
