import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;


public class ParenthesesOrder {

	public static void main(String[] args)  
			throws NumberFormatException,IOException {
		BufferedReader br = new BufferedReader(new FileReader(new File("poinput.in")));
		PrintWriter out = new PrintWriter("pooutput.out");
		int numOfTestCase = 0;
		numOfTestCase = Integer.parseInt(br.readLine());
		System.out.println(numOfTestCase);
		
		for (int t = 1; t <= numOfTestCase; t++) {
			String strArray[] = br.readLine().split(" ");
			Integer n = Integer.parseInt(strArray[0]);	// n parentheses sequences
			Integer k = Integer.parseInt(strArray[1]);	// k-th smallest sequence in lexicographical order		
			
			System.out.println(n+", "+k);
			for(int i=n;i>0;i--){
				for(int j=i;j>0;j--){
					System.out.print("(");
				}
				for(int p=i;p>0;p--)
					System.out.print(")");
				}
			System.out.println("");
//			System.out.println("Case #" + Integer.toString(t) + ": " );
			}
		
		out.close();
		br.close();
		}

}
