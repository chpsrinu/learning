package CallCenterDesignPattern;

import java.util.List;

import jdk.nashorn.internal.codegen.CompilerConstants.Call;

public class CallHandler {

	private static CallHandler instance;
	
	private final int LEVELS = 3;
	
	private final int NUM_RESPONDENTS = 10;
	private final int NUM_MANAGERS = 4;
	private final int NUM_DIRECTORS = 2;
	
	List<List<Employee>> employeLevels;
	
	List<List<Call>> callQueues;
	
	protected CallHandler() {}
	
	public static CallHandler getInstance() {
		if (instance == null) {
			instance = new CallHandler();
		}
		return instance;
	}
	
	public Employee getHandlerForCall(Call call) {}
	
	public void dispatchCall(Caller caller) {
		Call call = new Call(caller);
		dispatchCall(call);
	}
	
	public void dispatchCall(Call call) {
		Employee emp = getHandlerForCall(call);
		if (emp != null) {
			emp.receiveCall(call);
			call.setHandler(emp);
		} else {
			call.replay("Please wait for free employee to replay");
			callQueues.get(call.getRank().getValue()).add(call);
		}
	}
	
	pubic boolean assignCall(Employee emp) {}
}
