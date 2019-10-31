package HashMapChaining;

public class HashTable {

	private HashItem[] hashTable;
	
	public HashTable() {
		hashTable = new HashItem[Constants.TABLE_SIZE];
	}
	public int get(int key) {
		int hashIndex = hash(key);
		
		if(hashTable[hashIndex] == null) {
			return -1;
		} else {
			HashItem hashItem = hashTable[hashIndex];
			
			while(hashItem != null && hashItem.getKey() != key) {
				hashItem = hashItem.getNextHashItem();
			}
			
			if (hashItem == null) {
				return -1;
			} else {
				return hashItem.getValue();
			}
			
		}
	}
	
	public void put(int key, int value) {
		int hashIndex = hash(key);
		
		if (hashTable[hashIndex] == null) {
			System.out.println("No collision simple insertion ...");
			hashTable[hashIndex] = new HashItem(key, value);
		} else {
			System.out.println("collision while inserting the key: "+ key);
			HashItem hashItem = hashTable[hashIndex];
			while(hashItem.getNextHashItem() != null)
				hashItem = hashItem.getNextHashItem();
			System.out.println("Finally we found the place to insert....");
			hashItem.setNextHashItem(new HashItem(key, value));
		}
	}
	
	private int hash(int key) {
		return key % Constants.TABLE_SIZE;
	}
}
