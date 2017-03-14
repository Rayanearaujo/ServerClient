import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	public void SendMessage(){
		try {
			Socket socket = new Socket("localhost", 5007);
			OutputStream os = socket.getOutputStream();
			String message = "Hello Server! Can we talk?";
			System.out.println("Mensagem enviada para o servidor: " + message);
			os.write(message.getBytes());
			
			InputStream is = socket.getInputStream();
			byte[] bs = new byte[40];
			is.read(bs);
			String s = new String(bs);
			System.out.println("Mensagem recebida do servidor: " + s);
			
			is.close();
			os.close();
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
