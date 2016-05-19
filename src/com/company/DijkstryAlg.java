package com.company;

import java.util.*;

public class DijkstryAlg implements Algorithm{
    List<Vertex> tree = new ArrayList<Vertex>();
    List<Vertex> visited = new ArrayList<Vertex>();
    Set<Conection> allCon = new HashSet<Conection>();
    @Override
    public HashSet<Conection> solveAlg(AbstractGraph graph) {
        HashSet<Conection> temp = graph.getAllConections();
        List<Conection> myTree = new ArrayList<Conection>(temp);
        Collections.sort(myTree);
        
        return null;
    }
}
