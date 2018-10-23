package rmi.file.system.controller;

import java.io.IOException;
import java.net.InetAddress;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import rmi.file.system.client.Client;
import rmi.file.system.server.Server;
import rmi.file.system.utils.Exceptions;

public class ServerController implements Initializable{

	private Server server;

	@FXML
	private TextField ipTextfield;

	@FXML
	private TextField portTextfield;

	@FXML
	private Button startButton;

	@FXML
	private Button stopButton;

	@FXML
	private void handleStopButton(ActionEvent event) throws IOException {		
		try {
			this.server.stopServer();
		} catch (Exception e) {
			Exceptions.getException(e);
		}
	}

	@FXML
	private void handleStartButton(ActionEvent event) throws IOException {
		try {
			this.server.startServer();
		} catch (Exception e) {
			Exceptions.getException(e);
		}
	}

	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		this.server = new Server();
		String ip = "";
		try {
			 ip = InetAddress.getLocalHost().getHostAddress();
		} catch (UnknownHostException e) {
			Exceptions.getException(e);			
		}
		
		this.ipTextfield.setText(ip);
		this.portTextfield.setText("1099");
		
	}

}
