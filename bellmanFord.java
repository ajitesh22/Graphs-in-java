import java.lang.reflect.Array;
import java.util.*;

class Node {

    private int u;
    private int v;
    private int weight;

    Node(int _u ,int _v ,int w){
        u = _u;
        v = _v;
        weight = w;
    }

    Node() {}


    int getU() {return u;}
    int getV() {return v;}
    int getWeight(){return weight;};

}


 class Graph2 {

    // To find minimum distance from source to all other nodes
    void bellmanFord(ArrayList<Node> edges , int N ,int src){

        int dist[] = new int[N];
        for(int i=0;i<N;i++)
            dist[i] = 10000 ;

        dist[src] = 0;

        for(int i=1;i<N;i++){
            for(Node node : edges){
                if(dist[node.getU()] + node.getWeight() < dist[node.getV()])
                    dist[node.getV()] = dist[node.getU()] + node.getWeight();
            }
        }

        //To check if negative cycle present run a loop once check if dist values are still reducing then negative edge present

        boolean isNegCyclePresent = false;

        for(Node node : edges){
            if(dist[node.getU()] + node.getWeight() < dist[node.getV()]){
                isNegCyclePresent = true;
                break;
            }
        }

        if(!isNegCyclePresent){
            for(int i=0;i<N;i++){
                System.out.println(i + " "+dist[i]);
            }
        }




    }

    public static void main(String args[]){


        int N = 6;
        ArrayList<Node> adj = new ArrayList<Node>();

        adj.add(new Node(3, 2, 6));
        adj.add(new Node(5, 3, 1));
        adj.add(new Node(0, 1, 5));
        adj.add(new Node(1, 5, -3));
        adj.add(new Node(1, 2, -2));
        adj.add(new Node(3, 4, -2));
        adj.add(new Node(2, 4, 3));

        Graph2 obj = new Graph2();
        obj.bellmanFord(adj,N,0);

    }



}
