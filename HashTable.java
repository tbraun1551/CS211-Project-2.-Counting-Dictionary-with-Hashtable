import java.util.*;
//https://stackoverflow.com/questions/27654229/how-to-properly-define-an-array-of-linked-list-in-java/27654289

public class HashTable<V extends Comparable<V>> implements CS211CountingDictionaryInterface {
	// private Word[] htable = new Word[100000];
	private LinkedList hashTable[] = new LinkedList[100000];// Creates an Array of LinkedLists to act as table
	private int len = hashTable.length;

	public HashTable() {
		for (int i = 0; i < hashTable.length; i++) {
			hashTable[i] = new LinkedList<Word>();// Puts an empty linked list in each spot in the array
		}
		// this.htable = new LinkedList<Word>[100000]; // Creates the vector in which
		// the tree is stored.
	}

	public void insert(String key) {
		int loc = Math.abs(key.hashCode() % len);
		Word w = new Word(key, 1);
		Boolean inserted = false;

		if (hashTable[loc].isEmpty()) { // If the linked list is empty, first reference to location
			hashTable[loc].add(w);// Adds the element to the LinkedList starting it
			inserted = true;
			// System.out.println("Added " + w.revealTheString() + " to the dict and the count was: " + w.revealTheCount());
		} else { // Means a LinkedList has already been made
			for (int i = 0; i < hashTable[loc].size(); i++) { // Iterates through linkedlist at that location
				Word x = (Word) hashTable[loc].get(i);// Grabs object at that location and typecasts to Word
				String a = x.revealTheString();

				if (a.equals(key)) {
					x.incrementTheCount();// Increments the count of the word
					hashTable[loc].set(i, x);// Inserts word with new count into its old location
					inserted = true; // Once it finds the Word it increments it and leaves
					// System.out.println("Added " + x.revealTheString() + " to the dict and the count was: " + x.revealTheCount());
				}
			}
			if (!inserted) {// Only triggered if word not present in the LinkedList
				hashTable[loc].add(w);// If it gets to this point it means it is not already in the dictionary
				// System.out.println("Added " + w.revealTheString() + " to the dict and the count was: " + w.revealTheCount());
			}
		}
	} // insert(string key);

	// Deletes the value at the given key and returns true or false
	// To delete a value it just sets the contents of the given location as null
	public boolean delete(String key) {
		boolean deleted = false;
		int loc = Math.abs(key.hashCode() % len);
		if(!hashTable[loc].isEmpty()) { //Returns false if not in dictionary
			for(int i = 0; i < hashTable[loc].size(); i++) {
				Word a = (Word)hashTable[loc].get(i);
				if(key.equals(a.revealTheString())) { //This is what we want to delete
					hashTable[loc].remove(i);//Deleted the element at that position
					deleted = true;
				}
			}
		}
		return deleted;
	}// delete(String key);

	// Returns the value associated with a key. Returns -1 if it is not present in
	// the table
	public int find(String key) {
		int loc = Math.abs(key.hashCode() % len);
		int keyValue = -1;
		LinkedList keyList = hashTable[loc];
		for (int i = 0; i < keyList.size(); i++) {
			Word x = (Word) keyList.get(i);
			if (key.equals(x.revealTheString())) {
				keyValue = x.revealTheCount();
			}
		}
		return keyValue;
	}// find(String key);

	public Vector<Word> allKeyValue() {
		Vector<Word> vectorized = new Vector<Word>();
		for (int i = 0; i < len; i++) { // Goes through every spot in the array
			if (!hashTable[i].isEmpty()) { // Only goes through spots that arent empty
				for (int j = 0; j < hashTable[i].size(); i++) {
					Word e = (Word) hashTable[i].get(j); //Grabs every word in slot
					vectorized.add(e);//adds the word to the vector
				}
			}
		}
		return vectorized;
	} // allKeyValue();
}