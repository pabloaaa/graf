package com.company;


public class Vertex {
    int  nr;
    public Vertex(int nr){
        this.nr = nr;
    }

    @Override
    public boolean equals(Object other) {
        Vertex v = (Vertex) other;
        return nr == v.nr;
    }

    @Override
    public int hashCode() {
        return nr;
    }

    public int getNr() {
        return nr;
    }

    @Override
    public String toString() {
        return "VERTEX(" + getNr() + ")";
    }
}
