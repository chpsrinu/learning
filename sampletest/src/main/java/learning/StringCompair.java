package learning;


	import java.io.*;
	import java.math.*;
	import java.security.*;
	import java.text.*;
	import java.util.*;
	import java.util.concurrent.*;
	import java.util.regex.*;

	public class StringCompair {

	    // Complete the marsExploration function below.
	    static int marsExploration(String s) {
	        int count =0;
	        for ( int i=0;i<s.length();) {
	            count += compairString ("SOS",s.substring(i,i+3), 0);
	            i+=3;
	        }
	        return count;
	    }
	    
	    public static int countChanges(String message) {
	        String sos = "SOS";
	        int count = 0;
	        for (int i = 0; i < message.length(); i++) {
	            if (message.charAt(i) != sos.charAt(i % 3)) count++;
	        }
	        return count;
	    }

	    static int compairString(String mess, String subMess, int count){
	        for (int i =0;i<mess.length();i++) {
	            if (mess.charAt(i) != subMess.charAt(i)) count++;
	        }
	        return count;
	    }
	    
	    static String hackerrankInString(String s) {
	        String input = "swathi";
	        int j =0;
	        if (input.length() > s.length()) return "NO";
	        for (int i=0;i<s.length();i++) {
	            if ( j< input.length() && s.charAt(i) == input.charAt(j)) {
	                j++;
	            }
	        }
	        if(j < input.length()) return "NO";
	        return "YES";

	    }

	    private static final Scanner scanner = new Scanner(System.in);

	    public static void main(String[] args) throws IOException {
	        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

	        //String s = scanner.nextLine();
	    	String s = "SOSSPSSQSSO";
	        int result = countChanges(s);

//	        bufferedWriter.write(String.valueOf(result));
//	        bufferedWriter.newLine();
//
//	        bufferedWriter.close();

	        //scanner.close();
	        System.out.println(hackerrankInString("sswaathi"));
	    }
	}

