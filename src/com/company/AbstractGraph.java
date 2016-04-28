package com.company;

import java.util.HashSet;

public interface AbstractGraph {
    public void addConection(Conection c);
    public int getDistance(Vertex a, Vertex b);
    public HashSet<Conection> getConections(Vertex uno);
    public HashSet<Conection> getAllConections();
    public void removeConection(Conection conection);
}
