package Entity.Graphs;

import java.util.LinkedList;

/**
 * Created by Konstantin on 24.12.2016.
 */
public class EdgeWeightedGraph{
    final int V;
    int E;
    LinkedList<Edge> []adj;

    public EdgeWeightedGraph(int V){
        this.V = V;
        this.E = 0;
        adj = (LinkedList<Edge> []) new LinkedList[V];
        for(int i=0; i<V; i++)
            adj[i] = new LinkedList<Edge>();
    }

    public void AddEdge(int v, int w, int weight){
//        for(Edge eIterator : adj[v]){
//            if(eIterator.other(v) == w)
//                if( eIterator.weight() > weight) {
//                    //System.out.println("1b4rem" + " " + adj[v].size());
//                    adj[v].remove(eIterator);
//                    adj[w].remove(eIterator);
//                    Edge e = new Edge(v, w, weight);
//                    adj[v].add(e);
//                    adj[w].add(e);
//                    return;
//                    //System.out.println("rem" + " " + adj[v].size());
//                }
//                else
//                    return;
//        }
//        Edge e = new Edge(v, w, weight);
//        adj[v].add(e);
//        adj[w].add(e);
//        this.E++;
        if(!adj[v].isEmpty()) {
            Edge eIterator = adj[v].getFirst();
//        for(Edge eIterator : adj[v]){
            if (eIterator.other(v) == w) {
                if (eIterator.weight() > weight) {
                    eIterator.setWeight(weight);
//                    adj[v].remove(eIterator);
//                    adj[w].remove(eIterator);
//                    Edge e = new Edge(v, w, weight);
//                    adj[v].addFirst(e);
//                    adj[w].addFirst(e);
                    return;
                } else
                    return;
            }
//            break;
//        }
        }
        Edge e = new Edge(v, w, weight);
        adj[v].addFirst(e);
        adj[w].addFirst(e);
        this.E++;
    }

    public void AddEdge(Edge e){
        int v = e.either();
        int w = e.other(v);
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

    public LinkedList<Edge> adj(int index){
        return this.adj[index];
    }
}