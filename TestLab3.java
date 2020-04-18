import java.util.*;

public class TestLab3<V extends Comparable<V>> {
	public static void main(String[] args) {
		CS211CountingDictionaryInterface dictionary = new HashTable<Word>();
		dictionary = ReadFile.addFileToDict(dictionary); //Adds all the words to counting dictionary
		// System.out.println(dictionary);
		// System.out.println(dictionary.find("to"));
		// System.out.println(dictionary.find("and"));
		// System.out.println(dictionary.find("Non-existent"));

		Vector<Word> dic = dictionary.allKeyValue();//Turns all the words in the CountingDictionary into a vector
		// dic.forEach((e) -> System.out.println(e));

		CS211Heap<Word> JERMaxQueue = new CS211Heap<>(false);
		PriorityQueue<Word> maxQueue = new PriorityQueue<>(true);
		maxQueue.build(dic);
		JERMaxQueue.build(dic);
		//System.out.println("The ten most common words in the file are:");
		for(int i = 0; i <= 10; i++) {
			// System.out.println("JER Max: " + i + ": " + JERMaxQueue.remove());
			//System.out.println(maxQueue.remove());
		}
		System.out.println();
		CS211Heap<Word> JERMinQueue = new CS211Heap<>(true);
		PriorityQueue<Word> minQueue = new PriorityQueue<>(false);
		minQueue.build(dic);
		JERMinQueue.build(dic);
		//System.out.println("The ten least common words in the file are:");
		for(int i = 0; i <= 10; i++) {
			//System.out.println("JER Min: " + i + ": " + JERMaxQueue.remove());
			//System.out.println(minQueue.remove());
		}

		///////////////////////////////////////////////////////////////////////////////////////////////////
		//Part 4 with commmonWords filter
		CS211CountingDictionaryInterface dict = new HashTable<Word>();
		CS211CountingDictionaryInterface commonWords = new HashTable<Word>();
		dictionary = ReadFile.addFileToDict(dict, commonWords); //Adds all the words to counting dictionary

		Vector<Word> secondVectorized = dict.allKeyValue();
		//secondVectorized.forEach(w -> System.out.println(w.revealTheString() + ": occurs " + w.revealTheCount() + " times."));

		PriorityQueue<Word> commonMaxQueue = new PriorityQueue<>(true);
		commonMaxQueue.build(secondVectorized);
		System.out.println("The ten most used uncommon words are:");
		for(int i = 0; i <= 10; i++) {
			System.out.println(commonMaxQueue.remove());
		}


	}//main(String[] args);
}