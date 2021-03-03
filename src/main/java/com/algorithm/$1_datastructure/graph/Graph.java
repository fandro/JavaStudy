package com.algorithm.$1_datastructure.graph;

import java.util.LinkedList;

/**
 * 无向图.
 *
 * @author fuwb
 * @since 2021-03-03
 */
public class Graph {

    // 顶点的个数
    private int v;
    // 邻接表
    private LinkedList<Integer> adj[];

    public void Graph(int v) {
        this.v = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    /**
     * 无向图一条边存两次.
     * @param s
     * @param t
     */
    public void addEdge(int s,int t) {
        adj[s].add(t);
        adj[t].add(s);
    }

}
