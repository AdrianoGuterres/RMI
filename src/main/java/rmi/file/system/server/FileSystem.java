package rmi.file.system.server;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;


public class FileSystem extends UnicastRemoteObject implements IFileSystem {

	private static final long serialVersionUID = 1L;
	Registry rmiRegistry;
    public FileSystem() throws RemoteException {
        super();
    }
    
    public void start() throws Exception {
        rmiRegistry = LocateRegistry.createRegistry(1099);
        rmiRegistry.bind("server", this);
        System.out.println("Server started");
    }
    
    public void stop() throws Exception {
        rmiRegistry.unbind("server");
        unexportObject(this, true);
        unexportObject(rmiRegistry, true);
    }	
	
	@Override
	public boolean unlink(String path) throws RemoteException{		
		boolean aux = false;		
		try {
			Files.delete(Paths.get(path));
			aux = true;
		} catch (IOException e) {
		}
		return aux;
	}
	
	@Override
	public int write(byte[] data, String path) throws RemoteException{
		Path pathAux = Paths.get(path);
		int ret = 0;
		try {
			byte[] dataAux = Files.readAllBytes(pathAux);
			ByteArrayInputStream arrayInputStream = new ByteArrayInputStream(dataAux);
			Files.copy(arrayInputStream, pathAux, LinkOption.NOFOLLOW_LINKS);
			ret = arrayInputStream.available();
		} catch (IOException e) {
		}
		return ret;
	}	
	
	@Override
	public byte[] read(String path) throws RemoteException{
		byte[] read = null;
		Path pathAux = Paths.get(path);
		try {
			byte[] data = Files.readAllBytes(pathAux);
			read = data;
		} catch (IOException e) {
		}
		return read;
	}
	
	@Override
	public String[] ls(String path) throws RemoteException{
		File dir = new File(path);
		File[] array = dir.listFiles();		
		String[] result = new String [array.length];		
		for(int i = 0; i < array.length; i++) {
			if(array[i].isDirectory()) {
				result[i] = array[i].getName();  
			}			
		}		
		return result;		 
	}	
	
	@Override
	public int append(byte[] data, String path) throws RemoteException {
		return 0;
	}	
	
	@Override
	public boolean mkdir(String path) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public boolean create(String path) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}
    
}