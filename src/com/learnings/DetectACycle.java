package com.learnings;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

//Detecting a cycle in an undirected graph
public class DetectACycle {
    //vertices
    private int V;
    private int flag = 0;
    private LinkedList<Integer> adj[];
    boolean visited[];
    DetectACycle(int v) {
        V=v;
        adj = new LinkedList[V+1];
        for(int i = 0;i<V+1;i++)
            adj[i] = new LinkedList();
        visited = new boolean[V+1];
    }

    void addEdge(int x, int y) {
        adj[x].add(y);
    }


   
    public boolean detectACycle() {
        for(int i=0;i<V+1;i++) {
            Iterator<Integer> itr = adj[i].listIterator();
            while(itr.hasNext()) {
                int s = itr.next();
              if(!visited[s])
                  visited[s] = true;
              else{
                  flag = 1;
                  break;
              }

            }
            if(flag == 1) {
                return true;
            }
        }
        return false;
    }

    public static void main(String args[]) {
        DetectACycle g = new DetectACycle(6);
        g.addEdge(4,1);
        g.addEdge(4,0);
        g.addEdge(1,0);
        g.addEdge(0,2);
        g.addEdge(2,3);
        g.addEdge(2,5);

        System.out.println(g.detectACycle());

    }
}
