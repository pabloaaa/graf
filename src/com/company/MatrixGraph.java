package com.company;

import java.util.ArrayList;
import java.util.HashSet;

public class MatrixGraph implements AbstractGraph {
    int[][] graph;
    int size;
    private final int NOT_CONNECTED = -1;
    public MatrixGraph(int size){
        this.size = size;
        graph = new int[size][size];
        for(int i = 0 ; i < size; ++i){
            for(int j = 0 ; j < size; ++j) {
                graph[i][j] = NOT_CONNECTED;
            }
        }
    }
    @Override
    public void addConection(Conection c) {
        graph[c.getA().getNr()][c.getB().getNr()] = c.getLength();
        graph[c.getB().getNr()][c.getA().getNr()] = c.getLength();
    }
    @Override
    public void removeConection(Conection c){
        graph[c.getA().getNr()][c.getB().getNr()] = -1;
        graph[c.getB().getNr()][c.getA().getNr()] = -1;
    }
    @Override
    public ArrayList<Conection> getConections(Vertex uno){
        ArrayList<Conection> tmp = new ArrayList<Conection>();
        for(int i = 0 ; i < graph.length; ++i){
            if(graph[uno.getNr()][i] != -1){
                Conection con = new Conection(new Vertex(uno.getNr()),new Vertex(i), graph[uno.getNr()][i]);
                tmp.add(con);
            }
        }
        return tmp;

    }

    @Override
    public HashSet<Conection> getAllConections() {
        HashSet<Conection> c = new HashSet<>();
        for(int i = 0 ; i < size; ++i){
            for(int j = 0 ; j < size; ++j) {
                int distance = graph[i][j];
                if( distance != -1){
                    c.add(new Conection(new Vertex(i), new Vertex(j), distance));
                }
            }
        }
        return c;
    }

    @Override
    public int getDistance(Vertex uno, Vertex dos){
        return graph[uno.getNr()][dos.getNr()];
    }
}
