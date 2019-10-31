package QuickSelect;

public class App {

	public static void main(String[] args) {
		int[] nums = {1,5,4,8,-2,9};
		Quickselect quickselect = new Quickselect(nums);
		System.out.println(quickselect.select(2));
	}
}
