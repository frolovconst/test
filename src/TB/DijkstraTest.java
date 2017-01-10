package TB;

import Entity.Graphs.EdgeWeightedGraph;

import java.io.*;

/**
 * Created by Konstantin on 10.01.2017.
 */
public class DijkstraTest {
    public static void main(String[] args) {

        try {
            BufferedReader readTest7 = new BufferedReader(new FileReader("src/input/input07.txt"));
            String frst = readTest7.readLine();
            System.out.println(frst);
            frst = readTest7.readLine();
            System.out.println(frst);
        } catch (IOException e) {
            e.printStackTrace();
        }
//        BufferedReader bi = new BufferedReader(new InputStreamReader(System.in));
//        String []twoLine = new String[3];
//        String []threeLine = new String[2];
//        try{
//            int N = stoi(bi.readLine());
//            for(int i=0; i<N; i++){
//                threeLine = bi.readLine().split("\\s");
//                int Nodes = stoi(threeLine[0]);
//                int Edges = stoi(threeLine[1]);
//                EdgeWeightedGraph anEWG = new EdgeWeightedGraph(Nodes + 1);
//
//                for(int j=0; j<Edges; j++){
//                    twoLine = bi.readLine().split("\\s");
//                    int v = stoi(twoLine[0]);
//                    int w = stoi(twoLine[1]);
//                    int weight = stoi(twoLine[2]);
//                    anEWG.AddEdge(v, w, weight);
//                }
//
//                int src = stoi(bi.readLine());
//                DijkstraSPT pathSearch = new DijkstraSPT(anEWG, src);
//                pathSearch.PrintDistances();
//            }
//        }
//        catch(IOException e){
//            e.printStackTrace();
//        }
    }

    private static int stoi(String s){
        int result = 0;
        for(int i=0; i<s.length(); i++){
            result = result*10 + s.charAt(i) - '0';
        }
        return result;
    }
}
