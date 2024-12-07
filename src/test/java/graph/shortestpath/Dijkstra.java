package graph.shortestpath;/*
    Classic Dijkstra with O(V**2) complexity
*/

class Dijkstra {

//public void dijkstra(int[][] graph) {
//    int V = graph.length;
//
//    // Captures distances to all vertices from source vertex which is 0
//    int[] distances = new int[V];
//
//    // Captures if a visited has been relaxed, a relaxed vertex is never visited
//    // in the algorithm
//    boolean[] visited = new boolean[V];
//
//    for(int i=0; i<V; i++) {
//	    distances[i] = Integer.MAX_VALUE;
//    }
//
//    // Distance of source to source is 0, duh....
//    distances[0] = 0;
//
//    for(int i=0; v<V-1; v++) {
//	    int u = minDistance(distances, visited);
//
//	    // Mark this node as visited
//	    visited[next] = true;
//
//	    //Traverse all the deges from u to v
//	    for(int v=0; v<V; v++) {
//		 if(
//		    !visited[v] &&
//		    distance[u] != Integer.MAX_VALUE &&
//		    graph[u][v] != 0 &&
//	            distance[v] > graph[u][v] + distance[u]
//		   ) {
//			// Since v is not visited and its value is < Integer.MAX_VALUE,
//			// we update the weight to the minimum weight found till now
//			distance[v] = graph[u][v] + distance[u];
//		   }
//	    }
//
//    }
//
//}
//
///*
// * @return - next, from all the vertices finds the vertex with the minimum distance
// * from source which is not visited yet
// * */
//private int minDistance(int[] distances, boolean[] visited) {
//	int minValue = Integer.MAX_VALUE, next = -1;
//	for(int v=0; v<distances.length; v++) {
//		if(visited[v]
//			&& distances[v] >= minValue) {
//			continue;
//		}
//		next = v;
//		minValue = distances[v];
//	}
//
//	// During the first call this should return '0' since we are setting its
//	// distance to 0, its almost like we are putting it in a queue.
//	return next;
//}
//
//// Priority Queue based implementation of SPF Dijkstra
//
//
//	static class Path {
//		public final int u, v, weight;
//
//		Path(int u, int v, int weight) {
//			this.u = u;
//			this.v = v;
//			this.weight = weight;
//		}
//	}
//
//
//	/**
//	 * This implementation uses Priority Queue to maintain edges from u->v,
//	 * source is assumed to be vertex 0
//	 * */
//	public void optimisedDijkstra(int[][] graph) {
//		final PrirorityQueue<Path> paths  = new PriorityQueue<>();
//		final int[] distances = new int[graph.length];
//
//		Arrays.fill(distances, Integer.MAX_VALUE);
//
//		paths.add(new Path(0, 0, 0));
//	}

}
