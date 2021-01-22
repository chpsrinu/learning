package MazeProblem;

public class App {

	public static void main(String[] args) {
		FileReader fileReader = new FileReader("/Users/pchowdad/Documents/Pydi/sampletest/learning/sampletest/src/main/java/MazeProblem/test2", 7, 7);
		fileReader.parseFile();
		MazeSolver mazeSolver = new MazeSolver(fileReader.getMap(), fileReader.getStartPositionRow(), fileReader.getStartPositionCol());
		mazeSolver.findWayOut();
	}
}
