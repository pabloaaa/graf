package com.company;


import java.net.ConnectException;
import java.util.*;

import static java.util.Collections.min;


public class PrimeAlg implements Algorithm {
    HashSet<Conection> minTree;
    HashSet<Vertex> visited;
    public PrimeAlg(){
        minTree = new HashSet<>();
        visited = new HashSet<>();
    }

    @Override
    public boolean isCycle(Conection c){
        int score = 0;

        if(visited.size()<2){
            return false;
        }

        for(Vertex x : visited) {
            if (c.getA() == x || c.getB() == x) {
                ++score;
            }
        }

        if (score == 2){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public HashSet<Conection> solveAlg(AbstractGraph graph){
        HashSet<Conection> temp = graph.getAllConections();
        add_to_min_tree(min(temp));

        while(visited.size() != graph.vertexNr()) {
            Conection min_connection = null;
            HashSet<Conection> not_know_connections = new HashSet<>();
            for (Vertex v : visited) {
                HashSet<Conection> conn_from_current_vertex = graph.getConections(v);
                for (Conection c : conn_from_current_vertex) {
                    if (!minTree.contains(c)) {
                        not_know_connections.add(c);
                    }
                }
            }
            min_connection = min(not_know_connections);
            assert min_connection != null;
            add_to_min_tree(min_connection);
            visited.add(min_connection.getB());
        }

        return minTree;
    }

    private void add_to_min_tree(Conection c) {
        minTree.add(c);
        visited.add(c.getA());
        visited.add(c.getB());
    }

}
