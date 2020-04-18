import java.util.Vector;

public class PriorityQueue<V extends Comparable<V>> implements CS211PriorityQueueInterface<V> {
	
	private Vector<V> pQueue;
	public boolean isMax;
	
	public PriorityQueue(boolean isMax) {
		this.pQueue = new Vector<V>(); //Creates a  priority heap
		this.isMax = isMax; //Set to true if it is a max heap and false if it is a min heap
	}

	public void insert(V w) {
		if(this.pQueue.isEmpty()) {
			this.pQueue.add(null);
			this.pQueue.add(w);
		} else {
			this.pQueue.add(w);
		}
		this.upBubbler(this.pQueue.size() - 1);
	}
	
	public V peek() {
		return this.pQueue.get(1);
	}
	
	public V remove() {
		V maxV = this.pQueue.get(1);
		this.pQueue.set(1, this.pQueue.get(this.pQueue.size() - 1));
		this.pQueue.remove(this.pQueue.size() - 1);
		downBubbler(1);
		return maxV;
	}
	
	public void build(Vector<V> words) {
		this.pQueue.clear(); //This erases the queue and makes it start over from zero
		int count = 0;
		for(V w: words) {
			this.insert(w);
			count++;
			//System.out.println("inserted:" + w);
		}
		// System.out.println("Inserted: " + count + " words into the Priority Queue.");
	}
	
	public boolean isEmpty() {
		return this.pQueue.isEmpty();
	}

	public boolean compar(V p, V c) {
		if(p != null && c != null) {  //make sure they both exist
			if(isMax) { //means that it is a max heap
				if(p.compareTo(c) < 0) {
					return true;
				} else {
					return false;
				}
			} else {  //Means it is a minHeap
				if(p.compareTo(c) > 0) {
					return true;
				} else {
					return false;
				}
			}
		}
		return false; //Shouldnt effect the program just so it compiles
	}

	public void upBubbler(int x) {
		V parent = this.pQueue.get(x/2);
		V child = this.pQueue.get(x);
		if(compar(parent, child)) {
			V temp = this.pQueue.get(x);
			this.pQueue.set(x, parent);
			this.pQueue.set(x/2, temp);
			upBubbler(x/2);
		}
	}

	public void downBubbler(int n) {
		int doubleN = n * 2;
		if(doubleN >= this.pQueue.size() || doubleN + 1 >= this.pQueue.size()) {
			if(doubleN < this.pQueue.size()) {
				V left = this.pQueue.get(doubleN);
				V parent = this.pQueue.get(n);
				if(compar(parent, left)) { //Parent is smaller than the left child
					V temp = this.pQueue.get(doubleN);
					this.pQueue.set(doubleN, parent);
					this.pQueue.set(n, temp);
					downBubbler(doubleN);
				}
			}
			return;
		}
		V left = this.pQueue.get(doubleN);
		V right = this.pQueue.get(doubleN + 1);
		V parent = this.pQueue.get(n);

		if(!compar(left, right)) { //Means that compar found that the left was bigger than the right child
			if(compar(parent, left)) { //Parent is smaller than the left child
				V temp = this.pQueue.get(doubleN);
				this.pQueue.set(doubleN, parent);
				this.pQueue.set(n, temp);
				downBubbler(doubleN);
			}
		} else {
			if(compar(parent, right)) { //Meants that compar found that the parent is smaller than the right child
				V temp = this.pQueue.get(doubleN + 1);
				this.pQueue.set(doubleN + 1, parent);
				this.pQueue.set(n, temp);
				downBubbler(doubleN + 1);
			}
		}
	}

	
}