//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass
{
    public static void main(String args[]) throws IOException {

        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String str[] = read.readLine().trim().split(" ");
            int V = Integer.parseInt(str[0]);
            int E = Integer.parseInt(str[1]);

            ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<ArrayList<ArrayList<Integer>>>();
            for(int i=0;i<V;i++)
            {
                adj.add(new ArrayList<ArrayList<Integer>>());
            }

            int i=0;
            while (i++<E) {
                String S[] = read.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                int w = Integer.parseInt(S[2]);
                ArrayList<Integer> t1 = new ArrayList<Integer>();
                ArrayList<Integer> t2 = new ArrayList<Integer>();
                t1.add(v);
                t1.add(w);
                t2.add(u);
class Solution {
    class Node {
        int dis;
        int node;
        Node(int dis, int node) {
            this.dis = dis;
            this.node = node;
        }
    }
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S) {
        PriorityQueue<Node> pq = new PriorityQueue<Node>((x, y) -> x.dis - y.dis);
        pq.add(new Solution().new Node(0, S));
        int[] distance = new int[V];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[S] = 0;

        while(!pq.isEmpty()) {
            Node node = pq.poll();
            int dis = node.dis;
            int vertex = node.node;
            for (ArrayList<Integer> neighbor : adj.get(vertex)) {
                int adjNode = neighbor.get(0);
                int edgeWeight = neighbor.get(1);
                if (dis + edgeWeight < distance[adjNode]) {
                    distance[adjNode] = dis + edgeWeight;
                    pq.add(new Solution().new Node(distance[adjNode], adjNode));
                }
            }
        }

        return distance;
    }
}
