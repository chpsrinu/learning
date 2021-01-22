import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ReorderDataLogFiles
{ 
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("mi2 job mid pet");
		list.add("x4 45 21 7");
		list.add("wz3 34 54 398");
		list.add("a1 alps cow bar");
		
		System.out.println(reorderLines(4, list));
	}
	// METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    public static List<String> reorderLines(int logFileSize, List<String> logLines) 
	{
//    	if(logLines == null || logLines.isEmpty()) return null;
//		// WRITE YOUR CODE HERE
//		List<String> resultLogs = logLines.stream().filter(log -> log.split("\\s")[1].matches("[a-z]+"))
//		            .collect(Collectors.toList());
//		Collections.sort(resultLogs, (log1, log2) -> {
//		    String log1Text = log1.substring(log1.indexOf(" ") + 1);
//		    String log2Text = log2.substring(log2.indexOf(" ") + 1);
//		    return log1Text.equalsIgnoreCase(log2Text) ? log1.compareTo(log2) : log1Text.compareTo(log2Text);
//		    
//		});
//		
//		resultLogs.addAll(logLines.stream()
//		        .filter(log -> log.split("\\s")[1].matches("[0-9]+"))
//		        .collect(Collectors.toList()));
//		return resultLogs;   
    	
    	
    	
    	List<String> list = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        
        for(String s: logLines) {
            String sArr[] = s.split(" ");
            if(sArr[1].charAt(0)>='0' && sArr[1].charAt(0)<='9')
                list2.add(s);
            else
                list.add(s);
        }
        
        Comparator<String> comp = (s1, s2) -> {
            String s11=s1.substring(s1.indexOf(" ")+1, s1.length());
            String s21=s2.substring(s2.indexOf(" ")+1, s2.length());
            if(s11.compareTo(s21) == 0) {
                return s1.compareTo(s2);
            } else {
                return s11.compareTo(s21);
            }
        };
        Collections.sort(list,comp);
        Collections.sort(list2,comp);
        list.addAll(list2);
        return list;
	}
    
    
	// METHOD SIGNATURE ENDS
}