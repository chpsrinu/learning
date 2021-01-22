package learning;

import java.util.HashMap;
import java.util.Map;

public class TaskSchedulerCoolDown {

	static int timeSlots(String str, int cooldown) {
		if(cooldown<=0) return str.length();
		if(str ==null || str.length() <=0) return -1;
		
		Map<Character, Integer> lastTimeSlot = new HashMap<>();
		int result = 0;
		//int taskIndex = 0;
		
		for(int i =0;i<str.length();) {
			char c = str.charAt(i);
			Integer last = lastTimeSlot.get(c);
			if(last == null || result-last>cooldown) {
				lastTimeSlot.put(c, result);
				i++;
			}
			result++;
		}
		return result;
	}
	
	public static void main(String[] args) {
		String str = "ABACAAC";
		//AB_AC_A__AC
		System.out.println(timeSlots(str, 2));
	}
}
