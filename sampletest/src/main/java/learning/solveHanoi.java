package learning;

public class solveHanoi {
	public static void soveHanoiProblem(int n, char rodFrom, char middleRod, char rodTo) {
		if(n == 1) {
			System.out.println("Plate 1 from "+rodFrom+" to "+rodTo);
			return;
		}
		
		soveHanoiProblem(n-1, rodFrom, rodTo, middleRod);
		System.out.println("Plate "+n+" from "+rodFrom+" to "+rodTo);
		soveHanoiProblem(n-1, middleRod, rodFrom, rodTo);
	}
	
	public static void main(String[] args) {
		soveHanoiProblem(4, 'A', 'B', 'C');
	}

}
