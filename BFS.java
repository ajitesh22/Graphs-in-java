import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class graph {


   public static ArrayList<Integer> bfsTraversal(int V, ArrayList<ArrayList<Integer>> adj){

        ArrayList<Integer> bfs = new ArrayList<Integer>();
        boolean visited[] = new boolean[V+1];
        for(int i=1;i<=V;i++){
            if(!visited[i]){
                Queue<Integer> queue = new LinkedList<Integer>();
                queue.add(i);
                visited[i] = true;

                while(!queue.isEmpty()){
                    Integer node = queue.poll();
                    bfs.add(node);

                    for(Integer neighbor : adj.get(node)){
                        if(!visited[neighbor]){
                            queue.add(neighbor);
                            visited[neighbor]= true;
                        }
                    }

                }
            }
        }

        return bfs;
    }

    public static void main(String args[]){

        int n = 3, m = 3;

        ArrayList<ArrayList<Integer>> adj = new  ArrayList<ArrayList<Integer>> ();

        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<Integer>());
        }
        adj.get(1).add(2);
        adj.get(2).add(1);


        adj.get(2).add(3);
        adj.get(3).add(2);


        adj.get(1).add(3);
        adj.get(3).add(1);

        for(int i=0;i<=n;i++){
            for(int j=0;j<adj.get(i).size();j++){
                System.out.println(adj.get(i).get(j) + " ");
            }
            System.out.println();

        }

        ArrayList<Integer> bfs = bfsTraversal(3,adj);
        for(int i=0;i<n;i++){
            System.out.println(bfs.get(i) + " ");

        }

    }

}
