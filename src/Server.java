import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class Server {
	public Server(){
		try {
			ServerSocket ss = new ServerSocket(5001);
			System.out.println("Servidor ativo!");
			Socket socket = ss.accept();
			
			InputStream is = socket.getInputStream();
			byte[] bs = new byte[15];
			is.read(bs);
			System.out.println("Recebendo do cliente a mensagem: " + new String(bs) 
					+ " de: " + socket.getInetAddress().getHostAddress());
			
			OutputStream os = socket.getOutputStream();
			String message = "Hello client!";
			os.write(message.getBytes());
			System.out.println("Enviando para o cliente a mensagem: " + message
					+ " para: " + socket.getInetAddress().getHostAddress());
			
			is.close();
			os.close();
			ss.close();
			socket.close();
		
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
}
