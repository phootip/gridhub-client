import java.io.IOException;

public class main {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		System.out.println("hello java");
//		System.out.println(args[0]);
		Runtime rt = Runtime.getRuntime();
		String ip = "13.250.37.100";
		Process pr = rt.exec("java -jar grid.jar "+ip);
		int ret = pr.waitFor();
		System.out.println("return is:" + pr);
	}

}
