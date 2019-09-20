package DijkstraInterpreter;

public class App {

	public static void main(String[] args) {
		
		Algorithm alg = new Algorithm();
		alg.interpreterExpression("( ( 2 + 3 ) * ( 4 + 5 ) )");
		alg.result();
	}
}
