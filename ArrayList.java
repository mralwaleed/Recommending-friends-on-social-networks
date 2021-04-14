
public class ArrayList<T> implements List<T>{
	private int maxsize;
	private int size;
	private int current;
	private T[] nodes;

	/** Creates a new instance of ArrayList */
	public ArrayList(int n) {
		maxsize = n;
		size = 0;
		current = -1;
		nodes =  (T[]) new Object[n];
		
	}

	public boolean full() {
		return size == maxsize;
	}

	public boolean empty() {
		return size == 0;
	}

	public boolean last() {
		return current == size - 1;
	}

	public void findFirst() {
		current = 0;
	}

	public void findNext() {
		current++;
	}

	public T retrieve() {
		return nodes[current];
	}

	public void update(T val) {
		nodes[current] = val;
	}

	public void insert(T val) {
		for (int i = size - 1; i > current; --i) {
			nodes[i + 1] = nodes[i];
		}
		current++;
		nodes[current] = val;
		size++;
	}

	public void remove() {
		for (int i = current + 1; i < size; i++) {
			nodes[i - 1] = nodes[i];
		}
		size--;
		if (size == 0)
			current = -1;
		else if (current == size)
			current = 0;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return maxsize;
	}

	@Override
	public boolean exists(T e) {
		// TODO Auto-generated method stub
		return false;
	}


}
