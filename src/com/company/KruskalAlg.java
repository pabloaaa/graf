package com.company;


import java.util.*;


public class KruskalAlg implements Algorithm{
    HashSet<Conection> minTree;
    public KruskalAlg(){
        minTree = new HashSet<Conection>();
    }


    @Override
    public HashSet<Conection> solveAlg(AbstractGraph graph) {
        List<Vertex> visited = new ArrayList<Vertex>();
        HashSet<Conection> temp = graph.getAllConections();
        List<Conection> myTree = new ArrayList<Conection>(temp);
        Collections.sort(myTree);
        System.out.println(myTree.toString());

        for(Conection c : myTree){
            if(minTree.isEmpty()){
                minTree.add(c);
                visited.add(c.getA());
                visited.add(c.getB());
            }else {
                for (Conection con : minTree) {
                    for(Vertex v : visited ){
                        if (    con.getA() != v || con.getB() == v &&
                                con.getA() == v || con.getB() != v ){
                            minTree.add(c);
                        }
                    }
                }
            }
        }
        return null;
    }
}
