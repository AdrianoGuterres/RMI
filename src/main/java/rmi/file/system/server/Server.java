package rmi.file.system.server;

public class Server {   
	
	private FileSystem server;
	
    public void startServer() throws Exception {
    	server = new FileSystem();
        server.start();
              
    }
    
    public void stopServer() throws Exception {
    	 server.stop();
    }
}
