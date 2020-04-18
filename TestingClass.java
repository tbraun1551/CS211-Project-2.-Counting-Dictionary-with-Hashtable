import java.util.Vector;

public class TestingClass<V extends Comparable<V>> {

	public TestingClass() {}

	public static void main(String[] args) {
		Vector<Word> l = ReadFile.getList();

		CS211Heap<Word> JERMaxQueue = new CS211Heap<>(true);
		PriorityQueue<Word> maxQueue = new PriorityQueue<>(true);
		maxQueue.build(l);
		JERMaxQueue.build(l);
		System.out.println(JERMaxQueue.remove());
		System.out.println(maxQueue.remove());
		System.out.println(JERMaxQueue.remove());
		System.out.println(maxQueue.remove());
		System.out.println(JERMaxQueue.remove());
		System.out.println(maxQueue.remove());
		// prints the 10 most common words
		// System.out.println("The most common word is: " + maxQueue.remove());
		// System.out.println("The second most common word is: " + maxQueue.remove());
		// System.out.println("The third most common word is: " + maxQueue.remove());
		// System.out.println("The fourth most common word is: " + maxQueue.remove());
		// System.out.println("The fifth most common word is: " + maxQueue.remove());
		// System.out.println("The sixth most common word is: " + maxQueue.remove());
		// System.out.println("The seventh most common word is: " + maxQueue.remove());
		// System.out.println("The eight most common word is: " + maxQueue.remove());
		// System.out.println("The ninth most common word is: " + maxQueue.remove());
		// System.out.println("The tenth most common word is: " + maxQueue.remove());

		CS211Heap<Word> JERMinQueue = new CS211Heap<>(false);
		PriorityQueue<Word> minQueue = new PriorityQueue<>(false);
		minQueue.build(l);
		JERMinQueue.build(l);

		// System.out.println("The least common word is: " + minQueue.remove());
		// System.out.println("The second least common word is: " + minQueue.remove());
		// System.out.println("The third least common word is: " + minQueue.remove());
		// System.out.println("The fourth least common word is: " + minQueue.remove());
		// System.out.println("The fifth least common word is: " + minQueue.remove());
		// System.out.println("The sixth least common word is: " + minQueue.remove());
		// System.out.println("The seventh least common word is: " + minQueue.remove());
		// System.out.println("The eight least common word is: " + minQueue.remove());
		// System.out.println("The ninth least common word is: " + minQueue.remove());
		// System.out.println("The tenth least common word is: " + minQueue.remove());
	}
}