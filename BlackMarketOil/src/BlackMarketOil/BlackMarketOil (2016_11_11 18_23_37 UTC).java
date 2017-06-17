package BlackMarketOil;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BlackMarketOil{
	private int[] parent; 
	private Queue<Integer> queue;
	private int numV; //number of vertices 
	private boolean[] visited;
	
	public BlackMarketOil(int numV){
		this.numV= numV;
		this.queue= new LinkedList<Integer>();
		parent = new int[numV+1];
		visited = new boolean[numV+1];
	}
	public boolean bfs (int source, int goal, int[][] graph){
		boolean pathFound = false; 
		int destination, element;
		for(int vertex = 1; vertex <= numV; vertex++){//initialize each vertex to 
			parent[vertex]= -1;						//have no parent in array and not visited
			visited[vertex]= false;
		}
		queue.add(source);
		parent[source]= -1;//source has no prior vertex
		visited[source]= true;
		
		while(!queue.isEmpty()){
			element = queue.remove();
			destination = 1;
			while(destination <= numV){
				if(graph[element][destination]> 0 && !visited[destination]){
					parent[destination]= element; 
					queue.add(destination);
					visited[destination]= true;
				}
				destination++; 
			}
		}
		if(visited[goal]){
			pathFound= true;
		}
		return pathFound;
	}
	public int networkFlow(int graph[][], int source, int destination){
		int u, v;//regualr vetexes used for oil pipes(edges) 
		int maxFlow = 0; 
		int pathFlow;
		int[][] residualGraph = new int[numV+1][numV+1];
		for(int srcV= 1; srcV <= numV; srcV++){// make redidual graph match actual graph
			for(int destV = 1; destV <= numV; destV++){// before flow begin
				residualGraph[srcV][destV]= graph[srcV][destV];
			}
		}
		//max flow 
		while(bfs(source, destination, residualGraph)){ //here 2
			pathFlow= Integer.MAX_VALUE;
			for(v= destination; v != source; v= parent[v]){
				u= parent[v];
				pathFlow = Math.min(pathFlow, residualGraph[u][v]);
			}
			for(v= destination; v != source; v= parent[v]){
				u= parent[v];
				residualGraph[u][v] -= pathFlow;
				residualGraph[v][u] += pathFlow;
			}
			maxFlow += pathFlow;
		}
		return maxFlow;
	}
	public static void main(String...arg){
		int[][] graph;
		int numN;
		int source;
		int sink;
		int maxFlow;
		Scanner in = new Scanner(System.in);
		numN = in.nextInt();//takes in number of nodes
		graph = new int[numN +1][numN +1];//makes graph with spaces 0 to numN inclusive
		for(int srcV= 1; srcV <= numN; srcV++){
			for(int destV= 1; destV <= numN; destV++){
				graph[srcV][destV]= in.nextInt();//populate graph with lines of ints
			}
		}
		source= in.nextInt();//takes in source after graph
		sink = in.nextInt();
		BlackMarketOil oilSell = new BlackMarketOil(numN);
		maxFlow = oilSell.networkFlow(graph, source, sink); // here 1
		System.out.println("The Max flow in the graph is " + maxFlow);
		in.close();
	}
}
