package GenericHashTable;

@SuppressWarnings("unchecked")
public class HashTable<Key, Value> {

	private Key[] keys;
	private Value[] values;
	private int numOfItems;
	private int capacity; //size of the table and capacity > numOfItems
	
	public HashTable() {
		this.keys = (Key[]) new Object[Constants.TABLE_SIZE];
		this.values = (Value[]) new Object[Constants.TABLE_SIZE];
		this.capacity = Constants.TABLE_SIZE;
		this.numOfItems = 0;
	}
	
	public HashTable(int newCapacity) {
		this.keys = (Key[]) new Object[newCapacity];
		this.values = (Value[]) new Object[newCapacity];
		this.capacity = newCapacity;
		this.numOfItems = 0;
	}
	
	public int size() {
		return this.numOfItems;
	}
	
	public boolean isEmpty() {
		return numOfItems <= 0;
	}
	
	private void resize(int newCapacity) {
		HashTable<Key, Value> newTable = new HashTable<>(newCapacity);
		
		for(int i=0;i<capacity;i++) {
			if(keys[i] != null) {
				newTable.put(keys[i], values[i]);
			}
		}
		
		keys = newTable.getKeys();
		values = newTable.getValues();
		capacity = newTable.getCapacity();
	}
	
	public void remove(Key key) {
		if (key == null) return;
		
		int hashIndex = hash(key);
		while(!keys[hashIndex].equals(key)) {
			hashIndex = (hashIndex+1) % capacity;
		}
		keys[hashIndex] = null;
		values[hashIndex] = null;
		numOfItems--;
		
		while (keys[hashIndex] != null) {
			Key tempKey = keys[hashIndex];
			Value tempValue = values[hashIndex];
			
			numOfItems--;
			keys[hashIndex] = null;
			values[hashIndex] = null;
			put(tempKey, tempValue);
			
			hashIndex = (hashIndex+1) % capacity;
		}
		
		if (numOfItems <= capacity/3) {
			resize(capacity/2);
		}
		
	}
	
	public void put(Key key, Value value) {
		if (key == null || value == null) return ;
		
		if(numOfItems>=capacity * 0.75) {
			resize(2*capacity);
		}
		int hashIndex = hash(key);
		
		while(keys[hashIndex] != null) {
			if(keys[hashIndex].equals(key)) {
				values[hashIndex] = value;
				return;
			}
			hashIndex = hashIndex+1 % capacity;
		}
		keys[hashIndex] = key;
		values[hashIndex] = value;
		numOfItems++;
	}
	
	public Value get(Key key) {
		if(key == null) 
			return null;

		int hashIndex = hash(key);
		
		while(keys[hashIndex] != null) {
			if(keys[hashIndex].equals(key))
				return values[hashIndex];
			hashIndex = (hashIndex+1) % Constants.TABLE_SIZE;
		}
		return null;
	}
	
	private int hash(Key key) {
		return Math.abs(key.hashCode()) % Constants.TABLE_SIZE;
	}

	public Key[] getKeys() {
		return keys;
	}

	public void setKeys(Key[] keys) {
		this.keys = keys;
	}

	public Value[] getValues() {
		return values;
	}

	public void setValues(Value[] values) {
		this.values = values;
	}

	public int getNumOfItems() {
		return numOfItems;
	}

	public void setNumOfItems(int numOfItems) {
		this.numOfItems = numOfItems;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	
	
	
}
