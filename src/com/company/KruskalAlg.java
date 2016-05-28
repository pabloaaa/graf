package com.company;


import java.util.*;


public class KruskalAlg implements Algorithm{
    HashSet<Conection> minTree;
    HashSet<Vertex> visited;
    public KruskalAlg(){
        minTree = new HashSet<Conection>();
        visited = new HashSet<Vertex>();

    }

    @Override
    public boolean isLooping(Conection c){
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
            return true;
        }
        if(score == 2){
            return false;
        }else{
            return true;
        }
    }

    @Override
    public HashSet<Conection> solveAlg(AbstractGraph graph) {
        HashSet<Conection> temp = graph.getAllConections();
        List<Conection> myTree = new ArrayList<Conection>(temp);
        Collections.sort(myTree);

        for(Conection c : myTree){
            if(minTree.isEmpty()){
                minTree.add(c);
                visited.add(c.getA());
                visited.add(c.getB());
            }else{
                for (Vertex v : visited) {
                    if (    c.getA() == v && isLooping(c) ||
                            c.getB() == v && isLooping(c) ||
                            c.getA() != v && c.getB() != v && isLooping(c)) {
                        minTree.add(c);
                    }
                }
                visited.add(c.getA());
                visited.add(c.getB());
            }
        }
        return minTree;
    }
}
