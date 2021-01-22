package learning;

public class IndentationWord {

	final static String spaces = "	";
	public static void printInd(int level) {
		for(int i=0;i<level;i++) {
			System.out.print(spaces);
		}
	}
	
	public static int dfs(String input, int ind, int level) {
		int n = input.length();
		if(n == ind) return n;
		
		StringBuilder sb = new StringBuilder();
		
		while(ind < n) {
			char chS = input.charAt(ind);
			if(chS == '(') {
				printInd(level);
				System.out.println("(");
				ind = dfs(input,ind+1,level+1);
			}else if(chS == ' ') {
				printInd(level);
				System.out.println(sb.toString());
				sb = new StringBuilder();
				ind++;
			} else if(chS == ')') {
				if(sb.length()>0) {
					printInd(level);
					System.out.println(sb.toString());
				}
				
				printInd(level-1);
				System.out.println(")");
				return ind+1;
			} else {
				sb.append(chS);
				ind++;
			}
		}
		return n;
	}
	
	public static void main(String[] args) {
		String input = "(hello word (bye bye))";
		dfs(input, 0, 0);
	}
}
