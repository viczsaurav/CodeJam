import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

// Reverse Polish Notation
public class InfixToPostfix {

	private static final Set<Character> operator = new HashSet<>(
			Arrays.asList(new Character[] { '+', '-', '*', '/' }));

	public static void main(String[] args) throws Exception {
		Long start = System.currentTimeMillis();
		BufferedReader br = new BufferedReader(new FileReader(new File(
				"infix.in")));
		String in;
		while ((in = br.readLine()) != null) {
			System.out.println("Infix expression: " + in);
			System.out.println("PostFix expression: "
					+ infixToPostfix(in.toCharArray()));
		}
		System.out.println("Running time: "
				+ (System.currentTimeMillis() - start) + " ms");
	}

	private static String infixToPostfix(char[] in) {
		Stack<Character> opStack = new Stack<>();
		String result = "";
		for (char c : in) {
			if (isOpeningParentheses(c)) {
				opStack.push(c);
			} else if (isClosingParentheses(c)) {
				while (!opStack.isEmpty()
						&& !isOpeningParentheses(opStack.peek())) {
					result += opStack.pop();
				}
				opStack.pop(); // popping extra open parentheses
			} else if (!operator.contains(c))
				result += c;
			else if (operator.contains(c)) {
				while (!opStack.isEmpty()
						&& !isOpeningParentheses(opStack.peek()) // Checking for
																	// parentheses
						&& hasHigherPrecedence(opStack.peek(), c)) {
					result += opStack.pop();
				}
				opStack.push(c);
			}
		}
		while (!opStack.isEmpty()) {
			result += opStack.pop();
		}
		return result;
	}

	private static boolean hasHigherPrecedence(char first, char second) {
		return getPrecedenceVal(first) >= getPrecedenceVal(second);
	}

	private static int getPrecedenceVal(char s) {
		int val = 0;
		switch (s) {
		case '+':
			val = 0;
			break;
		case '-':
			val = 0;
			break;
		case '*':
			val = 1;
			break;
		case '/':
			val = 1;
			break;
		}
		return val;
	}

	private static boolean isOpeningParentheses(char p) {
		if (p == '(' || p == '{' || p == '{') {
			return true;
		}
		return false;
	}

	private static boolean isClosingParentheses(char p) {
		if (p == ')' || p == '}' || p == ']') {
			return true;
		}
		return false;
	}

}
