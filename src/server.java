import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class server {
	public static void main(String argsp[]) throws IOException
	{
		ServerSocket s1 = new ServerSocket(3004);
		Socket ss1 = s1.accept();
		Socket ss2 = s1.accept();
		Scanner sc1 = new Scanner(ss1.getInputStream());
		Scanner sc2 = new Scanner(ss1.getInputStream());
		int number = sc1.nextInt();
		
		int temp=number*2;
		
		PrintStream p1 = new PrintStream(ss1.getOutputStream());
		PrintStream p2 = new PrintStream(ss2.getOutputStream());
		p1.println(temp);
		p2.println(temp);
	}
}
