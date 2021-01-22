package learning;

public class GasStation {

//	public static int canCompleteCircuit(int[] gas, int[] cost) {
//		int sumGas = 0;
//		int sumCost = 0;
//		int start = 0;
//		int tank =0;
//		for (int i=0;i<gas.length;i++) {
//			sumGas += gas[i];
//			sumCost += cost[i];
//			tank += gas[i]-cost[i];
//			if(tank<0){
//				start = i+1;
//				tank=0;
//			}
//		}
//		if(sumGas>sumCost)
//			return -1;
//		else
//			return start;
//	}
	
	public static int canCompleteCircuit2(int[] gas, int[] cost) {
        int start = 0,total = 0,tank = 0;

        //if car fails at 'start', record the next station
        for(int i = 0; i < gas.length; i++) {
            tank += gas[i] - cost[i];
            if (tank < 0) {
                start = i + 1; //move starting position forward
                total += tank; //add the negative tank value to total
                tank = 0; //reset tank
            }
        }
        //negative total + positive tank should be 0 or more, if so we can do a round trip and return start
        return (total+tank < 0)? -1: start;
    }
	
	public static void main(String[] args) {
		int[] gas = {1,2,3,5,4};
		int[] cost = {3,4,5,2,1};
		System.out.println(canCompleteCircuit2(gas, cost));
		
		int[] gas1 = {3,3,4};
		int[] cost1 = {3,4,4};
		System.out.println(canCompleteCircuit2(gas1, cost1));
	}
}
