import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.*;


public class RPNStack {

	public static void main(String[] args) throws FileNotFoundException{
		// TODO Auto-generated method stub
		Scanner in = new Scanner(openFile());

		Stack<Integer> stack = new Stack<>();

		int currentX, currentY; //expressao no formato "x <operador> y
		char currentOperator;


		while (in.hasNext()) {

			if(in.hasNextInt()) {
				int inteiro = in.nextInt();
				stack.push(inteiro);

			}else {

				currentOperator = in.next().charAt(0);
				currentY = stack.pop();
				currentX = stack.pop();

				
				if (currentOperator == '+') {				
					stack.push(currentX + currentY);
					
				}else if (currentOperator == '-') {
					stack.push(currentX - currentY);
					
				}else if (currentOperator == '*') {
					stack.push(currentX * currentY);
					
				}else {
					stack.push(currentX / currentY);
				}
			}
		}
		System.out.println("the answer is " + stack.pop());

	}

	private static File openFile() {
		URL url = RPNStack.class.getClassLoader().getResource("Calc1.stk");
		assert url != null;
		return new File(url.getPath());
	}

}
