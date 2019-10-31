package CallCenterDesignPattern;

abstract class Employee {
	private Call currentCall = null;
	protected Rank rank;
	
	public Employee() {}
	
	public void receiveCall(Call call) {}
	
	public void callCompleted() {}
	
	public void escalateAndRessign() {}
	
	public boolean assignNewCall() {}
	
	public boolean isFree() {return currentCall = null;}
	
	public Rank getRank() {return rank;}
}
