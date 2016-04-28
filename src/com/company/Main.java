package com.company;

import com.sun.corba.se.impl.orbutil.graph.Graph;

import java.net.ConnectException;
import java.util.HashSet;

public class Main {

    public static void main(String[] args) {
        AbstractGraph graph = new MatrixGraph(3);
        graph.addConection(new Conection(new Vertex(0),new Vertex(1),10));
        graph.addConection(new Conection(new Vertex(1),new Vertex(2),10));
        HashSet<Conection> s = graph.getAllConections();
        if(s.size() != 2){
            System.out.println("nok");
        }
        GraphSaver saver = new GraphSaver(graph);
        saver.saveToFile("/home/user/graph");
//        int distance;
//        distance = graph.getDistance(new Vertex(1),new Vertex(2));
//        if(distance != 10){
//            System.out.println("nok");
//        }
//        distance = graph.getDistance(new Vertex(2),new Vertex(1));
//        if(distance != 10){
//            System.out.println("nok");
//        }
//        graph.removeConection(new Conection(new Vertex(1), new Vertex(2),-1));
//        distance = graph.getDistance(new Vertex(2),new Vertex(1));
//        if(distance != -1 ){
//            System.out.println("nok");
//        }
//        distance = graph.getDistance(new Vertex(1),new Vertex(2));
//        if(distance != -1 ){
//            System.out.println("nok");
//        }
    }
}
