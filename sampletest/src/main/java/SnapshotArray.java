import java.util.HashMap;
import java.util.Map;

class SnapshotArray {

	    private int[] array;
	    private Map<Integer, int[]> map;
	    private int snap_id;
	    
	    public SnapshotArray(int length) {
	        array = new int[length];
	        map = new HashMap<Integer, int[]>();
	    }
	    
	    public void set(int index, int val) {
	        array[index] = val;
	    }
	    
	    public int snap() {
	        map.put(1, array);
	        return snap_id;
	    }
	    
	    public int get(int index, int snap_id) {
	    	int[] value = map.get(snap_id);
	        return value[index];
	    }
	}