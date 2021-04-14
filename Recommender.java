import java.io.File;
import java.util.Scanner;

public class Recommender {

	// Return the top k recommended friends for user i using the popular nodes method. If i does not exist, return null. In case of a tie, users with the lowest id are selected.
	public static <K extends Comparable<K>> PQK<Double, K> recommendPop(Graph<K> g, K i, int k) {
		PQK<Double, K> a = new PQKImp<>(k);
	//	List<K> ii = new LinkedList<>(); 
		
		try {
			if(g.isNode(i)) {
		List<K> c = new LinkedList<>();
		//ii = g.neighb(i);
		c = g.getNodes();
		if(!c.empty()&&c!=null) {
	//	System.out.println(c.size());
	//	ii.findFirst();
		c.findFirst();
		
		for(int j=0; j<c.size();j++) {
			//System.out.println(j);
		if(c.retrieve().compareTo(i)!=0&& !g.isEdge(i, c.retrieve())
				&&g.deg(c.retrieve())!=-1) {
			//System.out.println("ddd"+j);
			a.enqueue((double) g.deg(c.retrieve()), c.retrieve());
		}
			c.findNext();
		}
			}
		return a;
			}
			
		}catch(Exception e) {
			return null;
		}
			
			
			
		return null;
	}

	// Return the top k recommended friends for user i usin  g common neighbors method. If i does not exist, return null. In case of a tie, users with the lowest id are selected.
	public static <K extends Comparable<K>> PQK<Double, K> recommendCN(Graph<K> g, K i, int k) {
		PQK<Double, K> a = new PQKImp<>(k);
		double count ;
		try {
		if(g.isNode(i)) {
			List<K> c = new LinkedList<>();
			c =g.getNodes();
			if(!c.empty()) {
				c.findFirst();
				for (int j=0; j<c.size();j++) {
					if(c.retrieve().compareTo(i)!=0 && !g.isEdge(c.retrieve(), i)) {
						List<K> fi1 = new LinkedList<>();
						List<K> fi2 = new LinkedList<>();
						fi1 = g.neighb(c.retrieve());
						fi2 = g.neighb(i);
						 count =0;
						 if (fi1!=null &&fi2!= null&& !fi1.empty()&&!fi2.empty()) {
							 fi1.findFirst();
							 
						for(int v=0; v<fi1.size();v++) {
							if(fi2.exists(fi1.retrieve())) {
								count++;
							}
							fi1.findNext();
						}
						
					}
						 a.enqueue(count, c.retrieve());	
				}
				c.findNext();
				
			}
				//return a;
			}
			return a;
		}
		}catch(Exception e) {
			//System.out.println("a");
			return null;
		}
	    return null;	
		
		
	}

	// Read graph from file. The file is a text file where each line contains an edge. The end and start of the edge are separated by space(s) or tabs.
	public static Graph<Integer> read(String fileName) {

		try {
			Graph<Integer> g = new MGraph<Integer>();
			Scanner scanner = new Scanner(new File(fileName));
			while (scanner.hasNextInt()) {
				int i = scanner.nextInt();
				g.addNode(i);
				int j = scanner.nextInt();
				g.addNode(j);
				g.addEdge(i, j);
			}
			scanner.close();
			return g;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
