public class LinkedList<T> implements List<T>{
	private Node<T> head;
	private Node<T> current;
	private int count;

	public LinkedList () {
		head = current = null;
	}

	public boolean empty () {
		return head == null;
	}

	public boolean last () {
		return current.next == null;
	}
	public boolean full () {
		return false;
	}
	public void findfirst () {
		current = head;
	}
	public void findnext () {
		current = current.next;
	}
	public T retrieve () {
		return current.data;
	}
	public void update (T val) {
		current.data = val;
	}
	public void insert (T val) {
		Node<T> tmp;
		if (empty()) {
			current = head = new Node<T> (val);
			
		}
		else {
			tmp = current.next;
			current.next = new Node<T> (val);
			current = current.next;
			current.next = tmp;
			
		}
		count++;
	}

	public void remove () {
		if (current == head) {
			head = head.next;
		}
		else {
			Node<T> tmp = head;

			while (tmp.next != current)
				tmp = tmp.next;

			tmp.next = current.next;
		}

		if (current.next == null)
			current = head;
		else
			current = current.next;
		
		count--;
	}

		
	

	@Override
	public void findFirst() {
		current = head;
	}

	@Override
	public void findNext() {
		current = current.next;
		
	}

	

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return count;
	}

	@Override
	public boolean exists(T e) {
		Node<T> tmp = head;
		boolean b= false; 
		//findFirst();
		while(tmp!=null) {
			if(tmp.data.equals(e)) {
				//findFirst();
				b= true;
			}
			tmp = tmp.next;
			
		}
		//findFirst();
		
		
		return b;
	}

	
	
	
}