package com.learnings;

import java.util.*;
/**program to find number of disconnected nodes i.e. nodes which can't be reached from a
 * given node in an undirected graph.
 * Implementation of classic DEPTH FIRST TRAVERSAL algorithm
 *
 * **/
class Graph {
    //number of vertices
    private int V;
    //Array of linkedList for Adjacency List representation
    private LinkedList<Integer>adj[];
    //number of connected nodes from head node
    private int connected = 0;
    Graph(int v) {
        V = v;
        //v+1 taken to avoid runtime exception caused due to no space in array for last element
        adj = new LinkedList[v+1];
        //declaring linkedList corresponding to every vertex
        for(int i=0;i<v+1;i++) {
            adj[i] = new LinkedList();
        }

    }
    //function to add edge between two nodes x and y by adding y to linkedList adj[x] as per adjacency list repr.
    void addEdge(int x,int y) {
        adj[x].add(y);
    }

    //function which takes in the head node and calls DFS which traverses the connected component in graph recursively
    void DFS(int head) {
        //visited boolean array maintained to keep track of visited nodes and to avoid infinite looping
        boolean visited[] = new boolean[V+1];
        if(visited[head] == false)
            DFS(head,visited);

        System.out.println(V-connected);
    }

    void DFS(int v, boolean visited[]) {
        //Mark the node at v as visited and increment count of connected
        visited[v] = true;
        connected++;
        //LinkedList Iterator to Recursively traverse all adjacent nodes of v
        Iterator<Integer> itr = adj[v].listIterator();

        while(itr.hasNext()) {
            int x = itr.next();
            if(visited[x] == false)
                DFS(x,visited);
        }
    }


    public static void main(String args[]) {

        System.out.println("Enter data:");
        Scanner s = new Scanner(System.in);
        int nodes = s.nextInt();
        int edges = s.nextInt();

        Graph g = new Graph(nodes);
        for(int i=0;i<edges;i++) {
            int a = s.nextInt();
            int b = s.nextInt();

            g.addEdge(a,b);
        }

        int head = s.nextInt();

        g.DFS(head);

    }
}
