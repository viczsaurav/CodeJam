import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;


public class PasswordCrack {
	
	public static int factorial(int n) {
		if (n == 0)
			return 1;
	    else
	    	return n * factorial(n-1);
    }

	public static void main(String[] args) 
			throws NumberFormatException,IOException {
		BufferedReader br = new BufferedReader(new FileReader(new File("pcinput.in")));
		PrintWriter out = new PrintWriter("pcoutput.out");
		int numOfTestCase = 0;
		int modulo = 1000000007;
		numOfTestCase = Integer.parseInt(br.readLine());
//		System.out.println(numOfTestCase);
		
		for (int i = 1; i <= numOfTestCase; i++) {
			String strArray[] = br.readLine().split(" ");
			Integer m = Integer.parseInt(strArray[0]);	// Actual found
			Integer n = Integer.parseInt(strArray[1]);	// Password Actual Length			
			
			int nr = factorial(n);
			int dr = factorial(n-m+1);
			
			if(m==n)
				out.println("Case #" + Integer.toString(i) + ": " + (nr/dr)%modulo);
//				System.out.println((nr/dr)%modulo);
			else
				out.println("Case #" + Integer.toString(i) + ": " + (m* (nr/dr))%modulo);
//				System.out.println((m* (nr/dr))%modulo);
			
//			out.println("Case #" + Integer.toString(i) + ": " + 100%49);
		}		
		
		out.close();
		br.close();
		}
	}