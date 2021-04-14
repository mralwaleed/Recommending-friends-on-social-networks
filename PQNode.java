
public class PQNode<P,T> {
	public T data;
	public P priority;
	public PQNode<P,T> next;
	
	public PQNode() {
		next = null;
	}
	
	public PQNode(P s, T e) {
		data = e;
		priority = s;
	}

	

}
