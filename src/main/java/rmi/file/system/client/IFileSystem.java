package rmi.file.system.client;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IFileSystem extends Remote {
	public String[] ls(String path) throws RemoteException;
	 public boolean mkdir(String path) throws RemoteException;
	 public boolean create(String path) throws RemoteException;
	 public boolean unlink(String path) throws RemoteException;
	 public int write(byte[] data, String path) throws RemoteException;
	 public int append(byte[] data, String path) throws RemoteException;
	 public byte[] read(String path) throws RemoteException;
}
