package TB;

import Entity.Graphs.EdgeWeightedGraph;
import Entity.Graphs.Path.DijkstraSPT;

import java.io.*;

/**
 * Created by Konstantin on 10.01.2017.
 */
public class DijkstraTest {
    public static void main(String[] args) {

        try {
            BufferedReader bi = new BufferedReader(new FileReader("src/input/input07.txt"));
            //BufferedReader bi = new BufferedReader(new InputStreamReader(System.in));
            String []twoLine = new String[3];
            String []threeLine = new String[2];
                int N = stoi(bi.readLine());
                for(int i=0; i<N; i++){
                    long timeOfRead = System.nanoTime();
                    threeLine = bi.readLine().split("\\s");
                    int Nodes = stoi(threeLine[0]);
                    int Edges = stoi(threeLine[1]);
                    EdgeWeightedGraph anEWG = new EdgeWeightedGraph(Nodes + 1);

                    for(int j=0; j<Edges; j++){
                        twoLine = bi.readLine().split("\\s");
                        int v = stoi(twoLine[0]);
                        int w = stoi(twoLine[1]);
                        int weight = stoi(twoLine[2]);
                        anEWG.AddEdge(v, w, weight);
                    }

                    int src = stoi(bi.readLine());
                    timeOfRead = System.nanoTime() - timeOfRead;

                    long timeB4Dij = System.nanoTime();
                    DijkstraSPT pathSearch = new DijkstraSPT(anEWG, src);
                    long timeB4Print = System.nanoTime() - timeB4Dij;
                    pathSearch.PrintDistances();
                    System.out.println(timeB4Print/1e9);
                    System.out.println(timeOfRead/1e9);
                }
            }
            catch(IOException e){
                e.printStackTrace();
            }
    }

    private static int stoi(String s){
        int result = 0;
        for(int i=0; i<s.length(); i++){
            result = result*10 + s.charAt(i) - '0';
        }
        return result;
    }
}
