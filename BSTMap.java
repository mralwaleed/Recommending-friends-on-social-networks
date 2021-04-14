public class BSTMap<K extends Comparable<K>, T> implements Map<K, T> {
	public BSTNode<K, T> root; // Do not change this
	private int count;
	 Boolean removed = false  ;
	
	public BSTMap() {
		  int zero=0;
		root =null ;
		count=zero;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return count;
	}

	@Override
	public boolean full() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
	root = null ;
	count =0;
		
	}

	@Override
	public boolean update(K k, T e) {
		
         try {	
		BSTNode<K, T> n = new BSTNode<K, T>(k,e);
		//	Integer a = new Integer((int) k);
			//System.out.println(k);
			BSTNode<K, T> crunt = root , q = null;
			if (root ==null) {
			
				return false;
			}else {
				//BSTNode<K, T> c = search();
			while(crunt != null) {
			    q = crunt ; 
			   if(crunt.key.compareTo(k)==0){
				//   System.out.println("ff");
				   crunt.data=n.data;
				   return true;
			    }
				if(crunt.key.compareTo(k)==1) {
					crunt = crunt.left;
				//	System.out.println("ll"); 
					
				}else {
				if(crunt.key.compareTo(k)==-1) {
					crunt = crunt.right;
				//	System.out.println("rr");
				}
				}
			}
			/*if(q==null) {
				return false;
			} else if (q.key.compareTo(k)==1)  {
		    	System.out.println("l");
		        q.left.data = n.data;
		      }
	
		    else {
		    	System.out.println("r");
		    	   q.right.data = n.data; 
		    	  
		    }*/
				
		
			
			}
		
		
		return false;
         }catch( Exception fr) {
        	 return false;
         }
	}

	@Override
	public Pair<Boolean, T> retrieve(K k) {
		Pair<Boolean, T> a = new Pair<Boolean, T>(false , null);;
		try {
		if (root ==null) {
			return 	a ;
		}
		BSTNode<K, T> crunt = root ;
		// Pair<Boolean, T> a =null;
		 
			while(crunt!= null) {
			 //   q = crunt ; 
			 
			    if (crunt.key.compareTo(k)==0) {
			    	a.first=true;
			    	a.second = crunt.data;
			    	break;
			    }
				if(crunt.key.compareTo(k)==1) {
					crunt = crunt.left;
					//System.out.println("ll");
				}else {
				if(crunt.key.compareTo(k)==-1 ) {
					crunt = crunt.right;
				//	System.out.println("rr");
				}
				}
			}
			//a = new Pair<Boolean, T>(false , null);
			return a;
		
		}catch(Exception e) {
			 return null;
		}
		
		
	}
	
	
	@Override
	public boolean insert(K k, T e) {
		try {
		BSTNode<K, T> n = new BSTNode<K, T>(k,e);
	//	Integer a = new Integer((int) k);
		//System.out.println(k);
		BSTNode<K, T> crunt = root , q = null;
		if (root ==null) {
		//	System.out.println("root");
			root = n;
			count++;
			return true;
			
		}else {
			//BSTNode<K, T> c = search();
		while(crunt != null) {
		    q = crunt ; 
		   if(crunt.key.compareTo(k)==0){
			//   System.out.println("ff");
			   return false;
		    }
			if(crunt.key.compareTo(k)==1) {
				crunt = crunt.left;
			//	System.out.println("ll"); 
				
			}else {
			if(crunt.key.compareTo(k)==-1) {
				crunt = crunt.right;
			//	System.out.println("rr");
			}
			}
		}
	
		 if (q != null){
		         
		     if (q.key.compareTo(k)==1)  {
		        q.left = n;
		        }
		    else {
		    	   q.right = n; 
		    	   
		    }
		     count+=1;
		 }   
		
		
		
		return true;
		
	
		}
		
		
		}catch(Exception fe) {
			return false;
		}
		
		// TODO Auto-generated method stub
	//	return false;
	}

	@Override
	public boolean remove(K k) {
		
	/*//	int k1 = k;    
	//	BSTNode<K,T> q = root, current;  
		//BSTNode<K,T> p = null; // Parent of p  
	    //  int k1 = k;
	      BSTNode<K,T> p = root , q=null ,current;
	    //  BSTNode<T> q = null; // Parent of p
	      while (p != null) {

	         if (p.key.compareTo(k)==1) {
	            q =p;
	            p = p.left;
	         } else if (p.key.compareTo(k)==-1) {
	            q = p;
	            p = p.right;
	         }
	         else { // Found the key
	             // Check the three cases
	             if ((p.left != null) && (p.right != null)) { 
	 		// Case 3: two children
	                // Search for the min in the right subtree
	                BSTNode<K,T> min = p.right;
	                q = p;
	                while (min.left != null) {
	                   q = min;
	                   min = min.left;
	                }
	                p.key = min.key;
	                p.data = min.data;
	                k = min.key;
	                p = min;
	                // Now fall back to either case 1 or 2
	             }
                if (q == null) { // No parent for p, root must change
	                root = p;
	             } else {
	                if (q.key.compareTo(k)==1) {
	                   q.left = p;
	                } if(q.key.compareTo(k)==-1) {
	                   q.right = p;
	                }
	             }
	             current = root;
	             return true;

	          } 
	       }

	       return false; // Not found
	    }
	 



		*/
		
		
		
		
		
		
		
		
		try {
		BSTNode<K,T> p ,current;
		p = remove_aux(k, root, removed);
		current = root = p;
		return removed;
		}catch(Exception e) {
		return false;}
              }
	
	private BSTNode<K,T> remove_aux(K k, BSTNode<K,T> p, Boolean flag) {
		BSTNode<K,T> q, child = null;
		if(p == null)
			return null;
		if(p.key.compareTo(k)==1)
			p.left = remove_aux(k, p.left, flag); //go left
		else if(p.key.compareTo(k)==-1)
			p.right = remove_aux(k, p.right, flag); //go right
		else {
			this.removed =true;
			if (p.left != null && p.right != null){ //two children
				q = find_min(p.right);
				p.key = q.key;
				p.data = q.data;
				p.right = remove_aux(q.key, p.right, flag);
			}
			else {
				if (p.right == null) //one child
					child = p.left;
				else if (p.left == null) //one child
					child = p.right;
				return child;
			}
		}
		return p;

	}
	private BSTNode<K,T> find_min(BSTNode<K,T> p){
		if(p == null)
			return null;
		
		while(p.left != null){
			p = p.left;
		}
		
		return p;
	}
	
	


      private void getKeys(BSTNode<K, T> node ,List<K> a) {
      if (node == null) {
      return;
        }else {
     // List<K> a =  new ArrayList<>(count) ;
        	getKeys(node.left , a);
   a.insert(node.key);
    getKeys(node.right , a);
        }
          }

        public  List<K>  getKeys() {
        	try {
        List<K> a =  new  LinkedList<>() ;
        getKeys(root ,a);
    return a ;
         }
        	catch(Exception ew) {
        		return null;
            }
        }


}
