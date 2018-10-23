package rmi.file.system.client;

import java.rmi.Naming;
import java.rmi.RemoteException;

import rmi.file.system.server.IFileSystem;
import rmi.file.system.utils.Exceptions;

public class Client {
	private IFileSystem server;
    
    public void startClient() throws Exception {        
        String url = "rmi://localhost/server";
        server = (IFileSystem) Naming.lookup(url);        
        System.out.println("lalala");        
    }
    
    public String[] getLs() {
    	String []  ret= null;
    	try {
			ret = server.ls("c:");
		} catch (RemoteException e) {
			Exceptions.getException(e);
		}
    	
    	return ret; 
    }
}