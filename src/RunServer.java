
public class RunServer {

	public static void main(String[] args) {
		/*Thread serverThread = new Thread(new Runnable() {
			@Override
			public void run() {
				new Server();
			}
		});
		serverThread.start();*/
		new Server();
	}

}
