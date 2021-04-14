public class MGraph<K extends Comparable<K>> implements Graph<K> {
	public Map<K, List<K>> adj; // Do not change this
	 
	public MGraph() {
	  adj = new BSTMap<K, List<K>>(); 
	}
	@Override
	public boolean addNode(K i) {
		try {
	//	List<K> c = new LinkedList<>(); 
		// TODO Auto-generated method stub
		if(!adj.retrieve(i).first) {
			adj.insert(i,  new LinkedList<>());
			return true;
		}else {
		return false;}
		}catch( Exception d) {
			return false;
		}
	}
	@Override
	public boolean isNode(K i) {
		// TODO Auto-generated method stub
		try {
		return adj.retrieve(i).first;
		}catch(Exception e) {
			return false;
		}
	}
	@Override
	public boolean addEdge(K i, K j) {
		try {
		// TODO Auto-generated method stub
		if(isNode(i)&&isNode(j)) {
		     //System.out.println(adj.retrieve(i).second.exists(j));
			if(!(adj.retrieve(i).second.exists(j)&&adj.retrieve(j).second.exists(i))) {
			adj.retrieve(i).second.insert(j);
			adj.retrieve(j).second.insert(i);
			return true ;}
		}
		
		return false;
		}catch(Exception e) {
			return false;
		}
	}
	@Override
	public boolean isEdge(K i, K j) {
		try {
			
			return	adj.retrieve(i).first != false && adj.retrieve(i).second.exists(j)
	                && adj.retrieve(j).first != false && adj.retrieve(j).second.exists(i);
			
		// TODO Auto-generated method stub
		/*if(isNode(i)&&isNode(j)) {		
			if(adj.retrieve(i).second.exists(j)&&adj.retrieve(j).second.exists(i)) {
				return true ;
			}
		}
		return false;*/
		}catch(Exception e) {
			return false;	
		}
	}
	@Override
	public List<K> neighb(K i) {
		List<K> a = null;
		try {
		 
		if(adj.retrieve(i).first){
			a = adj.retrieve(i).second;
		return a;
		}
		return a;
		}catch (Exception e) {
			return a ;
		}
	}
	@Override
	public int deg(K i) {
		try {
		// TODO Auto-generated method stu
		if(isNode(i)) {
			return adj.retrieve(i).second.size();
		}
		return -1;
		}catch(Exception e) {
			return -1;
		}
	}
	@Override
	public List<K> getNodes() {
		try {
		
		return adj.getKeys();
		
		}catch(Exception e) {
			return null ;
		}
	}
	
}
