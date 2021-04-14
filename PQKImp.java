public class PQKImp<P extends Comparable<P>, T> implements PQK<P, T> {

	private int size;
	private PQNode<P, T> head, Tail;

	// private P length ;
	private int k;

	public PQKImp(int k) {
		head = Tail = null;
		this.k = k;
		size = 0;
	}

	@Override
	public int length() {

		return size;
	}

	@Override

	public void enqueue(P pr, T e) {

		PQNode<P, T> tmp = new PQNode<P, T>(pr, e);
         try {
		if (k > size) {
			// System.out.println("tt");

			if ((size == 0 || head.priority.compareTo(pr) <= 0)) {

				if (size != 0 && head.priority.compareTo(pr) == 0) {
					PQNode<P, T> p = head, s = null;
					while ((p != null) && (p.priority.compareTo(pr) >= 0)) {
						s = p;
						p = p.next;
					}
				//	System.out.println("d");
					tmp.next = p;
					s.next = tmp;

				} else {
					tmp.next = head;
					head = tmp;
				}

			}

			else {
				PQNode<P, T> p = head;
				PQNode<P, T> q = null;
				while ((p != null) && (p.priority.compareTo(pr) >= 0)) {
					q = p;
					p = p.next;
				}
				tmp.next = p;
				q.next = tmp;
				// System.out.println(tmp.next.data);

			}

			size++;
		} else {
			PQNode<P, T> p = head, q = null;
			while (p.next != null) {
				q = p;
				// System.out.println("t");
				p = p.next;
			}
			if (p.priority.compareTo(pr) < 0) {
				q.next = null;
				size--;
				enqueue(pr, e);
			}
		}
         }catch(Exception f) {
        	 
         }

	}

	// C:\\Users\\alwaleed\\Desktop\\data stracer\\PA4main\\PA4\\src\\g.txt

	@Override
	public Pair<P, T> serve() {
		try {
		if (size > 0) {
			PQNode<P, T> node = head;
			Pair<P, T> pd = new Pair<P, T>(node.priority, node.data);
			head = head.next;
			size--;
			return pd;
		} else {
			return null;
		}

		}catch(Exception f) {
			return null;
	
	}
	}

}
