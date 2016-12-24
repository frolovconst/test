package Entity.Graphs;

import java.util.LinkedList;

/**
 * Created by Konstantin on 24.12.2016.
 */
public class EdgeWeightedGraph{
    final int V;
    int E;
    LinkedList<Edge>[]adj;

    public EdgeWeightedGraph(int V){
        this.V = V;
        adj = (LinkedList<Edge> []) new LinkedList[V];
        for(int i=0; i<V; i++)
            adj[i] = new LinkedList<Edge>();
    }

    public void AddEdge(int v, int w, int weight){
        Edge e = new Edge(v, w, weight);
        adj[v].add(e);
        adj[w].add(e);
        this.E++;
    }

    public int V(){
        return this.V;
    }

    public int E(){
        return this.E;
    }

    public Iterable<Edge> edges(){
        LinkedList<Edge> edges = new LinkedList<>();
        for(int i=0; i<V; i++){
            for(Edge eIterator : this.adj[i]){
                if(eIterator.other(i) > i)
                    edges.add(eIterator);
            }
        }
        return edges;
    }
}