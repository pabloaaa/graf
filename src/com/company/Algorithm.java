package com.company;

import java.util.HashSet;

public interface Algorithm {
    public HashSet<Conection> solveAlg(AbstractGraph graph);
    public boolean isCycle(Conection c);
}
