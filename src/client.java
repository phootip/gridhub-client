import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class client {
	public static void main(String args[]) throws UnknownHostException, IOException, InterruptedException{
		Scanner sc = new Scanner(System.in);

		String host = "ec2-54-169-13-133.ap-southeast-1.compute.amazonaws.com";
//		String host = "localhost";
		int port = 3004;
		
		System.out.println(">> Application is starting...");

		Socket socket = new Socket(host,port);
		BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
		
		Reader r = new Reader(out,sc);
		r.start();
		
		System.out.println(">> Welcome to Gridhub online !!!");
		System.out.println(">> need help? Type \"help\"");
		while(true){
			
//			String msg = sc.nextLine();
//			System.out.println("sending: "+ msg);
//			out.println(msg);
			String line = in.readLine();
			System.out.println(">> " + line);
			if(line.split(" ")[0].equals("publicIP")){
				String ip = line.split(" ")[1];
				System.out.println(ip);
				ip = ip.trim();
				System.out.println("received public IP: "+ ip);
				System.out.println("executing game...");
				Thread.sleep(60000);
				Runtime rt = Runtime.getRuntime();
				Process pr = rt.exec("java -jar grid.jar "+ip+" >> game.log");
				System.out.println("game should be running and recording...");
				int ret = pr.waitFor();
				System.out.println("return is:" + pr);
				break;
			}
			
			if(line.trim().equals("0")) break;
		}
		
		r.interrupt();
		
		socket.close();
		System.out.println("application end");
	}
}
