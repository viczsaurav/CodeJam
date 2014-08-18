import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class Super2048 {

	public static void main(String[] args) 
			throws NumberFormatException,IOException {
		BufferedReader br = new BufferedReader(new FileReader(new File("Super2048.in")));
		PrintWriter out = new PrintWriter("Super2048.out");
		int numOfTestCase = 0;
		numOfTestCase = Integer.parseInt(br.readLine());
		
		for (int i = 1; i <= numOfTestCase; i++) {
			String strArray[] = br.readLine().split(" ");
			Integer N = Integer.parseInt(strArray[0]);
			String direction = strArray[1];
			
			Integer [][] preBoard = new Integer[N][N];
			
			for (int j = 0; j < N; j++) {
				String [] row = br.readLine().split(" ");				
				for (int k=0; k < row.length && k < N ;k++){
					preBoard[j][k] = Integer.parseInt(row[k]);
				}
			}
			
			switch(direction){
				case "right":
					for (int x = 0; x < N; x++) {
						for (int j = N-1; j >=1; j--) {
							int firstNode = j; // Pointer 1 for 1st Value node
							int secondNode;	// Pointer 2 for 2nd Value node
							
							while(preBoard[x][firstNode]==0 && firstNode>0) // If current value is zero
								firstNode--;
							if (firstNode ==0){
								secondNode = firstNode;
							}
							else {
								secondNode = firstNode-1;
							}
							
							while(preBoard[x][secondNode]==0 && secondNode>0) // If 2nd Node value is zero
								secondNode--;
							
							if((preBoard[x][secondNode] == preBoard[x][firstNode])	// Add if Values equal
									&& secondNode!= firstNode){			// Handling case when both point to same
								preBoard[x][j] = preBoard[x][firstNode]*2;
								if(secondNode!=j)		//If not current Node
									preBoard[x][secondNode]=0;		// Since Value has been used up, making it zero
								
							}
							else {//if(secondNode == firstNode){
								preBoard[x][j] = preBoard[x][firstNode]; 
							// If Value not equal or both nodes point to same,just shift the value to current position
							}
							if(firstNode!=j)							// Making 1st value node iff its not current node
								preBoard[x][firstNode] = 0;
						}
					}
					break;
				case "up":
					break;
				case "left":
					break;
				case "down":
					break;
				default:
					break;
					
			}
			out.println("Case #" + Integer.toString(i) + ":");
			for (int j = 0; j < preBoard.length; j++) {
				for (int k = 0; k < preBoard.length; k++) {
					out.print(" "+ preBoard[j][k]);
				}
				out.println("");
			}		
		}
		out.close();
		br.close();
	}
}