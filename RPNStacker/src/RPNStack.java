import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.*;


public class RPNStack {

	public static void main(String[] args) throws FileNotFoundException{
		// TODO Auto-generated method stub
		Scanner in = new Scanner(openFile());

		ArrayList<Token> tokens = new ArrayList<Token>();
		Stack<Integer> stack = new Stack<>();

		int currentX, currentY; //expressao no formato "x <operador> y
		char currentOperator;
		char currentSymbol;


		while (in.hasNext()) {

			if(in.hasNextInt()) {
				//int inteiro = in.nextInt();				
				//stack.push(inteiro);
				String numero = String.valueOf(in.nextInt()); 
				Token numToken = new Token(TokenType.NUM, numero);
				tokens.add(numToken);

			}else {
				currentSymbol = in.next().charAt(0);
		
				if (currentSymbol == '+') {	
					
					Token plusToken = new Token(TokenType.PLUS, String.valueOf(currentSymbol));
					tokens.add(plusToken);
					
				}else if (currentSymbol == '-') {
					
					Token minusToken = new Token(TokenType.MINUS, String.valueOf(currentSymbol));
					tokens.add(minusToken);
					
				}else if (currentSymbol == '*') {
					
					Token starToken = new Token(TokenType.STAR, String.valueOf(currentSymbol));
					tokens.add(starToken);
					
				}else if  (currentSymbol == '/'){
					
					Token slashToken = new Token(TokenType.SLASH, String.valueOf(currentSymbol));
					tokens.add(slashToken);
					
				}else {
					System.out.println("error");
				}
				
//				currentOperator = in.next().charAt(0);
//				currentY = stack.pop();
//				currentX = stack.pop();
//
//				
//				if (currentOperator == '+') {				
//					stack.push(currentX + currentY);
//					
//				}else if (currentOperator == '-') {
//					stack.push(currentX - currentY);
//					
//				}else if (currentOperator == '*') {
//					stack.push(currentX * currentY);
//					
//				}else {
//					stack.push(currentX / currentY);
//				}
			
			}
		}
		//System.out.println("the answer is " + stack.pop());
		System.out.println(tokens);

	}

	private static File openFile() {
		URL url = RPNStack.class.getClassLoader().getResource("Calc1.stk");
		assert url != null;
		return new File(url.getPath());
	}

}
