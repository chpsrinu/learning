package BoyerMoore;

import java.util.HashMap;
import java.util.Map;

public class BoyerMoore {

	private String text;
	private String pattern;
	private Map<Character, Integer> mismatchShiftTable;
	
	public BoyerMoore(String text, String pattern) {
		this.text = text;
		this.pattern = pattern;
		this.mismatchShiftTable = new HashMap<Character, Integer>();
	}
	
	public void precomputeShifts() {
		int lengthOfPattern = this.pattern.length();
		for(int i=0;i<lengthOfPattern;i++) {
			char actualChar = this.pattern.charAt(i);
			int maxShift = Math.max(1, lengthOfPattern-i-1);
			this.mismatchShiftTable.put(actualChar, maxShift);
		}
	}
	
	public int search() {
		int lengthOfPattern = this.pattern.length();
		int lengthOfText = this.text.length();
		int numsSkip;
		
		for (int i=0;i<lengthOfText-lengthOfPattern;i+=numsSkip) {
			numsSkip = 0;
			for (int j=lengthOfPattern-1;j>=0;j--) {
				if(this.pattern.charAt(j) != this.text.charAt(i+j)) {
					
					if(this.mismatchShiftTable.get(text.charAt(i+j)) != null) {
						numsSkip = mismatchShiftTable.get(text.charAt(i+j));
						break;
					} else {
						numsSkip = lengthOfPattern;
						break;
					}
				}
			}
			if (numsSkip == 0) return i;
		}
		return lengthOfText;
	}
}
