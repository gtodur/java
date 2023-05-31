package practice.hashtable;

public class TestHashTable {

	public static void main(String[] args) throws Exception {
		HashTableImpl ht = new HashTableImpl();
		ht.put(105, "Tom");
		ht.put(21, "Sana");
		ht.put(21, "Harry");
		ht.put(31, "Kate");
		System.out.println("Table size : " + ht.getSize());
		
		System.out.println(ht.get(31));
		
		System.out.println("Value removed : " + ht.get(21));
	}

}
