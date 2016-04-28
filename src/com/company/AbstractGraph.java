package com.company;

import java.util.ArrayList;
import java.util.HashSet;

public interface AbstractGraph {
    public void addConection(Conection c);
    public int getDistance(Vertex a, Vertex b);
    public ArrayList<Conection> getConections(Vertex uno);
    public HashSet<Conection> getAllConections();
    public void removeConection(Conection conection);
}
