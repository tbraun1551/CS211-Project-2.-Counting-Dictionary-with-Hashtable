import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Vector;

public class CS211Heap<V extends Comparable<V>> implements CS211PriorityQueueInterface<V> {

	public PriorityQueue<V> pq;

	public CS211Heap(boolean foo) { // foo = false for min queue, true for max

		Comparator<? super V> comp = (Comparator<? super V>) new JERComp<V>();

		if (foo) pq = new PriorityQueue<V>();
		else pq = new PriorityQueue<V>(comp);
	}

	@Override
	public void insert(V w) {
		pq.add(w);

	}

	@Override
	public V peek() {
		return pq.peek();
	}

	@Override
	public V remove() {
		return pq.remove();
	}

	@Override
	public void build(Vector<V> words) {
		pq.addAll(words);
	}

	@Override
	public boolean isEmpty() {
		return pq.isEmpty();
	}

}