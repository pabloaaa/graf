package com.company;

import java.util.*;

public class DijkstryAlg implements Algorithm{
    HashSet<Vertex> q;
    HashSet<Vertex> p;

    public DijkstryAlg(){
        q = new HashSet<Vertex>();
        p = new HashSet<Vertex>();
    }

    @Override
    public boolean isCycle(Conection c) {
        return false;
    }

    @Override
    public HashSet<Conection> solveAlg(AbstractGraph graph) {

        return null;
    }
}
