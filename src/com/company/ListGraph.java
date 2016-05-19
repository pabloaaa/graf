package com.company;


import java.util.*;

public class ListGraph implements AbstractGraph {
    Map<Vertex,HashSet<Conection>> graph;

    public ListGraph(){
        graph = new HashMap<Vertex,HashSet<Conection>>();
    }
    @Override
    public void addConection(Conection c) {
        if(graph.containsKey(c.getA())){
            HashSet<Conection> tmp = graph.get(c.getA());
            tmp.add(c);
        }else{
            HashSet<Conection> con = new HashSet<Conection>();
            con.add(c);
            graph.put(c.getA(),con);
        }
        if(graph.containsKey(c.getB())){
            HashSet<Conection> tmp = graph.get(c.getB());
            tmp.add(c);
        }else{
            HashSet<Conection> con = new HashSet<Conection>();
            con.add(c);
            graph.put(c.getB(),con);
        }
    }

    @Override
    public int getDistance(Vertex uno, Vertex dos) {
        if(graph.containsKey(uno)){
            HashSet<Conection> connections = graph.get(uno);
            for(Conection c: connections){
                if( (c.getA().equals(uno) && c.getB().equals(dos)) ||
                    (c.getA().equals(dos) && c.getB().equals(uno)) ){
                    return c.getLength();
                }
            }
            return -1;
        }else{
            System.out.println("Nie ma takiego polaczenia");
            return -1;
        }
    }
    @Override
    public HashSet<Conection> getConections(Vertex uno){
        if(graph.containsKey(uno)){
            return graph.get(uno);
        }else{
            return null;
        }
    }
    @Override
    public void removeConection(Conection conection) {
        if(graph.containsKey(conection.getA())){
            HashSet<Conection> tmp = graph.get(conection.getA());
            for(Conection c: tmp){
                if(c.getA().equals(conection.getA()) && c.getB().equals(conection.getB()) ||
                        c.getA().equals(conection.getB()) && c.getB().equals(conection.getA())){
                    tmp.remove(c);
                }
            }
        }else{
            System.out.println("nie ma polaczenia");
        }
        if(graph.containsKey(conection.getB())){
            HashSet<Conection> tmp = graph.get(conection.getB());
            for(Conection c: tmp){
                if(c.getA().equals(conection.getA()) && c.getB().equals(conection.getB()) ||
                        c.getA().equals(conection.getB()) && c.getB().equals(conection.getA())){
                    tmp.remove(c);
                }
            }
        }else{
            System.out.println("nie ma polaczenia");
        }
    }

    @Override
    public HashSet<Conection> getAllConections() {
        HashSet<Conection> all_connections = new HashSet<>();
        Set<Vertex> keys = graph.keySet();
        for(Vertex k: keys){
            HashSet<Conection> tmp = graph.get(k);
            for(Conection c: tmp){
                all_connections.add(c);
            }
        }
        return all_connections;
    }

    @Override
    public int vertexNr(){
        Set<Vertex> keys = graph.keySet();
        return keys.size();
    }




}







