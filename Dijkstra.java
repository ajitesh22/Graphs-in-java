import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

class Node implements Comparator<Node> {

    private int v;
    private int weight;
    Node(int _v , int _weight){
        v = _v;
        weight = _weight;
    }

    int getV(){
        return v;
    }
    int getWeight(){
        return weight;
    }

    @Override
    public int compare(Node node1 , Node node2){

        if(node1.weight < node2.weight)
            return -1;
        if(node1.weight > node2.weight)
            return 1;
        return 0;
    }


}

public class Graph3 {

    void shortestPathUsingDijkstra(int s , ArrayList<ArrayList<Node>> adj , int N){

         int dist[] = new int[N];
         for(int i=0;i<N;i++)dist[i] = 1000000;
         dist[s] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<Node>(N , new Node());
        pq.add(new Node(s,0));
        while(pq > 0){
            Node node = pq.poll();
            for(Node it : adj.get(node.getV())){
                if(dist[node.getV()] + it.getWeight() < dist[it.getV()]){
                    dist[it.getV()] = dist[node.getV()] + it.getWeight();
                    pq.add(new Node(it.getV() , dist[it.getV()]));
                }

            }
        }

        for(int i=0;i<N;i++)
            System.out.println(dist[i] + " ");



    }

    public static  void main(String args[]) {

        int n = 5;
        ArrayList<ArrayList<Node>> adj = new ArrayList<ArrayList<Node>>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<Node>());
        }

        adj.get(0).add(new node(1, 2));
        adj.get(1).add(new node(0, 2));

        adj.get(1).add(new node(2, 4));
        adj.get(2).add(new node(1, 4));

        adj.get(0).add(new node(3, 1));
        adj.get(3).add(new node(0, 1));

        adj.get(3).add(new node(2, 3));
        adj.get(2).add(new node(3, 3));

        adj.get(1).add(new node(4, 5));
        adj.get(4).add(new node(1, 5));

        adj.get(2).add(new node(4, 1));
        adj.get(4).add(new node(2, 1));

        Graph3 obj = new Graph3();
        obj.shortestPathUsingDijkstra(0, adj, n);
    }
}
