import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Reader extends Thread{
	Socket socket;
	Scanner sc;
	String msg;
	boolean running = true;
	PrintWriter out;
	
	Reader(PrintWriter out,Scanner sc) throws IOException{
		this.out = out;
		this.sc = sc;
	}
	
	public void terminate(){
		running = false;
	}
	
	@Override
	public void run(){
		try{			
			while(running){
				System.out.println("");
				msg = sc.nextLine();
//				System.out.println("read and send from commandline: " + msg);
				out.println(msg);
				if(msg.equals("0")) running = false;
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("Reader end");
	}
}
