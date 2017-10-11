package com.learnings;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    //Vertices
    private int V;
    //Adjacency List representation
    private LinkedList<Integer> adj[];

    BFS(int v) {
        V = v;
        adj = new LinkedList[V+1];
        //declaring linkedList corresponding to every vertex
        for(int i=0;i<V+1;i++) {
            adj[i] = new LinkedList();
        }

    }

    //function to add edge between two nodes x and y by adding y to linkedList adj[x] as per adjacency list repr.
    void addEdge(int x,int y) {
        adj[x].add(y);
        //adj[y].add(x);
    }

    void PrintTraversal(int s) {
       //for marking the nodes after visiting
        boolean visited[] = new boolean[V+1];

        //For BFS we need a queue
        Queue<Integer> Q = new LinkedList<Integer>();

        //Marking current node as visited and enqueuing
        visited[s] = true;
        Q.add(s);

        while(Q.size() != 0) {
            //Dequeue the element and print it
            s = Q.poll();
            System.out.println(s + " ");
            //Iterate over the list corresponding to dequeued element(All adjacent nodes to current node)
            Iterator<Integer> i = adj[s].listIterator();

            while(i.hasNext()) {
                int x = i.next();
                //if the node is not visited, then mark it as visited
                visited[x] = true;
                //enqueue in the Q
                Q.add(x);
            }

        }


    }

    public static void main(String args[]) {
        BFS g = new BFS(6);
        g.addEdge(4,1);
        g.addEdge(1,0);
        g.addEdge(0,2);
        g.addEdge(2,3);
        g.addEdge(2,5);
        g.addEdge(5,3);
        //Passing head
        g.PrintTraversal(4);
    }

}
