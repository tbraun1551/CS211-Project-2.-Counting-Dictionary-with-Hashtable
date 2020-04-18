import java.util.Comparator;

public class JERComp<V extends Comparable<V>> implements Comparator<V> {

	@Override
	public int compare(V o1, V o2) {
		return -1 * o1.compareTo(o2);
	}

}