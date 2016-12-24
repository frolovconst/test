package Entity.Graphs.MST;

import Entity.DStructs.UF;
import Entity.Graphs.Edge;
import Entity.Graphs.EdgeWeightedGraph;
import Entity.SortingAlgos.Sorting;

import java.util.LinkedList;

/**
 * Created by Konstantin on 24.12.2016.
 */
public class KruskalMST{
    private LinkedList<Edge> mst;

    public KruskalMST(EdgeWeightedGraph e){
        mst = new LinkedList<>();
        Edge []allEdges = new Edge[e.E()];
        int E = e.E();
        int V = e.V();
        int i = 0;
        for(Edge iterator : e.edges()){
            allEdges[i] = iterator;
            i++;
        }
        Sorting.QuickSort(allEdges);
        UF strucUF = new UF(V);
        for(i=0; i<E; i++){
            Edge eIterator = allEdges[i];
            int v = eIterator.either();
            int w = eIterator.other(v);
            if(strucUF.Find(v) == strucUF.Find(w))
                continue;
            else{
                mst.add(eIterator);
                strucUF.Merge(v, w);
            }
            if(mst.size() == V-1)
                break;
        }
    }

    public int CountMSTCost(){
        int cost = 0;
        for(Edge eIterator : mst)
            cost += eIterator.weight();
        return cost;
    }
}
