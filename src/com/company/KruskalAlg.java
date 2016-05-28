package com.company;


import java.net.ConnectException;
import java.util.*;

import static java.util.Collections.min;


public class KruskalAlg implements Algorithm{
    HashSet<Conection> minTree;
    HashSet<Vertex> visited;
    public KruskalAlg(){
        minTree = new HashSet<Conection>();
        visited = new HashSet<Vertex>();

    }

    @Override
    public boolean isCycle(Conection c){
        int score = 0;

        for(Vertex x : visited) {
            if (x == c.getA()){
                ++score;
            }
            if (x == c.getB()){
                ++score;
            }
        }
        if(visited.size()<2){
            return false;
        }
        if(score == 2){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public HashSet<Conection> solveAlg(AbstractGraph graph) {
        HashSet<Conection> temp = graph.getAllConections();
        Conection min_connection = min(temp);
        minTree.add(min_connection);
        visited.add(min_connection.getA());
        visited.add(min_connection.getB());
        while(visited.size() < graph.vertexNr()) {
            HashSet<Conection> not_known_connections = new HashSet<>();
            for (Conection c : temp) {
                if (!(minTree.contains(c) || isCycle(c))) {
                    not_known_connections.add(c);
                }
            }
            Conection min_conn = min(not_known_connections);
            minTree.add(min_conn);
            visited.add(min_conn.getA());
            visited.add(min_conn.getB());
        }
        return minTree;
    }
}
