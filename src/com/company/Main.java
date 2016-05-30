package com.company;

import java.util.HashSet;


import java.util.HashSet;

import static java.lang.System.currentTimeMillis;

public class Main {

    public static void main(String[] args) {

//        AbstractGraph graph = new GraphGenerator().generateMatrixGraph(500, 50);
        Algorithm alg = new KruskalAlg();
//        Algorithm alg = new PrimeAlg();
        HashSet<Conection> Tree;
        AbstractGraph graph = new GraphGenerator().generateMatrixGraph(500,100);
        long start,end,delta;


        start = currentTimeMillis();
        Tree = alg.solveAlg(graph);
        end = currentTimeMillis();
        delta = end - start;
        System.out.println(Tree.toString());
        System.out.println(delta);
    }


//        int [] vertexNr = {10,50,100,500,1000};
//        int [] density = {25,50,75,100};


//        for(int i = 0 ; i < 5 ; i++){
//            for(int j = 0 ; j < 4 ; j++){
//                start = 0;
//                end = 0;
//                AbstractGraph graph = new GraphGenerator().generateListGraph(vertexNr[i],density[j]);
//                System.out.println("graf wygenerowany:");
//                System.out.println("vertex_number= "+vertexNr[i]+",density= "+density[j]);
//                start = currentTimeMillis();
//                Tree = alg.solveAlg(graph);
//                end = currentTimeMillis();
//                delta = end - start;
//                System.out.println(Tree.toString());
//                System.out.println(delta);
//            }
//        }





//        GraphReader reader = new GraphReader(graph);
//        graph = reader.loadFromFile("/home/user/loader");

//        GraphSaver saver = new GraphSaver(graph);
//        saver.saveToFile("/home/user/graph");












//        graph.addConection(new Conection(new Vertex(0),new Vertex(1),10));
//        graph.addConection(new Conection(new Vertex(1),new Vertex(2),10));
//        HashSet<Conection> s = graph.getAllConections();
//        if(s.size() != 2){
//            System.out.println("nok");
//        }

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


