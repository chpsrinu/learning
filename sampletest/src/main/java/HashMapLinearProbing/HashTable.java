package HashMapLinearProbing;

public class HashTable {
	HashItem[] hashTable;
	
	public HashTable() {
		hashTable = new HashItem[Constants.TABLE_SIZE];
	}
	
	public void put(int key, int value) {
		int hashIndex = hash(key);
		System.out.println("put method called with value :"+ value + "- hashIndex :"+hashIndex);
		while(hashTable[hashIndex] != null) {
			hashIndex = (hashIndex+1) % Constants.TABLE_SIZE;
			System.out.println("Collision next index : "+ hashIndex);
		}
		System.out.println("Inserted finally on the index :"+hashIndex);
		hashTable[hashIndex] = new HashItem(key, value);
		
	}
	
	public int get(int key) {
		int hashIndex = hash(key);
		
		while(hashTable[hashIndex] != null && hashTable[hashIndex].getKey() != key ) {
			hashIndex = (hashIndex+1)%Constants.TABLE_SIZE;
			System.out.println("Hoping to find next index :" + hashIndex);
		}
		
		if(hashTable[hashIndex] == null) {
			return -1;
		} else {
			return hashTable[hashIndex].getValue();
		}
		
		
	}
	
	public int hash(int key) {
		return key%Constants.TABLE_SIZE;
	}

}
