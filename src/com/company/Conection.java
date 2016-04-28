package com.company;

import java.net.ConnectException;

public class Conection {
    private Vertex A;
    private Vertex B;
    private int length;
    public Conection(Vertex A, Vertex B, int length){
        this.A = A;
        this.B = B;
        this.length = length;
    }

    public Vertex getB() {
        return B;
    }

    public Vertex getA() {
        return A;
    }
    public int getLength(){
        return length;
    }

    @Override
    public boolean equals(Object obj) {
        Conection c = (Conection) obj;
        return (c.getA().getNr() == getA().getNr() &&
                c.getB().getNr() == getB().getNr())
                ||
                (c.getA().getNr() == getB().getNr() &&
                c.getB().getNr() == getA().getNr())
                && c.getLength() == getLength();
    }

    @Override
    public int hashCode() {
        return A.getNr() * B.getNr()*17 + length*19;
    }

    @Override
    public String toString() {
        return String.valueOf(getA().getNr()) + " " +
                String.valueOf(getB().getNr()) + " " +
                String.valueOf(getLength());
    }
}
